package com.lms.cleartrip.service;

import com.lms.cleartrip.entity.Book;

public interface BookService {

	Book add(String id, String title, String author, Integer count);

	boolean lendBook(String bookid, String userId);


}
