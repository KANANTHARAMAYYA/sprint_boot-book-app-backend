package com.books.bookapp;

import com.books.bookapp.models.BookItem;
import com.books.bookapp.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@SpringBootApplication
public class BookApplication implements CommandLineRunner {
	@Bean
	public RestTemplate getRestTemplate(){
		return  new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}
	@Autowired
	private BookRepository bookRepository;
	@Override
	public void run(String ...args){
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://s3-ap-southeast-1.amazonaws.com/he-public-data/books8f8fe52.json";
		Object[] books = restTemplate.getForObject(url,Object[].class);
		ObjectMapper oMapper = new ObjectMapper();
		Map<String, Object> map;
		for(Object b : books){
			map = oMapper.convertValue(b, Map.class);
			System.out.println(map.get("bookID"));
			this.bookRepository.save(new BookItem(
					Integer.parseInt(String.valueOf(map.get("bookID"))),
					String.valueOf( map.get("title")),
					String.valueOf(map.get("authors")),
					String.valueOf(map.get("isbn")),
					String.valueOf(map.get("language_code")),
					String.valueOf(map.get("average_rating")),
					String.valueOf(map.get("ratings_count")),
					String.valueOf(map.get("price"))
			));
		}
	}

}
