package com.mealdb.explorer.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {

	@JsonProperty("idCategory")
	private String idCategory;
	
	@JsonProperty("strCategory")
	private String strCategory;
	
	@JsonProperty("strCategoryThumb")
	private String strCategoryThumb;
	
	@JsonProperty("strCategoryDescription")
	private String strCategoryDescription;

	public String getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(String idCategory) {
		this.idCategory = idCategory;
	}

	public String getStrCategory() {
		return strCategory;
	}

	public void setStrCategory(String strCategory) {
		this.strCategory = strCategory;
	}

	public String getStrCategoryThumb() {
		return strCategoryThumb;
	}

	public void setStrCategoryThumb(String strCategoryThumb) {
		this.strCategoryThumb = strCategoryThumb;
	}

	public String getStrCategoryDescription() {
		return strCategoryDescription;
	}

	public void setStrCategoryDescription(String strCategoryDescription) {
		this.strCategoryDescription = strCategoryDescription;
	}
	
	
}
