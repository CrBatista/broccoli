package com.broccoli.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.broccoli.model.Book;
import com.broccoli.repository.IBookRepository;
import com.broccoli.service.IBookService;

@Component
public class BookService implements IBookService {

	@Autowired
	private IBookRepository bookRepository;

	@Override
	public List<Book> searchBooks(String input) {
		return sortAlphabetically(bookRepository.searchBooks(input));
	}
	
	private List<Book> sortAlphabetically(List<Book> books) {
		return books.stream()
				.sorted(Comparator.comparing(x -> x.getVolumeInfo().getTitle(), String::compareToIgnoreCase))
				.collect(Collectors.toList());
	}
	
}
