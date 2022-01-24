package com.example.test.globalexceptionhandling;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class RespondRequest {
    
    private String message;
    private LocalDateTime localDate;
}
