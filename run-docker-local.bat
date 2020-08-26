@echo off

if "%major%" == "" (
      echo "major is empty. Setting it to default 0."
      set major=0)


if "%minor%" == "" (
      echo "minor is empty. Setting it to default 0."
      set minor=0)


if "%BUILD_NUMBER%" == "" (
      echo "BUILD_NUMBER is empty. Setting it to default 1."
      set BUILD_NUMBER=1)

echo "check project home"
if NOT EXIST "%project_home%" (
      echo "project_home dir is empty. Setting it to default ."
      set project_home=.)
      
set project_home=%project_home%

START /WAIT "gradle build" CMD /c gradle clean build -Pmajor=%major% -Pminor=%minor% -PBUILD_NUMBER=%BUILD_NUMBER%

echo "build number-%BUILD_NUMBER%, project_home-%project_home%"


rem ######################################
rem  helpful for debugging 
rem ######################################

docker-compose config

docker-compose build --build-arg major=%major% --build-arg minor=%minor% --build-arg BUILD_NUMBER=%BUILD_NUMBER%

docker-compose up






