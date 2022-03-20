package comp3350.dishproject;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import comp3350.dishproject.tests.logic.AccessIngredientsTest;
import comp3350.dishproject.tests.logic.AccessRecipesTest;
import comp3350.dishproject.tests.logic.AccessStepsTest;
import comp3350.dishproject.tests.logic.AddRecipeTestIT;
import comp3350.dishproject.tests.logic.RecipeValidatorTest;
import comp3350.dishproject.tests.logic.ShowRecipeTest;
import comp3350.dishproject.tests.objects.IngredientTest;
import comp3350.dishproject.tests.objects.RecipeTest;
import comp3350.dishproject.tests.objects.StepsTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        IngredientTest.class,
        ShowRecipeTest.class,
        StepsTest.class,
        RecipeTest.class,
        AccessIngredientsTest.class,
        AccessRecipesTest.class,
        AccessStepsTest.class,
        RecipeValidatorTest.class
})

public class AllUnitTests {
}