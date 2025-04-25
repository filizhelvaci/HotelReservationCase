package com.example.hotelservice.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class HotelRsResponse<T> {

    @Builder.Default
    private LocalDateTime time = LocalDateTime.now();

    @Builder.Default
    private Boolean isSuccess = true;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T response;

    public static <T> HotelRsResponse<T> success() {
        return HotelRsResponse.<T>builder().isSuccess(true).build();
    }

    public static <T> HotelRsResponse<T> successOf(final T response) {
        return HotelRsResponse.<T>builder()
                .response(response).build();
    }
}
