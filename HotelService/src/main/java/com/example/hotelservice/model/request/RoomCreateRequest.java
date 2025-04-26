package com.example.hotelservice.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
public class RoomCreateRequest {

    @NotBlank
    @Size(min = 1, max = 8)
    @Pattern(regexp = "^[0-9]+$", message = "Oda numarası sadece rakamlardan oluşmalıdır.")
    private String roomNumber;

    @NotNull
    @Range(min = 0, max = 100)
    private Integer capacity;

    @NotNull
    @Range(min = 0, max = 10_000_000)
    private BigDecimal pricePerNight;

    @NotNull
    @Min(1)
    private Long hotelId;

}
