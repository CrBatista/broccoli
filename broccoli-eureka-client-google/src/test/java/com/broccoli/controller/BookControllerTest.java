package com.broccoli.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.broccoli.model.Book;
import com.broccoli.service.impl.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class BookControllerTest {

	@Mock
	private BookService bookService;

	@MockBean
	private BookController bookController;

	@Test
	public void assertTrue() throws Exception {
		List<Book> returnList = new ArrayList<Book>();
        when(bookService.searchBooks(Mockito.anyString())).thenReturn(returnList);
        assertEquals(returnList, bookController.searchBooks(Mockito.anyString()));
	}
}
