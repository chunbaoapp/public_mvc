FROM FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
RUN mkdir /opt/test
COPY ${JAR_FILE} /opt/test/event-gui.jar
CMD ["java", "-jar", "/opt/test/event-gui.jar"]