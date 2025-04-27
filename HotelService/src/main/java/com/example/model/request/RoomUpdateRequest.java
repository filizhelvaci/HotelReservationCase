package com.example.model.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomUpdateRequest {

    @NotNull
    @Range(min = 1, max = 10000)
    private String roomNumber;

    @NotNull
    @Range(min = 0, max = 100)
    private Integer capacity;

    @NotNull
    @Range(min = 0, max = 10_000_000)
    private BigDecimal pricePerNight;

    @NotNull
    @Range(min = 0)
    private Long hotelId;

}

