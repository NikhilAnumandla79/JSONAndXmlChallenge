package com.jsonchallenge.client;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.jsonchallenge.model.Author;
import com.jsonchallenge.model.Book;
import com.jsonchallenge.sevice.InsertIntoDb;
import com.jsonchallenge.sevice.XMLServicesImpl;

public class JsonFileReader {
	public static void main(String args[]) {
		JSONParser parser = new JSONParser();
		InsertIntoDb service = new InsertIntoDb();
		Object obj;
		try {
			obj = parser.parse(new FileReader("books.json"));
			JSONArray jsonArray = (JSONArray) obj;
			Iterator<JSONObject> bookObjects = jsonArray.iterator();
			JSONObject jsonObject1;
			Set<Book> books = new LinkedHashSet<Book>();
			while (bookObjects.hasNext()) {
				jsonObject1 = (JSONObject) bookObjects.next();
				int bookId = Integer.parseInt(jsonObject1.get("id").toString());
				String bookName = (String) jsonObject1.get("title");
				int bookPrice = Integer.parseInt(jsonObject1.get("price").toString());
				JSONArray authors = (JSONArray) jsonObject1.get("authors");
				Iterator<JSONObject> iterator =  authors.iterator();
				JSONObject jsonObject2;
				Set<Author> authorsList = new LinkedHashSet<Author>();
				while (iterator.hasNext()) {
					jsonObject2 = (JSONObject) iterator.next();
					int authorId = Integer.parseInt(jsonObject2.get("id").toString());
					String authorName = (String) jsonObject2.get("name");
					authorsList.add(new Author(authorId, authorName));
				}
				books.add(new Book(bookId, bookName, bookPrice, authorsList));
				
			}
			service.insertBook(books);
			Set<Book> readBooks = service.getBooks();
			new XMLServicesImpl().readToXml(readBooks);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
