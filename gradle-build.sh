#!/bin/sh

set -ex

export $(cat .env | xargs)
./gradlew jibDockerBuild