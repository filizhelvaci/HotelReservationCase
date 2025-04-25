FROM gradle:8.11-jdk17 AS build

WORKDIR /app

COPY build.gradle .
COPY settings.gradle .
COPY RoomService/build.gradle ./RoomService/
COPY RoomService/src ./RoomService/src

RUN gradle RoomService:build

FROM amazoncorretto:17.0.12-al2023

WORKDIR /app

COPY --from=build /app/RoomService/build/libs/*.jar hotel_r_case.jar

EXPOSE 8092

ENTRYPOINT ["java", "-jar", "hotel_r_case.jar"]
