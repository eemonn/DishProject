package comp3350.dishproject.logic;

import java.util.List;

import comp3350.dishproject.application.Services;
import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.persistence.IngredientPersistence;

public class AccessIngredients {
    private IngredientPersistence ingredientPersistence;

    public AccessIngredients() {
        ingredientPersistence = Services.getIngredientPersistence();
    }

    //If passed in
    public AccessIngredients(final IngredientPersistence ingredientPersistence) {
        this();
        this.ingredientPersistence = ingredientPersistence;
    }

    public List<Ingredient> getIngredients(String recipeID) {
        return ingredientPersistence.getIngredients(recipeID);
    }

    public void addIngredients(Ingredient ingredient, final String recipeID) {
        ingredientPersistence.addIngredients(ingredient,recipeID);
    }



}
