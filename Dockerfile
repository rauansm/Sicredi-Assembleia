FROM 966432988823.dkr.ecr.us-east-1.amazonaws.com/openjdk:11-stable

LABEL maintainer="rauanmor@gmail.com"

WORKDIR /app

COPY target/sicredi-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

CMD ["/app/startup.sh", "-jar", "sicredi-0.0.1-SNAPSHOT.jar"]