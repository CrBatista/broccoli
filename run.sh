cd broccoli-eureka-client-google
mvn clean package -DskipTests

cd ../broccoli-eureka-client-itunes
mvn clean package -DskipTests

cd ../broccoli-eureka-server
mvn clean package -DskipTests

cd ../broccoli-eureka-client-authentication
mvn clean package -DskipTests

cd ../monitoring && docker-compose up