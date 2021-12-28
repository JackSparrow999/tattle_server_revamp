#!/bin/bash

cd /opt/tattle
mvn clean package
java -jar /opt/tattle/target/chat_server-0.0.1-SNAPSHOT.jar