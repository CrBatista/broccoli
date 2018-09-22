package com.broccoli.repository;

import java.util.List;

import com.broccoli.model.Book;

public interface IBookRepository {

	public List<Book> searchBooks(String input);

}
