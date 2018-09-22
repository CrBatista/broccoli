package com.broccoli.service;

import java.util.List;

import com.broccoli.model.Album;

public interface IAlbumService {
	
	public List<Album> searchAlbums(String input);

}
