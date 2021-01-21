#!/bin/sh
mvn clean package
docker build -t sankethv/exam-client .
