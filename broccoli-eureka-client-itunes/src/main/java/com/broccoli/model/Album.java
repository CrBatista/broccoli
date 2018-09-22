package com.broccoli.model;

import lombok.Data;

@Data
public class Album {

	private String wrapperType;
	private String kind;
	private Integer artistId;
	private Integer collectionId;
	private Integer trackId;
	private String artistName;
	private String collectionName;
	private String trackName;
	private String collectionCensoredName;
	private String trackCensoredName;
	private String artistViewUrl;
	private String collectionViewUrl;
	private String trackViewUrl;
	private String previewUrl;
	private String artworkUrl30;
	private String artworkUrl60;
	private String artworkUrl100;
	private Double collectionPrice;
	private Double trackPrice;
	private String releaseDate;
	private String collectionExplicitness;
	private String trackExplicitness;
	private Integer discCount;
	private Integer discNumber;
	private Integer trackCount;
	private Integer trackNumber;
	private Integer trackTimeMillis;
	private String country;
	private String currency;
	private String primaryGenreName;
	private Boolean isStreamable;

}
