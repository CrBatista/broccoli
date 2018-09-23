package com.broccoli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.broccoli.model.Book;
import com.broccoli.service.impl.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;

	@GetMapping("/books/{input}")
	@ResponseBody
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<Book> searchBooks(@PathVariable("input") String input) {
		return bookService.searchBooks(input);
	}
}
