package com.books.bookapp.repository;

import com.books.bookapp.models.BookItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<BookItem,Integer> {

    @Query(value = "select * from books b where lower(b.title) LIKE %?1% or lower(b.title) like %?2%",nativeQuery = true)
    List<BookItem> getBooks(String title1,String title2);

}
