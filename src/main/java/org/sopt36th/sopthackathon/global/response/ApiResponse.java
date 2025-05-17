package org.sopt36th.sopthackathon.global.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.sopt36th.sopthackathon.global.error.ErrorCode;
import org.springframework.http.HttpStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponse<T>(HttpStatus code, String message, T data) {

    public ApiResponse(HttpStatus code, String message) {
        this(code, message, null);
    }

    public ApiResponse(ErrorCode errorCode) {
        this(errorCode.getStatus(), errorCode.getMessage(), null);
    }
}
