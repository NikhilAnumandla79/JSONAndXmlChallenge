package com.jsonchallenge.model;

import java.util.Set;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {
	private int bookId;
	private String bookName;
	private int bookPrice;
	private Set<Author> authors;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int bookId, String bookName, int bookPrice, Set<Author> authors) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.authors = authors;
	}
	
	@XmlAttribute
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	@XmlElement
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	@XmlElement
	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	
	

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookPrice=" + bookPrice + ", authors=" + authors
				+ "]";
	}
	
	@Override
	public int hashCode() {
		return String.valueOf(this.bookId).hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Book) {
			Book book = (Book) obj;
			return (this.bookId == book.getBookId() && this.bookName.equals(book.getBookName()));
		}else {
			return false;
		}
	}
	
	
}
