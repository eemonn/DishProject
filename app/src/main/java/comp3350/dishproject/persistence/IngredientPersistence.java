package comp3350.dishproject.persistence;

import java.util.List;

import comp3350.dishproject.objects.Ingredient;


public interface IngredientPersistence {
    List<Ingredient> getIngredients(final int recipeID);
    boolean addIngredients(Ingredient ingredient, final int recipeID);
}
