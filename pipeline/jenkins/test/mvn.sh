#!/bin/bash

echo "*****************************"
echo "****** Testing the code *****"
echo "*****************************"

WORKSPACE=/home/decsefi99/Documents/Courses/Udemy-courses/jenkins/jenkins_home/workspace/pipeline-docker-maven

docker run --rm -v $WORKSPACE/Initialize-Spring-Boot-Security-Jwt:/app -v /root/.m2/:/root/.m2/ -w /app maven:3.8.3-openjdk-17 "$@"
