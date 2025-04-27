FROM gradle:8.11-jdk17 AS build

WORKDIR /app

COPY build.gradle .
COPY settings.gradle .
COPY HotelService/build.gradle ./HotelService/
COPY HotelService/src ./HotelService/src

RUN gradle HotelService:build -x test

FROM amazoncorretto:17.0.12-al2023

WORKDIR /app

COPY --from=build /app/HotelService/build/libs/*.jar hotel_r_case.jar

EXPOSE 8094

ENTRYPOINT ["java", "-jar", "hotel_r_case.jar"]
