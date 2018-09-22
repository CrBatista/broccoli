package com.broccoli.service;

import java.util.List;

import com.broccoli.model.Book;

public interface IBookService {
	
	public List<Book> searchBooks(String input);

}
