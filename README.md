

# Virtualan - Service Virtualization  ![Docker Image Version (tag latest semver)](https://img.shields.io/docker/v/virtualan/service-virtualization/2.0?style=social)
Simplified way to setup Service virtualization using Docker Image. It supports #OpenAPI, #AsyncAPI(Kafka and AMQ).

## Video Tutorial

[![Service Virtualization](https://img.youtube.com/vi/otTjbPxT0W8/0.jpg)](https://youtu.be/otTjbPxT0W8)

## Installation
### 1. Prerequisite
- Install docker
  https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-debian-10

### 2. Initial setup
- Setup application profile as "live"

- Navigate to the installation directory in the Linux server.
  >  mkdir virtualization

- Create conf directory under virtualization directory

- Create application-**live**.properties with appropriate profile with below information inside conf folder

  	server.port=8800  
  	virtualan.application.name=Service Virtualization Demo
  	virtualan.datasource.driver-class-name=org.hsqldb.jdbcDriver
  	virtualan.datasource.jdbc-url=jdbc:hsqldb:mem:dataSource
  	virtualan.datasource.username=sa
  	virtualan.datasource.password=
### 3. Docker-compose config
Create docker-compose.yml with appropriate profile with following instruction in the setup virtualization directory

	version: "3.7"
	services:
	  virtualization:
		image: docker.io/virtualan/service-virtualization:2.0
		ports:
		  - "8800:8800"
		environment:
		  - SPRING_PROFILES_ACTIVE=live
		volumes:
		    - ./conf:/conf:rw
### 4. Start Service
> sudo docker-compose up -d

### 5. Logs
> sudo docker-compose logs
## Home Page
	> URL: http://<hostname>:8800/virtualan-ui
		
		http://microservices.virtualandemo.com:8800/virtualan-ui

## OpenAPI
- Add
  > http://microservices.virtualandemo.com:8800/swagger-ui.html#/virtual-service-controller/createVirtualanApisUsingPOST

- Remove
  > http://microservices.virtualandemo.com:8800/swagger-ui.html#/virtual-service-controller/deleteVirtualanApisUsingDELETE

## AsyncAPI
- Setup Kafka
  https://tutorials.virtualan.io/#/SV_kafka

- Setup MQTT
  https://tutorials.virtualan.io/#/SV_mqtt

- Setup AMQ
  https://tutorials.virtualan.io/#/SV_amq
