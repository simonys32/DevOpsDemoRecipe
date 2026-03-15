package ch.zhaw.iwi.devops.demo;

public class Recipe {

    private Integer id;
    private String title;
    private String description;
    private String ingredients;
    private String instructions;
    private String cookingTime;
    private String servings;
    private String category;

    public Recipe() {
    }

    public Recipe(Integer id, String title, String description, String ingredients, String instructions, String cookingTime, String servings, String category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.cookingTime = cookingTime;
        this.servings = servings;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getCookingTime() {
        return cookingTime;
    }

    public String getServings() {
        return servings;
    }

    public String getCategory() {
        return category;
    }

}
