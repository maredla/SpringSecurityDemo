FROM openjdk:8
ADD target/docker-securityDemo.jar docker-securityDemo.jar .
EXPOSE 8089
ENTRYPOINT ["java","-jar","docker-securityDemo.jar"]