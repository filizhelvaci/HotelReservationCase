package com.example.hotelservice.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class HotelsSummaryResponse {

    private Long id;
    private Integer name;
}
