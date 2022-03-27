package comp3350.dishproject;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import comp3350.dishproject.tests.logic.AccessIngredientsTest;
import comp3350.dishproject.tests.logic.AccessRecipesTest;
import comp3350.dishproject.tests.logic.AccessStepsTest;
import comp3350.dishproject.tests.logic.ShowRecipeTest;
import comp3350.dishproject.tests.logic.ShowRecipeTestIT;
import comp3350.dishproject.tests.objects.IngredientTest;
import comp3350.dishproject.tests.objects.RecipeTest;
import comp3350.dishproject.tests.objects.StepsTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        IngredientTest.class,
        StepsTest.class,
        RecipeTest.class,
        AccessIngredientsTest.class,
        AccessRecipesTest.class,
        ShowRecipeTest.class,
        AccessStepsTest.class,
})

public class AllUnitTests {
}