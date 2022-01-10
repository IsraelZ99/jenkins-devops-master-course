#!/bin/bash

echo "*****************"
echo "**Pushing image**"
echo "*****************"

IMAGE="maven-project"

echo "****************"
echo "***Logging in***"
echo "****************"
docker login -u znitch23 -p $PASS

echo "*******************"
echo "***Tagging image***"
echo "*******************"
docker tag $IMAGE:$BUILD_TAG znitch23/$IMAGE:$BUILD_TAG

echo "*******************"
echo "***Pushing image***"
echo "*******************"
docker push znitch23/$IMAGE:$BUILD_TAG
