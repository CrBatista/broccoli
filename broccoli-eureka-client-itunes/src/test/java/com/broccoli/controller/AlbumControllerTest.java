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

import com.broccoli.model.Album;
import com.broccoli.service.impl.AlbumService;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class AlbumControllerTest {

	@Mock
	private AlbumService albumService;

	@MockBean
	private AlbumController albumController;

	@Test
	public void searchAlbums() throws Exception {
		List<Album> returnList = new ArrayList<Album>();
        when(albumService.searchAlbums(Mockito.anyString())).thenReturn(returnList);
        assertEquals(returnList, albumController.searchAlbums(Mockito.anyString()));
	}
}
