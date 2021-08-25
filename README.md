# service-virtualization
To build new version of release Docker Image for Service virtualization. To Support #OpenAPI,  #AsyncAPI(Kafka and AMQ).

##  Install service virtualization

### Docker compose:

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

## Upload Open API: 
	
	http://microservices.virtualandemo.com:8800/swagger-ui.html#/virtual-service-controller/createVirtualanApisUsingPOST 

## Remove Open API: 

	http://microservices.virtualandemo.com:8800/swagger-ui.html#/virtual-service-controller/deleteVirtualanApisUsingDELETE


