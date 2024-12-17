package com.example.pyramid.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class ValidationErrorMessage {
    private List<Map<String,String>> errorDetails;
}