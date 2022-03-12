package comp3350.dishproject.logic;

import java.util.ArrayList;

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


}
