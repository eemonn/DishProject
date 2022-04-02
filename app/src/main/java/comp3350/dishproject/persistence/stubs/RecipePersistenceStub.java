package comp3350.dishproject.persistence.stubs;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.persistence.RecipePersistence;


public class RecipePersistenceStub implements RecipePersistence {
    private final List<Recipe> recipes;

    /*
    Description: Constructor
    */
    public RecipePersistenceStub() {
        this.recipes = new ArrayList<>();
        recipes.add(new Recipe("burger","100",5,false));
        recipes.add(new Recipe("pizza","200",4,false));
        recipes.add(new Recipe("tacos","300",3,false));
        recipes.add(new Recipe("pancake","400",1,false));
        recipes.add(new Recipe("fish","500",1.5,false));
    }

    /*
    Input: no input
    Output: returns a list of recipes
    Description: returns a list of all recipes in the system
    */
    @Override
    public List<Recipe> getAllRecipes() {
        return recipes;
    }

    /*
    Input: takes in a string of the recipe ID
    Output: returns a recipe object
    Description: returns a recipe object with that given recipe ID
     */
    @Override
    public Recipe getRecipe(String recipeID) {
        for(int i=0;i<recipes.size();i++) {
            Recipe r = recipes.get(i);
            if(r.getRecipeID().equals(recipeID)){
                return r;
            }
        }
        return new Recipe("Null","1",1,false);
    }

    /*
    Input: takes in a string of the recipe name
    Output: returns a string of recipe id
    Description: returns a string of a recipe ID for a given recipe dish name
     */
    @Override
    public String findRecipeID(final String recipeName) {
        for (int i = 0; i < recipes.size(); i++) {
            Recipe r = recipes.get(i);
            if (r.getName().equalsIgnoreCase(recipeName)) {
                return r.getRecipeID();
            }
        }
        return "No ID";
    }


    /*
    Input: Recipe object
    Output: returns a recipe object
    Description: adds a recipe into the system and returns it
     */
    @Override
    public boolean insertRecipe(Recipe newRecipe) {
        for (int i = 0; i < recipes.size(); i++) {
            Recipe r = recipes.get(i);
            if (r.getRecipeID().equalsIgnoreCase(newRecipe.getRecipeID()) || r.getName().equals(newRecipe.getName())) {
                return false;
            }
        }
        recipes.add(newRecipe);
        return true;
    }

    /*
    Input: takes in a recipe object
    Output: boolean
    Description: deletes a given recipe object by id
     */
    @Override
    public boolean deleteRecipe(String recipeID) {
        for (int i = 0; i < recipes.size(); i++) {
            Recipe r = recipes.get(i);
            if (r.getRecipeID().equals(recipeID)) {
                recipes.remove(r);
                return true;
            }
        }
        return false;
    }

    /*
    Input: takes in double rating
    Output: boolean
    Description: changes a recipes rating
     */
    @Override
    public boolean changeRating(double rating,String recipeID){
        for (int i = 0; i < recipes.size(); i++) {
            Recipe r = recipes.get(i);
            if (r.getRecipeID().equalsIgnoreCase(recipeID)) {
                r.setRating(rating);
                return true;
            }
        }
        return false;
    }

    /*
    Input: takes in boolean fav and a recipeID
    Output: boolean, true if recipe found
    Description: changes a recipes rating
     */
    @Override
    public boolean changeFav(boolean fav,String recipeID){
        for (int i = 0; i < recipes.size(); i++) {
            Recipe r = recipes.get(i);
            if (r.getRecipeID().equalsIgnoreCase(recipeID)) {
                r.setFav(fav);
                return true;
            }
        }
        return false;
    }
}
