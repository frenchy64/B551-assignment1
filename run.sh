#!/bin/sh

if [ ! -f target/B551assignment1-0.0.1-SNAPSHOT.jar ]; then
  mvn clean package
fi

java -jar target/B551assignment1-0.0.1-SNAPSHOT.jar
