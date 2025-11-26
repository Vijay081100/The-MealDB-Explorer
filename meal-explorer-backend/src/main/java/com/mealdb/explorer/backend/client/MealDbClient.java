package com.mealdb.explorer.backend.client;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mealdb.explorer.backend.model.CategoriesResposes;
import com.mealdb.explorer.backend.model.Category;
import com.mealdb.explorer.backend.model.Meal;
import com.mealdb.explorer.backend.model.MealsResponses;

@Component
public class MealDbClient {
	
	private static final String Base_Url = "https://www.themealdb.com/api/json/v1/1";
	private final RestTemplate restTemplete;
	
	MealDbClient(RestTemplate restTemplate) {
		this.restTemplete = restTemplate;
	}
	
	public List<Category> getCategories() {
		String url = Base_Url + "/categories.php";
		CategoriesResposes response = restTemplete.getForObject(url, CategoriesResposes.class);
		
		return response != null ? response.getCategories() : List.of();
		
	}
	
	public List<Meal> searchByMeals(String query) {
		String url = Base_Url + "/search.php?s=" + query;
		MealsResponses response = restTemplete.getForObject(url, MealsResponses.class);
		
		return response != null ? response.searchByMeals() : List.of();
	}
	
	public List<Meal> getMealsByCateogry(String Category) {
		String url = Base_Url + "/filter.php?c=" + Category;
		MealsResponses responses = restTemplete.getForObject(url, MealsResponses.class);
		
		return responses != null ? responses.getMeals() : List.of();
	}
	
	public Meal getRandomMeal() {
		String url = Base_Url + "/random.php";
		MealsResponses responses = restTemplete.getForObject(url, MealsResponses.class);
		
		return (responses != null && responses.getMeals() != null && !responses.getMeals().isEmpty()) ? responses.getMeals().get(0):null;
	}
	
	public Meal getMealById(String id) {
		String url = Base_Url + "/lookup.php?i=" + id;
		MealsResponses responses = restTemplete.getForObject(url, MealsResponses.class);
		
		return (responses != null && responses.getMeals() != null && !responses.getMeals().isEmpty()) ? responses.getMeals().get(0):null;
	}
}
