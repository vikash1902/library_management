package com.example.pyramid.entity;

import com.example.pyramid.customAnnotation.NumberComparison;
import com.example.pyramid.utility.ValidationRegexUtil;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.Data;


import java.sql.Timestamp;

@Table(name = "book_master")
@Entity
@Data
@NumberComparison(firstNumber = "totalCopies", secondNumber = "availableCopies", message = "Available number of copy can not be greater total number of copy.")
public class Books {

    @Id
    @Column(name = "book_id")
    @NotNull(message = "Book id can not be null.")
    @NotBlank(message = "Book id can not be blank.")
    @Size(max = 500,message = "Size can not be greater than 500 character.")
    @Pattern(regexp = ValidationRegexUtil.ALPHA_NUMERIC_UPPER_CASE, message = "Please enter valid book id, it only contain alphanumeric in upper case")
    private String bookId;

    @Column(name = "title")
    @NotNull(message = "Tittle can not be null.")
    @NotBlank(message = "Tittle can not be blank.")
    @Size(max = 500,message = "Size can not be greater than 255 character.")
    @Pattern(regexp = ValidationRegexUtil.ALPHA_NUMERIC_SPECIAL_CHARACTER, message = "Please enter valid title it contain alphanumeric value with special character (i.e. Godaan - Edition 168). ")
    private String title;

    @Column(name = "author")
    @NotNull(message = "Author can not be null.")
    @NotBlank(message = "Author can not be blank.")
    @Size(max = 255,message = "Size can not be greater than 255 character.")
    @Pattern(regexp = ValidationRegexUtil.NAME, message = "Please enter valid author it contain alphabet with special character (i.e. R.K. Narayan). ")
    private String author;

    @Column(name = "genre")
    @Size(max = 100,message = "Size can not be greater than 100 character.")
    @Pattern(regexp = ValidationRegexUtil.ALPHABET_WITH_SPACE, message = "Please enter valid genre it contain alphabet with space (i.e. Fiction). ")
    private String genre;

    @Column(name = "publisher")
    @Size(max = 255,message = "Size can not be greater than 255 character.")
    @Pattern(regexp = ValidationRegexUtil.ALPHABET_WITH_SPACE, message = "Please enter valid publisher it contain alphabet with space (i.e. Indian Thought Publications). ")
    private String publisher;

    @Column(name = "isbn")
    @Size(max = 20,message = "Size can not be greater than 20 character.")
    @Pattern(regexp = ValidationRegexUtil.NUMBER, message = "Please enter valid isbn it contain number (i.e. 1234). ")
    private String isbn;

    @Column(name = "book_language")
    @Size(max = 50,message = "Size can not be greater than 50 character.")
    @Pattern(regexp = ValidationRegexUtil.ALPHABET_WITHOUT_SPACE, message = "Please enter valid language of book it contain alphabet (i.e. Hindi).")
    private String bookLanguage;

    @Column(name = "total_copies")
    @Size(min = 1,message = "Total copies must be greater than 0")
    private int totalCopies;

    @Column(name = "available_copies")
    @Size(min = 0,message = "Total copies can not be in negative")
    private int availableCopies;

    @Column(name = "shelf_location")
    @Size(max = 100,message = "Size can not be greater than 100 character.")
    @Pattern(regexp = ValidationRegexUtil.ALPHA_NUMERIC_SPECIAL_CHARACTER, message = "Please enter valid shelf location it contain alphabet with special character (i.e. Shelf-B1). ")
    private String shelfLocation;

    @Column(name = "is_deleted")
    private boolean deleted;

    @Column(name = "deleted_at")
    @PastOrPresent(message = "Book must be deleted in past or present timestamp")
    private Timestamp deletedAt;

    @Column(name = "created_at")
    @PastOrPresent(message = "Book must be created in past or present timestamp")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @PastOrPresent(message = "Book must be updated in past or present timestamp")
    private Timestamp updatedAt;



}
