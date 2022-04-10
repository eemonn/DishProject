package comp3350.dishproject;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.dishproject.tests.logic.AccessIngredientsTestIT;
import comp3350.dishproject.tests.logic.AccessRecipesTestIT;
import comp3350.dishproject.tests.logic.AccessShoppingCartTestIT;
import comp3350.dishproject.tests.logic.AccessStepsTestIT;
import comp3350.dishproject.tests.logic.AddRecipeTestIT;
import comp3350.dishproject.tests.logic.ShowRecipeTestIT;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccessIngredientsTestIT.class,
        AccessRecipesTestIT.class,
        AccessStepsTestIT.class,
        AddRecipeTestIT.class,
        ShowRecipeTestIT.class,
        AccessShoppingCartTestIT.class
})
public class AllIntegrationTests {
}
