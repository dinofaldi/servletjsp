# Use the official Tomcat base image
FROM tomcat:9

# Copy the WAR file containing the servlet JSP application to the Tomcat webapps directory
COPY ./target/servletjsp.war /usr/local/tomcat/webapps/

# Expose the default Tomcat port
EXPOSE 8080

# Start Tomcat when the container starts
CMD ["catalina.sh", "run"]
