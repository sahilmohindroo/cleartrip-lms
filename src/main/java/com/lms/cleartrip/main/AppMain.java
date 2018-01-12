package com.lms.cleartrip.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.lms.cleartrip.AppConfig;
import com.lms.cleartrip.entity.Book;
import com.lms.cleartrip.entity.User;
import com.lms.cleartrip.service.BookService;
import com.lms.cleartrip.service.UserService;

public class AppMain {


	static UserService userService;
	static BookService bookService;
	
	public static void main(String args[]) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		userService = (UserService) context.getBean("UserService");
		bookService = (BookService) context.getBean("BookService");
		
		createUser("u1", "sahil");
		createUser("u2", "mayank");
		//duplicate id scenario
		createUser("u1", "pankaj");
		createUser("u3", "pankaj");
		
		createBook("b1", "title1", "author1", 2);
		createBook("b2", "title2", "author1", 4);
		createBook("b3", "title3", "author2", 1);
		
		lendBook("b1", "u1");
		context.close();

	}

	private static void createUser(String id, String name) {
		try {
			User user = userService.add(id, name);
			System.out.println("user created with id : "+user.getId()+" and name : "+user.getName());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private static void createBook(String id, String title, String author, Integer count) {
		try {
			Book book = bookService.add(id, title, author, count);
			System.out.println(count +" books added with id : "+book.getId()+" and title : "+book.getTitle()+" and author :"+book.getAuthor());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private static void lendBook(String bookid, String userId) {
		try {
			bookService.lendBook(bookid, userId);
			System.out.println("book with id : "+bookid+" lend to user : "+userId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
