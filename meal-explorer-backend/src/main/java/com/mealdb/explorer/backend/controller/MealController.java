package com.mealdb.explorer.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mealdb.explorer.backend.model.Category;
import com.mealdb.explorer.backend.model.Meal;
import com.mealdb.explorer.backend.service.MealService;

@RestController
@RequestMapping("/api/")
public class MealController {

    private final MealService mealService;
	
	public MealController(MealService mealService) {
		this.mealService = mealService;
	}

	@GetMapping("/categories")
	public List<Category> getCategories() {
		return mealService.getCategories();
	}
	
	@GetMapping("/meals/search")
	public List<Meal> searchMeals(@RequestParam String query) {
		return mealService.searchByMeal(query);
	}
	
	 @GetMapping("/meals/by-category") 
	  public List<Meal> getMealsByCategory(@RequestParam("category") String category) {
		 return mealService.getMealsByCategory(category);
	 }

	  @GetMapping("/meals/random")
	  public Meal getRandomMeal() {
		  return mealService.getRandomMeal();
	  }

	  @GetMapping("/meals/{id}")
	  public Meal getMealById(@PathVariable String id) {
		  return mealService.getMealById(id);	
	  }
	  	  
}
