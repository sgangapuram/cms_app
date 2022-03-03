FROM openjdk:8
ENV APP_HOME=/usr/app
WORKDIR $APP_HOME
COPY target/cms-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8181
ENTRYPOINT ["java", "-jar", "app.jar"]