package com.broccoli.repository.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.broccoli.model.Book;
import com.broccoli.model.GoogleApiResponse;
import com.broccoli.repository.IBookRepository;

@Repository
public class BookRepository implements IBookRepository {

	@Value("${broccoli.params.max-result:5}")
	private String maxResults;

	private String googleApiEndpoint = "https://www.googleapis.com/books/v1/volumes?showPreorders=false";

	@Override
	public List<Book> searchBooks(String input) {
		RestTemplate restTemplate = new RestTemplate();
		HashMap<String, String> params = new HashMap<>();
		params.put("q", input);

		ResponseEntity<GoogleApiResponse> response = restTemplate.getForEntity(createURIFiltered(params), GoogleApiResponse.class);
		return ((GoogleApiResponse) response.getBody()).getItems();
	}
	
	/**
	 * This method will add a max result parameter before creating the URI
	 * 
	 * @param params The parameters for creating the query
	 * @return
	 */
	private String createURIFiltered(HashMap<String, String> params) {
		params.put("maxResults", maxResults);
		return createURI(params);
	}

	/**
	 * This method receives the parameters as a key-value map and return the Google URI
	 *
	 * @param params The parameters for creating the query
	 * @return
	 */
	private String createURI(HashMap<String, String> params) {
		StringBuilder googleURI = new StringBuilder(googleApiEndpoint);
		params.forEach((key, value) -> googleURI.append("&").append(key).append("=").append(value));
		return googleURI.toString();
	}
}
