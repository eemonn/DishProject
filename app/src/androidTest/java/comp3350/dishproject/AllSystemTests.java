package comp3350.dishproject;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.dishproject.tests.IngredientTest;
import comp3350.dishproject.tests.RecipeTest;
import comp3350.dishproject.tests.ShoppingListTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        RecipeTest.class,
        IngredientTest.class,
        ShoppingListTest.class
})

    public class AllSystemTests {
}
