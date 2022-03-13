package comp3350.dishproject.persistence.stubs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.persistence.RecipePersistence;


public class RecipePersistenceStub implements RecipePersistence {
    private List<Recipe> recipes;

    public RecipePersistenceStub() {
        this.recipes = new ArrayList<>();
        recipes.add(new Recipe("Burger","100"));
        recipes.add(new Recipe("Pizza","200"));
        recipes.add(new Recipe("Tacos","300"));
        recipes.add(new Recipe("Pancake","400"));
        recipes.add(new Recipe("Fish","500"));
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipes;
    }


    @Override
    public Recipe insertRecipe(Recipe newRecipe) {
        recipes.add(newRecipe);
        return newRecipe;
    }
    @Override
    public Recipe updateRecipe(Recipe newRecipe) {
        int index;

        index = recipes.indexOf(newRecipe);
        if (index >= 0)
        {
            recipes.set(index, newRecipe);
        }
        return newRecipe;

    }
    @Override
    public void deleteRecipe(Recipe newRecipe) {
        int index;

        index = recipes.indexOf(newRecipe);
        if (index >= 0)
        {
            recipes.remove(index);
        }

    }
}
