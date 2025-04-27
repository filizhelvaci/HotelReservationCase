package com.example.model.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HotelsResponse {

    private Long id;
    private String name;
    private String address;
    private int starRating;

}

