package com.broccoli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.broccoli.model.Album;
import com.broccoli.service.impl.AlbumService;

@RestController
public class AlbumController {
	
	@Autowired
	private AlbumService albumService;

	@GetMapping("/albums/{input}")
	@ResponseBody
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<Album> searchAlbums(@PathVariable("input") String input) {
		return albumService.searchAlbums(input);
	}
}
