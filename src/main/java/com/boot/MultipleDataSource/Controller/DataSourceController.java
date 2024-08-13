package com.boot.MultipleDataSource.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.MultipleDataSource.Repository.book.BookRepository;
import com.boot.MultipleDataSource.Repository.user.UserRepository;
import com.boot.MultipleDataSource.domain.book.BookDetails;
import com.boot.MultipleDataSource.domain.user.User;


@RestController
public class DataSourceController {
	@Autowired
	BookRepository bookRepository;
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(method=RequestMethod.POST, value = "/dataSource/book/add")
	public ResponseEntity<String> addBooks(@RequestBody BookDetails books) {
		bookRepository.save(books);
		return ResponseEntity.status(HttpStatus.OK).body("Added to book table");
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/dataSource/user/add")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		userRepository.save(user);
		return ResponseEntity.status(HttpStatus.OK).body("Added to user table");
	}
	@RequestMapping("/dataSource/book/search")
	public List<BookDetails> getAllBooks() {
		
		return bookRepository.findAll();
	}
	@RequestMapping("/dataSource/user/search")
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}
}
