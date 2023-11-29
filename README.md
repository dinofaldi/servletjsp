# Java Servlet and JSP

## Author

Name: Achmad Dinofaldi Firmansyah

## Description

This is a simple Java Servlet and JSP project.

## Prerequisite

1. Visual Studio Code
2. Docker

## How to run

1. Clone this repository
2. Open this project with Visual Studio Code
3. Run command `./runtomcat.bat`
4. Open browser and go to `http://localhost:8888/servletjsp`

## Run manually

1. Clone this repository
2. Open this project with Visual Studio Code
3. Run command `mvn clean package`
4. Run command `docker build -t tomcat .`
5. Run command `docker run -it --rm -p 8888:8080 tomcat`
6. Open browser and go to `http://localhost:8888/servletjsp`

## Login Credentials

1. Username: `admin`
2. Password: `admin`