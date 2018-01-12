package com.lms.cleartrip.entity;

import java.util.ArrayList;
import java.util.List;

public class Book {

	private String id;
	private String title;
	private String author; 
	private Integer count;
	//list of users with this book
	private List<String> userIds = new ArrayList<>();
	
	public Book() {
		super();
	}

	public Book(String id, String title, String author, Integer count) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.count = count;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<String> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<String> userIds) {
		this.userIds = userIds;
	}

}
