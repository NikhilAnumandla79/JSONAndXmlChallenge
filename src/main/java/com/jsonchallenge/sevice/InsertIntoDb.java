package com.jsonchallenge.sevice;

import java.util.Set;

import com.jsonchallenge.dao.InsertBooksDaoImpl;
import com.jsonchallenge.model.Book;

public class InsertIntoDb {
	InsertBooksDaoImpl impl = new InsertBooksDaoImpl();
	public void insertBook(Set<Book> books) {
		impl.insertBooks(books);
	}

	public Set<Book> getBooks() {
		return impl.getBooks();
		
	}
}