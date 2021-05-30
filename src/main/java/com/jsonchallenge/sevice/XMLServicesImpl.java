package com.jsonchallenge.sevice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.jsonchallenge.model.Book;

public class XMLServicesImpl {
	public void readToXml(Set<Book> books) {
		String xmlData="";
		if(books!=null) {
			for(Book book : books) {
				xmlData += readObjToXml(book)+"\n";
				
			}
			File file = new File("books.xml");
			try(FileWriter fw = new FileWriter(file)){
				fw.write(xmlData);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(xmlData);
			
		}else {
			System.out.println("Data Generation failed");
		}
		
	}
	
	private String readObjToXml(Book book) {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Book.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			StringWriter sw = new StringWriter();
			marshaller.marshal(book, sw);
			String bookData = sw.toString();
			return bookData;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
