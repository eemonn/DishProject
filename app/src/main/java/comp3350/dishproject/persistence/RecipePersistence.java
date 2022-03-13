package comp3350.dishproject.persistence;


import java.util.List;

import comp3350.dishproject.objects.Recipe;

public interface RecipePersistence {

    List<Recipe> getAllRecipes();
    Recipe getRecipe(final String recipeID);
    Recipe insertRecipe(Recipe newRecipe);
    Recipe updateRecipe(Recipe newRecipe);
    void deleteRecipe(Recipe newRecipe);


}
