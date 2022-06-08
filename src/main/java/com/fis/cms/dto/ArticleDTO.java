package com.fis.cms.dto;

import java.util.Date;

import com.fis.cms.model.Author;
import com.fis.cms.model.Category;

public class ArticleDTO {
	
	private int articleId;
	private String title;
	private String excerpt;
	private String content;
	private Category category;
	private Author author;
	private Date date;
	
	public ArticleDTO() {
		super();
	}
	
	public ArticleDTO(int articleId, String title, String excerpt, String content, Category category, Author author,
			Date date) {
		super();
		this.articleId = articleId;
		this.title = title;
		this.excerpt = excerpt;
		this.content = content;
		this.category = category;
		this.author = author;
		this.date = date;
	}
	
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getExcerpt() {
		return excerpt;
	}
	public void setExcerpt(String excerpt) {
		this.excerpt = excerpt;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
