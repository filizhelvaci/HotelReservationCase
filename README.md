# HOTEL RESERVATION CASE

### 
This application is a standalone Spring Boot application with Microservice Architecture for real-time hotel reservation. The system provides the following basic features that allow reservations to be made by selecting the room and hotel:

Basic Features
Hotel and room selection: The user selects the hotel and room and enters the dates he/she wants to make a reservation.
Reservation check: It is checked whether the hotel room requested for reservation is reserved on the specified dates.
Reservation completion: If the room is open for reservation on the date the reservation is requested, the reservation is created.
MVC Architecture: It supports easy-to-maintain and test-driven development with model, view and control layers.

_*Framework*_
* _Core_
    - *Spring*
        + Spring Boot 3
        + Spring Boot Dev Tools
        + Spring Web

    - *Spring Data*
        + Spring Data JPA

_*3rd Party Dependencies*_
* _Lombok_
* _Mapstruct_

_*Database*_
* _PostgreSql_

_*Language*_
* _Java 17_

_*Build Tool*_
* _Gradle_

_*Version Control*_
* _Git_
* _GitHub_

_*APIs Interaction Platform*_
* _Postman_

## Postman
 [Workspace](https://www.postman.com/filizkh/workspace/case-hotel-reservation)

## Running All Components as Container on Docker

The following command can be executed to stand up the application and database on Docker. Then the application can be run and proceed.

`docker compose up -d --build`

The following command can be used to remove Docker Containers.

`docker compose down -v`

## Running PostgreSQL Container on Docker

The following command can be executed to stand up the database on Docker. Then the application can be run and proceed.

### For Hotel Service:

`docker compose up -d --build hotel-service-db`

### For Reservation Service:

`docker compose up -d --build reservation-service-db`

## Running Application Container on Docker

### For Hotel Service:

`docker compose up -d --build hotel-service`

### For Reservation Service:

`docker compose up -d --build reservation-service`
