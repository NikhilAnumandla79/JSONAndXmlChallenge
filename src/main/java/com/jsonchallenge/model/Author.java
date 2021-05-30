package com.jsonchallenge.model;

public class Author {
	private int authorId;
	private String authorName;
	public Author() {
		// TODO Auto-generated constructor stub
	}
	public Author(int authorId, String authorName) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName + "]";
	}
	
	@Override
	public int hashCode() {
		return String.valueOf(authorId).hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Author) {
			Author author = (Author)obj;
			return (this.authorId==author.getAuthorId() && this.authorName.equals(((Author) obj).getAuthorName()));
		}else {
			return false;
		}
		
	}
}
