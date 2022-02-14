#
# Build stage
#
FROM adoptopenjdk/maven-openjdk11 AS build
LABEL maintainer="info@virtualan.io"
COPY . /home/app/
RUN mvn -f /home/app/pom.xml clean install

#
# GCS Mount stage
#
FROM golang:1.17.6-alpine as gcsfuse
RUN apk add --no-cache git
ENV GOPATH /go
RUN go get -u github.com/googlecloudplatform/gcsfuse
RUN apk add --no-cache ca-certificates fuse

#
# Package stage
#
FROM adoptopenjdk/openjdk11:alpine
COPY --from=build /home/app/lib  /openapi/virtualan/lib
COPY --from=build /home/app/target/virtualan-virtualization.jar /openapi/virtualan/virtualan-virtualization.jar
COPY --from=gcsfuse /go/bin/gcsfuse /usr/local/bin

ENTRYPOINT ["java", "-cp", "./conf:/conf:/openapi/virtualan/virtualan-virtualization.jar", "-Dloader.main=io.virtualan.Virtualization",  "org.springframework.boot.loader.PropertiesLauncher"]
