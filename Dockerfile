FROM adoptopenjdk/openjdk11:ubi
ARG WAR_FILE=target/*.jar
RUN mkdir /opt/test
COPY ${WAR_FILE} /opt/test/test.jar
CMD ["java", "-jar", "/opt/test/test.jar"]