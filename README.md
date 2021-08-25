# Service Virtualization
To build new release version of Docker Image for Service virtualization. It supports #OpenAPI, #AsyncAPI(Kafka and AMQ).

##  Install service virtualization - Docker compose:
	version: "3.7"
	services:
	  virtualization:
		image: docker.io/virtualan/service-virtualization:1.0
		ports:
		  - "8800:8800"
		environment:
		  - SPRING_PROFILES_ACTIVE=run
		volumes:
		    - ./conf:/conf:rw
## Home Page:
	http://microservices.virtualandemo.com:8800/virtualan-ui
## OpenAPI
## Add OpenAPI: 
	http://microservices.virtualandemo.com:8800/swagger-ui.html#/virtual-service-controller/createVirtualanApisUsingPOST 

## Remove OpenAPI: 
	http://microservices.virtualandemo.com:8800/swagger-ui.html#/virtual-service-controller/deleteVirtualanApisUsingDELETE

## OpenAPI
### AddSetup Kakfa: 
	https://tutorials.virtualan.io/#/SV_kafka

### To SetupAMQ: 
	https://tutorials.virtualan.io/#/SV_amq
