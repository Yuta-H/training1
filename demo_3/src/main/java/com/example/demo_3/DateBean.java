package com.example.demo_3;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;


public class DateBean {

    @JsonFormat(pattern = "yyyMM/dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyy/MMM/dd HH:mm:ss")
    private LocalDateTime jsonLocalDateTime;
    public LocalDateTime getJsonLocalDateTime(){
        return jsonLocalDateTime;
    }

    public void setJsonLocalDateTime(LocalDateTime jsonLocalDateTime) {
        this.jsonLocalDateTime = jsonLocalDateTime;
    }
}
