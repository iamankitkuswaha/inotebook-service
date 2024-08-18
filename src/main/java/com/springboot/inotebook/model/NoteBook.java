package com.springboot.inotebook.model;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection="inotebook")
public class NoteBook {
	@Id
	@NotNull
	private String isbn;
	@NotNull
	private String name;
	@NotNull
	private String author;
	private String description;
	private String tag;
	private Date date = new Date();
	
//	public NoteBook(String isbn, String name, String author, String description, String tag, Date date) {
//		super();
//		this.isbn = isbn;
//		this.name = name;
//		this.author = author;
//		this.description = description;
//		this.tag = tag;
//		this.date = date;
//	}
//
//	public String getIsbn() {
//		return isbn;
//	}
//
//	public void setIsbn(String isbn) {
//		this.isbn = isbn;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getAuthor() {
//		return author;
//	}
//
//	public void setAuthor(String author) {
//		this.author = author;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public String getTag() {
//		return tag;
//	}
//
//	public void setTag(String tag) {
//		this.tag = tag;
//	}
//
//	public Date getDate() {
//		return date;
//	}
//
//	public void setDate(Date date) {
//		this.date = date;
//	}

}
