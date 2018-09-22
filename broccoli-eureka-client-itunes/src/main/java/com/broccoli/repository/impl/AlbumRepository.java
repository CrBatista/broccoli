package com.broccoli.repository.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.broccoli.model.Album;
import com.broccoli.model.ItunesApiResponse;
import com.broccoli.repository.IAlbumRepository;

@Repository
public class AlbumRepository implements IAlbumRepository {

	@Value("${broccoli.params.max-result:5}")
	private String maxResults;

	private String itunesApiEndpoint = "https://itunes.apple.com/search?media=all";

	@Override
	public List<Album> searchAlbums(String input) {
		RestTemplate restTemplate = new RestTemplate();
		HashMap<String, String> params = new HashMap<>();
		params.put("term", input);
		
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Arrays.asList(MediaType.parseMediaType("text/javascript")));
		messageConverters.add(converter);  
		restTemplate.setMessageConverters(messageConverters);  

		ResponseEntity<ItunesApiResponse> response = restTemplate.getForEntity(createURIFiltered(params), ItunesApiResponse.class);
		return ((ItunesApiResponse) response.getBody()).getResults();
	}

	/**
	 * This method will add a max result parameter before creating the URI
	 * 
	 * @param params The parameters for creating the query
	 * @return
	 */
	private String createURIFiltered(HashMap<String, String> params) {
		params.put("limit", maxResults);
		return createURI(params);
	}

	/**
	 * This method receives the parameters as a key-value map and return the Google
	 * URI
	 *
	 * @param params The parameters for creating the query
	 * @return
	 */
	private String createURI(HashMap<String, String> params) {
		StringBuilder itunesURI = new StringBuilder(itunesApiEndpoint);
		params.forEach((key, value) -> itunesURI.append("&").append(key).append("=").append(value));
		return itunesURI.toString();
	}
}
