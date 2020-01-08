#!bin/bash
echo "DB host ${DB_HOST}"
echo "DB_PORT  ${DB_PORT}"
echo "DB_SCHEMA  ${DB_SCHEMA}"
export DB_HOST=${DB_HOST}
export DB_PORT=${DB_PORT}
export DB_SCHEMA=${DB_SCHEMA}
java -jar /opt/app/warmup-${major}.${minor}_${BUILD_NUMBER}.jar -DDB_HOST=${DB_HOST} -DDB_PORT=${DB_PORT} -DDB_SCHEMA=${DB_SCHEMA}