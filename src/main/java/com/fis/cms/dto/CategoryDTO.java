package com.fis.cms.dto;

public class CategoryDTO {
	
	private int categoryId;
	private String name;
	
	public CategoryDTO() {
		super();
	}
	
	public CategoryDTO(int categoryId, String name) {
		super();
		this.categoryId = categoryId;
		this.name = name;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
