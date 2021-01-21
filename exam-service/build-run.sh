#!/bin/sh
mvn clean package && docker build -t sankethv/exam-service .
docker rm -f exam-service 2>/dev/null || true && docker run -it --name exam-service -p 8080:8080 -p 4848:4848 -p 8181:8181 --name exam-service sankethv/exam-service
