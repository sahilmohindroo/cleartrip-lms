package com.lms.cleartrip.dao.impl;

import org.springframework.stereotype.Repository;

import com.lms.cleartrip.dao.BookDao;
import com.lms.cleartrip.dao.UserDao;
import com.lms.cleartrip.databse.Database;
import com.lms.cleartrip.entity.Book;
import com.lms.cleartrip.entity.User;

@Repository
public class BookDaoImpl implements BookDao{

	@Override
	public Book add(Book book) {
			return Database.addBook(book);
	}

	@Override
	public boolean lendBook(String bookId, String userId) {
		return Database.lendBook(bookId, userId);
	}


}
