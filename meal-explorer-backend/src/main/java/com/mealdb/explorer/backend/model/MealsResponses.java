package com.mealdb.explorer.backend.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MealsResponses {
	
	@JsonProperty("meals")
	private List<Meal> meals;

	public List<Meal> searchByMeals(String query) {
		
		return null;
	}

	public List<Meal> getMealsByCategory(String category) {
		return null;
	}
	
	public Meal getRandomMeal() {
		return null;
	}
	
	public Meal getMealById(String id) {
		return null;
	}

	public List<Meal> getMeals() {
		
		return meals;
	}
	
	public void setMeal(List<Meal> meals) {
		this.meals = meals;
	}

	public List<Meal> searchByMeals() {
		return meals;
	}
	
	
}
