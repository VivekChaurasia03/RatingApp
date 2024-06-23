# Microservices Rating App

This repository contains a microservices-based application for managing ratings, with multiple services built using Spring Boot.

## Services

1. **User Service**: User service that fetches details of rating and hotel from their respective services.
2. **Rating Service**: Rating service for CRUD operations related to rating of a hotel.
3. **Hotel Service**: Hotel service for CRUD operations related to the details of the hotel.
4. **Service Registry**: Eureka acts as a service registry in a microservices architecture, and each microservice (which is a client) registers itself with the Eureka server. This allows the microservices to discover each other dynamically at runtime.
