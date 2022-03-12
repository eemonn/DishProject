package comp3350.dishproject.logic;

import comp3350.dishproject.application.Services;
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
}
