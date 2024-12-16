package com.example.pyramid.repo;

import com.example.pyramid.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Books,String> {
}
