package com.books.bookapp.controller;

import com.books.bookapp.models.BookItem;
import com.books.bookapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/allbooks")
    public List<BookItem> getallBooks(){
        List<BookItem> temp = bookRepository.findAll();
        temp.forEach(book->{System.out.println(book);});
        return temp;
    }
    @GetMapping("/:{id}")
    public List<BookItem> getBookById(@PathVariable("id") int id){
        return this.bookRepository.findAllById(Collections.singleton(id));
    }
    @GetMapping("/search/{title}")
    public List<BookItem> getBookById(@PathVariable("title") String title){
        List<BookItem> temp = bookRepository.getBooks(title.toLowerCase()+" "," "+title.toLowerCase());
        return temp;
    }
}
