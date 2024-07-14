# Rating Application

## Project Overview

The Rating Application is a microservices-based project implemented in Java. It demonstrates the integration of multiple services to create a cohesive application where users can rate hotels. This project utilizes several key technologies and frameworks to ensure scalability, reliability, and maintainability.

## Architecture

The architecture of the Rating Application is centered around the following components:

-   **User Service**: The central service responsible for managing user information. It fetches details from the Hotel Service using RestTemplate and from the Rating Service using Feign Client.
-   **Hotel Service**: Manages hotel information and utilizes PostgreSQL as its database.
-   **Rating Service**: Handles the ratings given by users to hotels, utilizing MongoDB as its database.
-   **API Gateway**: Acts as an entry point for all client requests, routing them to the appropriate services.
-   **OKTA Auth**: Provides authentication services to secure the API Gateway.
-   **Config Service**: Manages configuration across all services.
-   **Service Registry**: Enables service discovery to ensure that services can locate and communicate with each other.

## Database

-   **User Service**: MySQL
-   **Hotel Service**: PostgreSQL
-   **Rating Service**: MongoDB

## Workflow

1. **User Interaction**: Users interact with the application through the client, which sends requests to the API Gateway.
2. **Authentication**: The API Gateway uses OKTA Auth for authentication to ensure secure access.
3. **Service Calls**:
    - When a user is fetched, the User Service makes an internal call to the Rating Service to get the ratings given by the user.
    - The User Service also calls the Hotel Service to get details of the hotels for which the ratings have been given.
4. **Data Aggregation**: The User Service aggregates the data from the Hotel and Rating services to present a comprehensive view of the user’s interactions and ratings.

## Key Technologies

-   **Spring Boot**: Used for building and managing microservices.
-   **Spring Cloud**: Provides tools for service discovery (Service Registry), configuration management (Config Service), and more.
-   **RestTemplate**: Utilized by the User Service to communicate with the Hotel Service.
-   **Feign Client**: Utilized by the User Service to communicate with the Rating Service.
-   **PostgreSQL, MySQL, MongoDB**: Databases used by the Hotel Service, User Service, and Rating Service respectively.

## Use Case

The application manages users, hotels, and ratings. Users can rate hotels, and these ratings are stored and managed by the Rating Service. The User Service consolidates user information along with their ratings and the associated hotels, providing a comprehensive view of user activity.

## Conclusion

The Rating Application showcases the implementation of a microservices architecture with Java, emphasizing secure authentication, efficient data handling, and seamless inter-service communication. This project serves as an example of building scalable and maintainable applications using modern technologies and best practices.
