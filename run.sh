cd broccoli-eureka-client-google
mvn clean package -DskipTest

cd ../broccoli-eureka-client-itunes
mvn clean package -DskipTest

cd ../broccoli-eureka-server
mvn clean package -DskipTest

cd ../monitoring && docker-compose up