@echo off

REM Remove existing Tomcat Docker image
docker image rm tomcat

REM Clean and package the Maven project
call mvn clean package

REM Build a new Tomcat Docker image
docker build -t tomcat .

REM Run the Tomcat Docker container
docker run -it --rm -p 8888:8080 tomcat
