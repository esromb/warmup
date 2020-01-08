FROM adoptopenjdk/openjdk8:latest
RUN mkdir /opt/app
ARG major
ARG minor
ARG BUILD_NUMBER
USER root
COPY build/libs/warmup-${major}.${minor}_${BUILD_NUMBER}.jar /opt/app/
RUN touch  /opt/app/warmup-${major}.${minor}_${BUILD_NUMBER}.jar
ENV major=${major}
ENV minor=${minor}
ENV BUILD_NUMBER=${BUILD_NUMBER}
COPY ./entrypoint.sh /
CMD /bin/bash entrypoint.sh 