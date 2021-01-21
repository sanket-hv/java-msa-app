#!/bin/sh
#deploy="false"
deploy="true"

image=exam-service
version=1.0-SNAPSHOT
latest=true

#OPTIONS="--no-cache --force-rm"
#OPTIONS="--no-cache"
#OPTIONS="--force-rm"
OPTIONS=""

docker build ${OPTIONS} -t sankethv/${image}:1.0-SNAPSHOT .
if [ "$?" -eq 0 ] && [ ${deploy} == "true" ]; then
    docker push sankethv/${image}:1.0-SNAPSHOT
    if [ "$latest" == "true" ]; then
        docker tag sankethv/${image}:1.0-SNAPSHOT sankethv/${image}:latest
        docker push sankethv/${image}:latest
    fi
fi