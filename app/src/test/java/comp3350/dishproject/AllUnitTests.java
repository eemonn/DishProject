package comp3350.dishproject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.Assert.*;

import comp3350.dishproject.logic.ShowRecipe;
import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.tests.logic.ShowRecipeTest;
import comp3350.dishproject.tests.objects.IngredientTest;
import comp3350.dishproject.tests.objects.RecipeTest;
import comp3350.dishproject.tests.persistence.dbTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ShowRecipeTest.class,
        IngredientTest.class,
        RecipeTest.class
})

public class AllUnitTests {
}