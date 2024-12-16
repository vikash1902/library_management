package com.example.pyramid.service;

import com.example.pyramid.entity.Books;
import com.example.pyramid.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Books> fetchAllBook(){
        return bookRepo.findAll();
    }

    public Page<Books> fetchBooksByPage(int pageNumber, int size){
        Pageable pageable = PageRequest.of(pageNumber, size);
        return  bookRepo.findAll(pageable);
    }



}
