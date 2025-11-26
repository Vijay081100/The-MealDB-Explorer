package com.mealdb.explorer.backend.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mealdb.explorer.backend.client.MealDbClient;
import com.mealdb.explorer.backend.model.Category;
import com.mealdb.explorer.backend.model.Meal;

@Service
public class MealService {

	private final MealDbClient mealDbClient;

	@Autowired
	public MealService(MealDbClient mealDbClient) {
		this.mealDbClient = mealDbClient;
	}
	
	public List<Category> getCategories() {
		return mealDbClient.getCategories();
	}
	
	public List<Meal> searchByMeal(String query) {
		return mealDbClient.searchByMeals(query);
	}
	
	public List<Meal> getMealsByCategory(String Category) {
		return mealDbClient.getMealsByCateogry(Category);
	}
	
	public Meal getRandomMeal() {
		return mealDbClient.getRandomMeal();
	}
	
	public Meal getMealById(String id) {
		return mealDbClient.getMealById(id);
	}
	
	public List<Meal> getVegitarianMeal() {
		return mealDbClient.getMealsByCateogry("Vegitarian");
	}
	
	public List<Meal> getNonVegitarianMeals() {
		List<Meal> checkenMeal = mealDbClient.getMealsByCateogry("Checken");
		List<Meal> seaFood = mealDbClient.getMealsByCateogry("SeaFood");
		
		return Stream.of(checkenMeal, seaFood).flatMap(Collection::stream).collect(Collectors.toList());
	}
	
	
}
