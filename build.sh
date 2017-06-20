#!/bin/bash

cd $(dirname $0)
cd service-registry
./mvnw clean install

cd ..
cd event-service
./mvnw clean install

cd ..
cd calendar-service
./mvnw clean install
