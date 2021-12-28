#Build Stage
FROM maven:3.6.0-jdk-11-slim AS build
COPY . /opt/tattle
ENTRYPOINT ["sh", "/opt/tattle/startup.sh"]