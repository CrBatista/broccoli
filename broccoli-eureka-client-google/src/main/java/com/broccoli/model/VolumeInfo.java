package com.broccoli.model;

import java.util.List;

import lombok.Data;

@Data
public class VolumeInfo {
	
	private String title;
	private String subtitle;
	private String description;
	private String publisher;
	private String publishedDate;
	private List<String> authors;

}
