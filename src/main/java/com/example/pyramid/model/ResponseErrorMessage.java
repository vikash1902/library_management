package com.example.pyramid.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class ResponseErrorMessage {

    private String status;
    private int  errorCode;
    private List<Map<String,String>> errorDetails;
}