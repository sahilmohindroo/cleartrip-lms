package com.lms.cleartrip.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lms.cleartrip.dao.BookDao;
import com.lms.cleartrip.entity.Book;
import com.lms.cleartrip.service.BookService;

@Component("BookService")
public class BookServiceImpl implements BookService{

	@Autowired
	BookDao bookDao;
	
	@Override
	public Book add(String id, String title, String author, Integer count) {
		Book book = new Book();
		book.setTitle(title);
		book.setId(id);
		book.setAuthor(author);
		book.setCount(count);
		
		if(validate(book)){
			book = bookDao.add(book);
		}
		return book;
	}

	private boolean validate(Book book) {
		if(book == null ||
				book.getId() == null || book.getId().isEmpty() ||
				book.getAuthor() == null || book.getAuthor().isEmpty() ||
				book.getTitle() == null || book.getTitle().isEmpty()){
			throw new RuntimeException("book id, title and author connot be empty");
		}
		return true;
	}

	@Override
	public boolean lendBook(String bookId, String userId) {
		if (null == bookId || bookId.isEmpty() || null == userId || userId.isEmpty()){
			throw new RuntimeException("bookid and userid connot be empty");
		}
		return bookDao.lendBook(bookId, userId);
	}

}
