package org.sopt36th.sopthackathon.global.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.sopt36th.sopthackathon.global.error.ErrorCode;
import org.springframework.http.HttpStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponse<T>(HttpStatus status, String message, T result) {

    public ApiResponse(HttpStatus status, String message) {
        this(status, message, null);
    }

    public ApiResponse(ErrorCode errorCode) {
        this(errorCode.getStatus(), errorCode.getMessage(), null);
    }
}
