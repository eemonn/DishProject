package comp3350.dishproject.logic;

import java.util.ArrayList;
import java.util.List;

import comp3350.dishproject.application.Services;
import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.persistence.RecipePersistence;

public class AccessRecipes {
    private RecipePersistence recipePersistence;

    public AccessRecipes() {
        recipePersistence = Services.getRecipePersistence();
    }

    public AccessRecipes(final RecipePersistence recipePersistence) {
        this();
        this.recipePersistence = recipePersistence;
    }

    public String findRecipeID(final String recipeName) {
        return recipePersistence.findRecipeID(recipeName);
    }

    public List<Recipe> getAllRecipes() {
        return recipePersistence.getAllRecipes();
    }

    public Recipe insertRecipe(Recipe newRecipe) {
        List<Recipe> allRecipes = getAllRecipes();
        for(int i=0; i<allRecipes.size();i++) {
            Recipe r = allRecipes.get(i);
            if(r.getName().equals(newRecipe.getName())) {
                return newRecipe;
            }
        }
        return recipePersistence.insertRecipe(newRecipe);
    }

    public Recipe getRecipe(final String recipeID) {
        return recipePersistence.getRecipe(recipeID);
    }

    public Recipe updateRecipe(Recipe newRecipe) {
        return recipePersistence.updateRecipe(newRecipe);
    }

    public void deleteRecipe(Recipe newRecipe){
        recipePersistence.deleteRecipe(newRecipe);
    }

    public boolean checkIfDishInSystem(String nameOfDish) {
        List<Recipe> allRecipes = getAllRecipes();
        for(int i=0;i<allRecipes.size();i++) {
            Recipe r = allRecipes.get(i);
            if(r.getName().equalsIgnoreCase(nameOfDish)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> filterSearchSuggestions(String searchQuery, String[] dishes) {
        ArrayList<String> filtered = new ArrayList<>();
        for (String dish : dishes) {
            String[] stringsToCheck = dish.split(" ");//Example: For dish of Chicken Parm, a search query of "Parm" will return Chicken Parm
            for (String s : stringsToCheck) {
                if (s.toLowerCase().contains(searchQuery.toLowerCase())) {//only lowercase cleaning
                    filtered.add(dish);
                }
            }
        }
        return filtered;
    }

}
