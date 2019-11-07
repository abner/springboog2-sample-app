#!/bin/sh
docker run --rm --name some-postgres -p 5432:5432 -e POSTGRES_PASSWORD=admin -d postgres