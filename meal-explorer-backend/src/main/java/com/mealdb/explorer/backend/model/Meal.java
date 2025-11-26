package com.mealdb.explorer.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Meal {

	@JsonProperty("idMeal")
	private String idMeal;
	
	@JsonProperty("strMeal")
	private String strMeal;
	
	@JsonProperty("strDrinkAlternate")
	private String strDrinkAlternate;
	
	@JsonProperty("strCategory")
	private String strCategory;
	
	@JsonProperty("strArea")
	private String strArea;
	
	@JsonProperty("strInstructions")
	private String strInstructions;
	
	@JsonProperty("strMealThumb")
	private String strMealThumb;
	
	@JsonProperty("strTag")
	private String strTag;

	public String getIdMeal() {
		return idMeal;
	}

	public void setIdMeal(String idMeal) {
		this.idMeal = idMeal;
	}

	public String getStrMeal() {
		return strMeal;
	}

	public void setStrMeal(String strMeal) {
		this.strMeal = strMeal;
	}

	public String getStrDrinkAlternate() {
		return strDrinkAlternate;
	}

	public void setStrDrinkAlternate(String strDrinkAlternate) {
		this.strDrinkAlternate = strDrinkAlternate;
	}

	public String getStrCategory() {
		return strCategory;
	}

	public void setStrCategory(String strCategory) {
		this.strCategory = strCategory;
	}

	public String getStrArea() {
		return strArea;
	}

	public void setStrArea(String strArea) {
		this.strArea = strArea;
	}

	public String getStrInstructions() {
		return strInstructions;
	}

	public void setStrInstructions(String strInstructions) {
		this.strInstructions = strInstructions;
	}

	public String getStrMealThumb() {
		return strMealThumb;
	}

	public void setStrMealThumb(String strMealThumb) {
		this.strMealThumb = strMealThumb;
	}

	public String getStrTag() {
		return strTag;
	}

	public void setStrTag(String strTag) {
		this.strTag = strTag;
	}
	
	
}
