fetch('http://localhost:8080/api/categories')
  .then(response => response.json())
  .then(data => console.log(data));
