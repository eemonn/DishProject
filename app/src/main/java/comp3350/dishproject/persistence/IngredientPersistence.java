package comp3350.dishproject.persistence;

import java.util.List;

import comp3350.dishproject.objects.Ingredient;


public interface IngredientPersistence {

    List<Ingredient> getIngredients(final String recipeID);
    void modifyIngredients(Ingredient ingredient, final String recipeID);
}
