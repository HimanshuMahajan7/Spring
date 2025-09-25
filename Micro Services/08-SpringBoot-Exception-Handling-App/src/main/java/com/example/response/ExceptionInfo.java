package com.example.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ExceptionInfo {

    private String code;
    private String message;
    private LocalDateTime timestamp;

}
