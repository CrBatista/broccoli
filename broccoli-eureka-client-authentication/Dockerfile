FROM openjdk:8-jdk-alpine
MAINTAINER codecentric.de
VOLUME /tmp
EXPOSE 8086

ENV USER_NAME monitoring
ENV APP_HOME /home/$USER_NAME/app

RUN adduser -D -u 1000 $USER_NAME
RUN mkdir $APP_HOME

ADD ["target/broccoli-eureka-client-authentication-0.0.1-SNAPSHOT.jar" ,"$APP_HOME/broccoli-eureka-client-authentication.jar"]
RUN chown $USER_NAME $APP_HOME/broccoli-eureka-client-authentication.jar

USER $USER_NAME
WORKDIR $APP_HOME
RUN touch broccoli-eureka-client-authentication.jar

ENTRYPOINT ["java","-jar","broccoli-eureka-client-authentication.jar"]
