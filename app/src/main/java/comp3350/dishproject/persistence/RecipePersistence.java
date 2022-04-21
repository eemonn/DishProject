package comp3350.dishproject.persistence;


import java.util.List;

import comp3350.dishproject.objects.Recipe;

public interface RecipePersistence {
    List<Recipe> getAllRecipes();
    Recipe getRecipe(final int recipeID);
    int findRecipeID(final String recipeName);
    boolean insertRecipe(Recipe newRecipe);
    boolean deleteRecipe(int recipeID);
    boolean changeRating(double rating,int recipeID);
    boolean changeFav(boolean fav,int recipeID);
    boolean updateDirections(int recipeID, String newDirections);
}
