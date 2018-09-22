package com.broccoli.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.broccoli.model.Album;
import com.broccoli.repository.IAlbumRepository;
import com.broccoli.service.IAlbumService;

@Component
public class AlbumService implements IAlbumService {

	@Autowired
	private IAlbumRepository albumRepository;

	@Override
	public List<Album> searchAlbums(String input) {
		return sortAlphabetically(albumRepository.searchAlbums(input));
	}
	
	private List<Album> sortAlphabetically(List<Album> albums) {
		return albums.stream()
				.sorted(Comparator.comparing(Album::getTrackName, String::compareToIgnoreCase))
				.collect(Collectors.toList());
	}
	
}
