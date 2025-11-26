package com.mealdb.explorer.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String homeContriller() {
		return "Welcome to the MealDB Explorer API in Backend";
	}
}
