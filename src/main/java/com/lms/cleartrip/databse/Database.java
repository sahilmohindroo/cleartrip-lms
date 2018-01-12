package com.lms.cleartrip.databse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lms.cleartrip.entity.Book;
import com.lms.cleartrip.entity.User;

public class Database {

	public static Map<String, User> users = new HashMap<>();
	// index on user name on table users, returns list of users ids
	public static Map<String, List<String>> nameIdxUsers = new HashMap<>();
	public static Map<String, Book> books = new HashMap<>();
	// index on author on table books, returns list of book ids
	public static Map<String, List<String>> authorIdxBooks = new HashMap<>();
	// index on title on table books, returns list of book ids
	public static Map<String, List<String>> titleIdxBooks = new HashMap<>();
	
	
	public static User addUser(User user) {
		
		if(users.containsKey(user.getId())){
			throw new RuntimeException("user already exist with id : " + user.getId());
		}
		
		users.put(user.getId(), user);
		if(!nameIdxUsers.containsKey(user.getName())){
			nameIdxUsers.put(user.getName(), new ArrayList<String>());
		}
		nameIdxUsers.get(user.getName()).add(user.getId());
		
		return user;
	}

	public static Book addBook(Book bookn) {
		Book book = books.get(bookn.getId());
		if(book != null){
			book.setCount(book.getCount()+bookn.getCount());;
		}else{
			book = bookn;
			books.put(book.getId(), book);
			if(!authorIdxBooks.containsKey(book.getAuthor())){
				authorIdxBooks.put(book.getAuthor(), new ArrayList<String>());
			}
			if(!titleIdxBooks.containsKey(book.getTitle())){
				titleIdxBooks.put(book.getTitle(), new ArrayList<String>());
			}
			authorIdxBooks.get(book.getAuthor()).add(book.getId());
			titleIdxBooks.get(book.getTitle()).add(book.getId());
		}
		
		return book;
	}

	public static boolean lendBook(String bookId, String userId) {
		if(!books.containsKey(bookId)){
			throw new RuntimeException("book not found with id : " + bookId);
		}
		if(!users.containsKey(userId)){
			throw new RuntimeException("user not found with id : " + userId);
		}
		Book book = books.get(bookId);
		if(book.getCount()==0){
			throw new RuntimeException("book not avialble");
		}
		book.setCount(book.getCount()-1);
		book.getUserIds().add(userId);
		return true;
	}


}
