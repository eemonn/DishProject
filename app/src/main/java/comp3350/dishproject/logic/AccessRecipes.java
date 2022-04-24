package comp3350.dishproject.logic;

import java.util.List;
import comp3350.dishproject.application.Services;
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
    Input: takes in a string of the recipe name
    Output: returns an int of the recipe ID
    Description: returns the int representing the recipe ID
     */
    public int findRecipeID(final String recipeName) {
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
        return recipePersistence.insertRecipe(newRecipe);
    }


    /*
    Input: takes int of a recipe id
    Output: returns a recipe object
    Description: finds a recipe by its recipe ID
     */
    public Recipe getRecipe(final int recipeID) {
        return recipePersistence.getRecipe(recipeID);
    }


    /*
    Input: takes in a recipe id
    Output: void
    Description: deletes a recipe object from the system
     */
    public boolean deleteRecipe(int recipeID){
        return recipePersistence.deleteRecipe(recipeID);
    }



    /*
    Input: takes in a recipe id and rating
    Output: void
    Description: changes the rating for a recipe in the system
     */
    public boolean changeRating(double rating,int recipeID) {
        return recipePersistence.changeRating(rating,recipeID);
    }


    /*
    Input: takes in a recipe id and boolean if it is a favourite
    Output: void
    Description: changes the favourite field of a recipe
     */
    public boolean changeFav(boolean fav,int recipeID){
        return recipePersistence.changeFav(fav,recipeID);
    }

    /*
    Input: takes in int of recipe ID and a string of new directions
    Output: void
    Description: updates a recipes directions in the database
     */
    public boolean updateDirections(final int recipeID, String newDirections) {
        return recipePersistence.updateDirections(recipeID,newDirections);
    }

}
