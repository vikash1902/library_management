package com.example.pyramid.model;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PaginationData {

    @NotNull(message = "Page number cannot be null.")
    @Min(value = 0, message = "Page number cannot be negative.")
    private int pageNumber;

    @NotNull(message = "Page size cannot be null.")
    @Min(value = 1, message = "Number of records per page must be at least 1.")
    private int size;
}
