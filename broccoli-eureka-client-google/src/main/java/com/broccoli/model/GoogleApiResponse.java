package com.broccoli.model;

import java.util.List;
import lombok.Data;

@Data
public class GoogleApiResponse {

	private String kind;
	private Integer totalItems;
	private List<Book> items;

}
