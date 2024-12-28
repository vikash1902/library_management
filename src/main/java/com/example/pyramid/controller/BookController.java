package com.example.pyramid.controller;

import com.example.pyramid.entity.Books;
import com.example.pyramid.model.PaginationData;
import com.example.pyramid.service.BookService;
import com.example.pyramid.utility.ErrorCodeClass;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PreAuthorize("hasRole('PUBLIC')")
    @GetMapping("/allRecords")
    @Operation(summary = "Get the list of all book present in inventory.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully returned all book data.", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Books.class))}),
            @ApiResponse(responseCode = "404", description = "Data not found", content = @Content)})
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<Books>> fetchAllBooks() {
        return new ResponseEntity<>(bookService.fetchAllBook(), HttpStatusCode.valueOf(ErrorCodeClass.SUCCESS));
    }

    @PreAuthorize("hasRole('PUBLIC')")
    @PostMapping("/records")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Page<Books>> fetchBooks(@Valid @RequestBody PaginationData paginationData){
//        throw  new CustomException("You are not allowed to divide a number with 0.", HttpStatus.INTERNAL_SERVER_ERROR);
       return new ResponseEntity<>(bookService.fetchBooksByPage(paginationData.getPageNumber(),paginationData.getSize()), HttpStatusCode.valueOf(ErrorCodeClass.SUCCESS));
    }

}
