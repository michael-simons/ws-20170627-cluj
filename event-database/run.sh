#!/bin/bash
docker run --name events-db -e POSTGRES_USER=events-db -e POSTGRESS_PASSWORD=events-db -p 5432:5432 -d postgres
