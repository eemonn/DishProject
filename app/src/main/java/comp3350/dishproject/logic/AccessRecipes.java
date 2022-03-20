package comp3350.dishproject.logic;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import comp3350.dishproject.application.Services;
import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.objects.Recipe;

import comp3350.dishproject.persistence.RecipePersistence;

public class AccessRecipes {
    private final RecipePersistence recipePersistence;

    /*
    Description: constructor
     */
    public AccessRecipes() {
        recipePersistence = Services.getRecipePersistence();
    }

    /*
    Description: constructor if recipePersistence object passed in
     */
    public AccessRecipes(final RecipePersistence recipePersistence) {
        this.recipePersistence = recipePersistence;
    }

    /*
    Input: takes in a string of the recipe ID
    Output: returns a List of ingredients objects
    Description: returns a List of ingredients for a specific recipe
     */
    public String findRecipeID(final String recipeName) {
        return recipePersistence.findRecipeID(recipeName);
    }

    /*
    Input: no input
    Output: returns a List of recipe objects
    Description: returns a List of all recipe objects in the system
     */
    public List<Recipe> getAllRecipes() {
        return recipePersistence.getAllRecipes();
    }

    /*
    Input: takes in a recipe object
    Output: returns a recipe object(of the recipe you're trying to add)
    Description: Attempts to add a recipe into the system
     */
    public boolean insertRecipe(Recipe newRecipe) {
        if(!RecipeValidator.validateRecipeID(newRecipe.getRecipeID(),getAllRecipes())) {
            return recipePersistence.insertRecipe(newRecipe);
        }
        return false;
    }



    /*
    Input: takes string of a recipe id
    Output: returns a recipe object
    Description: finds a recipe by its recipe ID
     */
    public Recipe getRecipe(final String recipeID) {
        if(RecipeValidator.validateRecipeID(recipeID,getAllRecipes())) {
            return recipePersistence.getRecipe(recipeID);
        }
        return null;
    }

    /*
    Input: takes in a recipe object
    Output: void
    Description: deletes a recipe object from the system
     */
    public void deleteRecipe(String recipeID){
        if(RecipeValidator.validateRecipeID(recipeID,getAllRecipes())) {
            recipePersistence.deleteRecipe(recipeID);
        }
    }


    public void changeRating(double rating,String recipeID) {
        if(RecipeValidator.validateRecipeID(recipeID,getAllRecipes())) {
            recipePersistence.changeRating(rating,recipeID);
        }
    }

}
