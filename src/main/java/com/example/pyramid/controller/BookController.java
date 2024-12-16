package com.example.pyramid.controller;

import com.example.pyramid.entity.Books;
import com.example.pyramid.model.PaginationData;
import com.example.pyramid.service.BookService;
import com.example.pyramid.utility.ErrorCodeClass;
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
    public ResponseEntity<List<Books>> fetchAllBooks() {
        return new ResponseEntity<>(bookService.fetchAllBook(), HttpStatusCode.valueOf(ErrorCodeClass.SUCCESS));
    }

    @PreAuthorize("hasRole('PUBLIC')")
    @GetMapping("/records")
    public ResponseEntity<Page<Books>> fetchBooks(@Valid @RequestBody PaginationData paginationData){
       return new ResponseEntity<>(bookService.fetchBooksByPage(paginationData.getPageNumber(),paginationData.getSize()), HttpStatusCode.valueOf(ErrorCodeClass.SUCCESS));
    }

}
