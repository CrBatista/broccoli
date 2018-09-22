package com.broccoli.model;

import java.util.List;

import lombok.Data;

@Data
public class ItunesApiResponse {

	private Integer resultCount;
	private List<Album> results;

}
