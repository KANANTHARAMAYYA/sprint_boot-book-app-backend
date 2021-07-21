package com.books.bookapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "Books")
public class BookItem {
    @Id
    private int bookid;
    @Column(name = "title", length = 100000)
    private String title;
    @Column(name = "authors", length = 10000)
    private String authors;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "language_code")
    private String language_code;
    @Column(name = "average_rating",length = 1000)
    private String average_rating;
    @Column(name = "ratings_count")
    private String ratings_count;
    @Column(name = "price")
    private String price;

    public BookItem() {

    }

    public BookItem(int bookid, String title, String authors, String isbn, String language_code, String average_rating, String ratings_count, String price) {
        super();
        this.bookid = bookid;
        this.title = title;
        this.authors = authors;
        this.isbn = isbn;
        this.language_code = language_code;
        this.average_rating = average_rating;
        this.ratings_count = ratings_count;
        this.price = price;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getLanguage_code() {
        return language_code;
    }

    public void setLanguage_code(String language_code) {
        this.language_code = language_code;
    }

    public String getAverage_rating() {
        return average_rating;
    }

    public void setAverage_rating(String average_rating) {
        this.average_rating = average_rating;
    }

    public String getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(String ratings_count) {
        this.ratings_count = ratings_count;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
