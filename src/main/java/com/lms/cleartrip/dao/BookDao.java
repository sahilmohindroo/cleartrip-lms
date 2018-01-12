package com.lms.cleartrip.dao;

import com.lms.cleartrip.entity.Book;

public interface BookDao {

	Book add(Book book);

	boolean lendBook(String bookId, String userId);

}
