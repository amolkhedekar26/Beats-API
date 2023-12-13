package com.alibou.security.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class GenericResponse<T> {
    private boolean success;
    private String message;
    private int statusCode;
    private T data;

    public static <T> GenericResponse<T> empty() {
        return success(null,"", 500);
    }

    public static <T> GenericResponse<T> success(T data, String message, int statusCode) {
        return GenericResponse.<T>builder()
                .statusCode(statusCode)
                .message(message)
                .data(data)
                .success(true)
                .build();
    }

    public static <T> GenericResponse<T> error(String message, int statusCode) {
        return GenericResponse.<T>builder()
                .statusCode(statusCode)
                .message(message)
                .success(false)
                .build();
    }
}