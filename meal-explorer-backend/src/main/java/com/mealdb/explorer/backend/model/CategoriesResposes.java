package com.mealdb.explorer.backend.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoriesResposes {

	@JsonProperty("categories")
	private List<Category> categories;
	
	public List<Category> getCategories() {
		
		return categories;
	}
	
	public void setCategory(List<Category> categories) {
		this.categories = categories;
	}
	
}
