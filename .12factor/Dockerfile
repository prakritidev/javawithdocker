# FROM openjdk:8-jdk-alpine
# VOLUME /tmp
# ARG JAVA_OPTS
# ENV JAVA_OPTS=$JAVA_OPTS
# COPY target/demo-0.0.1-SNAPSHOT.jar demo.jar
# COPY src/main/resources/application-hirist-production.properties application-hirist-production.properties
# RUN "ls"
# EXPOSE 9001
# # ENTRYPOINT exec java $JAVA_OPTS -jar demo.jar
# # For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
# ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar -Dspring.profiles.active=hirist-production demo.jar

FROM openjdk:8-jdk-alpine as builder
RUN mkdir -p /app/source
COPY . /app/source
WORKDIR /app/source
RUN ./mvnw clean package -DskipTests=true

# COPY src/main/resources/application-hirist-production.properties /app/application-hirist-production.properties
# FROM openjdk:8

# COPY --from=builder /usr/src/app/target/demo-0.0.1-SNAPSHOT.jar /app/demo-0.0.1-SNAPSHOT.jar
# COPY --from=builder /usr/src/main/resources/application-hirist-production.properties /app/application-hirist-production.properties

# RUN "cd /usr/app"
FROM openjdk:8-jdk-alpine as runtime

COPY --from=builder /app/source/target/*.jar /app/app.jar
COPY --from=builder /app/source/src/main/resources/application-hirist-production.properties /app/application-hirist-production.properties

ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
EXPOSE 9001
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar -Dspring.profiles.active=hirist-production /app/app.jar

# ENTRYPOINT ["java", "-cp", "/usr/app/demo-0.0.1-SNAPSHOT.jar", "com.scalabledeveloper.multistagebuild.App"]







