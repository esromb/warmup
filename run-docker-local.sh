#!bin/bash

project_home=~/Downloads
if [ -z "$major" ]
then
      echo "\$major is empty. Setting it to default 0."
      major=0
fi

export major=${major}

if [ -z "$minor" ]
then
      echo "\$minor is empty. Setting it to default 0."
      minor=0
fi
export minor=${minor}

if [ -z "$BUILD_NUMBER" ]
then
      echo "\$BUILD_NUMBER is empty. Setting it to default 1."
      BUILD_NUMBER=1
fi
export BUILD_NUMBER=${BUILD_NUMBER}

if [ -z "$project_home" ]
then
      echo "\$project_home dir is empty. Setting it to default ."
      project_home=~/
fi
export project_home=${project_home}

gradle clean build -Pmajor=${major} -Pminor=${minor} -PBUILD_NUMBER=${BUILD_NUMBER}

echo "build number-${BUILD_NUMBER}"

docker-compose build --build-arg major=${major} --build-arg minor=${minor} --build-arg BUILD_NUMBER=${BUILD_NUMBER}

docker-compose up






