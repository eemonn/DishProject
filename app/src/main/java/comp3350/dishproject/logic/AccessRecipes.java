package comp3350.dishproject.logic;

import java.util.ArrayList;
import java.util.List;

import comp3350.dishproject.application.Services;
import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.persistence.RecipePersistence;
import comp3350.dishproject.presentation.HomeCard;

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

}
