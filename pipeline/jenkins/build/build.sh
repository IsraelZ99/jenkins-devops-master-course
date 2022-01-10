#!/bin/bash

# Copy the new jar to the build location
cp -f Initialize-Spring-Boot-Security-Jwt/target/*.jar jenkins/build/

echo "**********************************"
echo "***** Building Docker Images *****"
echo "**********************************"

cd jenkins/build && docker-compose -f docker-compose-build.yml build --no-cache
