package comp3350.dishproject.logic;

import java.util.List;

import comp3350.dishproject.application.Services;
import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.persistence.IngredientPersistence;

public class AccessIngredients {
    private final IngredientPersistence ingredientPersistence;

    /*
    Description: constructor
     */
    public AccessIngredients() {
        ingredientPersistence = Services.getIngredientPersistence();
    }

    /*
    Description: constructor if passed in ingredientPersistence object
     */
    public AccessIngredients(final IngredientPersistence ingredientPersistence) {
        this.ingredientPersistence = ingredientPersistence;
    }

    /*
   Input: takes in a string of the recipe ID
   Output: returns a List of ingredients objects
   Description: returns a List of ingredients for a specific recipe
    */
    public List<Ingredient> getIngredients(String recipeID) {
        return ingredientPersistence.getIngredients(recipeID);
    }

    /*
     Input: Takes in an ingredient object and String recipe ID
     Output: void function
     Description: Allows the addition of an ingredient to a given recipe
      */
    public boolean addIngredients(Ingredient ingredient, final String recipeID) {
        return ingredientPersistence.addIngredients(ingredient, recipeID);
    }



}
