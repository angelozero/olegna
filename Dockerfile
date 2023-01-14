FROM openjdk:17
EXPOSE 8080
ADD target/olegna-docker.jar olegna-docker.jar
ENTRYPOINT ["java", "-jar", "/olegna-docker.jar"]