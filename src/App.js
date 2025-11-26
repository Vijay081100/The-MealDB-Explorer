import React, { useState, useEffect } from "react";
import axios from "axios";

const API_BASE = "http://localhost:8080/api";

function App() {
  const [categories, setCategories] = useState([]);
  const [meals, setMeals] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState("");
  const [searchQuery, setSearchQuery] = useState("");
  const [randomMeal, setRandomMeal] = useState(null);
  const [selectedMeal, setSelectedMeal] = useState(null);

  // Load categories on component mount
  useEffect(() => {
    fetchCategories();
  }, []);

  const fetchCategories = () => {
    axios.get(`${API_BASE}/categories`)
      .then(res => {
  console.log("Categories data:", res.data);
  setCategories(res.data);
})
.catch(error => {
  console.error("Fetching categories failed:", error);
}); 
  };

  // Load meals by category
  const fetchMealsByCategory = (category) => {
    setSelectedCategory(category);
    axios.get(`${API_BASE}/meals/by-category?category=${category}`)
      .then(res => {
        setMeals(res.data);
        setSelectedMeal(null);
        setRandomMeal(null);
      })
      .catch(console.error);
  };

  // Search meals by query
  const searchMeals = () => {
    if (!searchQuery) return;
    axios.get(`${API_BASE}/meals/search?query=${searchQuery}`)
      .then(res => {
        setMeals(res.data);
        setSelectedCategory("");
        setSelectedMeal(null);
        setRandomMeal(null);
      })
      .catch(console.error);
  };

  // Fetch random meal
  const fetchRandomMeal = () => {
    axios.get(`${API_BASE}/meals/random`)
      .then(res => {
        setRandomMeal(res.data);
        setSelectedMeal(null);
        setMeals([]);
        setSelectedCategory("");
      })
      .catch(console.error);
  };

  // Fetch meal details by id
  const fetchMealById = (id) => {
    axios.get(`${API_BASE}/meals/${id}`)
      .then(res => {
        setSelectedMeal(res.data);
        setRandomMeal(null);
      })
      .catch(console.error);
  };

  return (
    <div style={{ padding: 20, fontFamily: "Arial" }}>
      <h1>TheMealDB Explorer</h1>

      <div>
        <input
          type="text"
          placeholder="Search meals..."
          value={searchQuery}
          onChange={e => setSearchQuery(e.target.value)}
          onKeyDown={e => e.key === 'Enter' && searchMeals()}
        />
        <button onClick={searchMeals}>Search</button>
        <button onClick={fetchRandomMeal} style={{ marginLeft: 10 }}>
          I'm feeling hungry
        </button>
      </div>

      <h2>Categories</h2>
      <div style={{ display: "flex", gap: 10, flexWrap: "wrap" }}>
        {categories.map(cat => (
          <button
            key={cat.idCategory}
            onClick={() => fetchMealsByCategory(cat.strCategory)}
            style={{
              padding: "5px 10px",
              background: selectedCategory === cat.strCategory ? "#4CAF50" : "#ccc",
              border: "none",
              borderRadius: 4,
              cursor: "pointer"
            }}
          >
            {cat.strCategory}
          </button>
        ))}
      </div>

      <h2>Meals</h2>
      <div style={{ display: "flex", flexWrap: "wrap", gap: 10 }}>
        {(meals.length > 0 ? meals : randomMeal ? [randomMeal] : []).map(meal => (
          <div
            key={meal.idMeal}
            style={{ cursor: "pointer", width: 150 }}
            onClick={() => fetchMealById(meal.idMeal)}
          >
            <img
              src={meal.strMealThumb}
              alt={meal.strMeal}
              style={{ width: "100%", borderRadius: 8 }}
            />
            <p>{meal.strMeal}</p>
          </div>
        ))}
      </div>

      {selectedMeal && (
        <div style={{ marginTop: 20 }}>
          <h2>{selectedMeal.strMeal}</h2>
          <img
            src={selectedMeal.strMealThumb}
            alt={selectedMeal.strMeal}
            style={{ width: 300, borderRadius: 10 }}
          />
          <h3>Category: {selectedMeal.strCategory}</h3>
          <h3>Area: {selectedMeal.strArea}</h3>
          <p>{selectedMeal.strInstructions}</p>
          {selectedMeal.strYoutube && (
            <div>
              <h3>Video Recipe</h3>
              <iframe
                width="560"
                height="315"
                src={`https://www.youtube.com/embed/${new URL(selectedMeal.strYoutube).searchParams.get("v")}`}
                title="YouTube video player"
                frameBorder="0"
                allowFullScreen
              ></iframe>
            </div>
          )}
        </div>
      )}
    </div>
  );
}

export default App;
