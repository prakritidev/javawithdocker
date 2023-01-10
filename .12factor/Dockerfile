FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/demo-0.0.1-SNAPSHOT.jar demo.jar
COPY src/main/resources/application-hirist-production.properties application-hirist-production.properties
RUN "ls"
EXPOSE 9001
# ENTRYPOINT exec java $JAVA_OPTS -jar demo.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar -Dspring.profiles.active=hirist-production demo.jar

# FROM openjdk:8-jdk-alpine
# VOLUME /tmp
# ARG JAVA_OPTS
# ENV JAVA_OPTS=$JAVA_OPTS
# COPY . /tmp
# WORKDIR /tmp
# RUN "ls"
# RUN "mvn clean compile"
# RUN "ls"
# ADD /target/demo-0.0.1-SNAPSHOT.jar demo.jar
# EXPOSE 9001
# # ENTRYPOINT exec java $JAVA_OPTS -jar demo.jar
# # For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
# ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar -Dspring.profiles.active=hirist demo.jar
