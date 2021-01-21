#!/bin/sh
mvn clean package && docker build -t sankethv/exam-client .
docker rm -f exam-client 2>/dev/null || true && docker run -it --name exam-client -p 8080:8080 -p 4848:4848 -p 8181:8181 --name exam-client sankethv/exam-client
