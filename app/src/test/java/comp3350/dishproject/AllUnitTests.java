package comp3350.dishproject;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import comp3350.dishproject.tests.logic.AccessIngredientsTest;
import comp3350.dishproject.tests.logic.AccessRecipesTest;
import comp3350.dishproject.tests.logic.AccessShoppingCartTest;
import comp3350.dishproject.tests.objects.IngredientTest;
import comp3350.dishproject.tests.objects.RecipeTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        IngredientTest.class,
        RecipeTest.class,
        AccessIngredientsTest.class,
        AccessRecipesTest.class,
        AccessShoppingCartTest.class
})

public class AllUnitTests {
}