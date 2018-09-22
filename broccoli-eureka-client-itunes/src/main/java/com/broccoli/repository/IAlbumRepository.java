package com.broccoli.repository;

import java.util.List;
import com.broccoli.model.Album;

public interface IAlbumRepository {

	public List<Album> searchAlbums(String input);

}
