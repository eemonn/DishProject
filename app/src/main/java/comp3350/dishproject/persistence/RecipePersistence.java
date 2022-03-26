package comp3350.dishproject.persistence;


import java.util.List;

import comp3350.dishproject.objects.Recipe;

public interface RecipePersistence {
    List<Recipe> getAllRecipes();
    Recipe getRecipe(final String recipeID);
    String findRecipeID(final String recipeName);
    boolean insertRecipe(Recipe newRecipe);
    void deleteRecipe(String recipeID);
    void changeRating(double rating,String recipeID);
}
