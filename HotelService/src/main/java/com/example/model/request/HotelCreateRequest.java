package com.example.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelCreateRequest {

    @NotBlank
    @Size(min = 1, max = 50)
    private String name;

    @NotBlank
    @Size(min = 1, max = 1000)
    private String address;

    @NotNull
    @Range(min = 0, max = 5)
    private Integer starRating;

    private List<Long> roomIds;

}
