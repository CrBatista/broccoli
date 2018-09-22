package com.broccoli.repository.impl;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class AlbumRepositoryTest {

	@Mock
	private RestTemplate restTemplate;

	@MockBean
	private AlbumRepository albumRepository;
	
	@Test
	public void checkGoogleApiIsCalled() {
		String input = "broccoli"; 
		albumRepository.searchAlbums(input);
		verify(albumRepository, times(1)).searchAlbums(input);
	}
}
