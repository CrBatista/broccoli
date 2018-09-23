FROM openjdk:8-jdk-alpine
MAINTAINER codecentric.de
VOLUME /tmp
EXPOSE 8761

ENV USER_NAME monitoring
ENV APP_HOME /home/$USER_NAME/app

RUN adduser -D -u 1000 $USER_NAME
RUN mkdir $APP_HOME

ADD ["target/broccoli-eureka-server-0.0.1-SNAPSHOT.jar" ,"$APP_HOME/broccoli-eureka-server.jar"]
RUN chown $USER_NAME $APP_HOME/broccoli-eureka-server.jar

USER $USER_NAME
WORKDIR $APP_HOME
RUN touch broccoli-eureka-server.jar

ENTRYPOINT ["java","-jar","broccoli-eureka-server.jar"]
