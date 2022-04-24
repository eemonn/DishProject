package comp3350.dishproject.tests;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.contrib.RecyclerViewActions;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static org.hamcrest.Matchers.anything;
import android.os.SystemClock;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.presentation.MainActivity;
import comp3350.dishproject.tests.utils.TestUtils;
import comp3350.dishproject.R;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class IngredientTest {
    private Recipe top;
    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);
    private TestUtils tu;

    @Before
    public void setupTestUtilities(){
        tu = new TestUtils();
        top = tu.topRecipe();
    }

    @Test
    public void testShowRecipeIngredients() {
        onView(withId(R.id.rv_list)).perform(RecyclerViewActions.actionOnItemAtPosition(0,
                                new ViewAction() {
                                    @Override
                                    public Matcher<View> getConstraints() {
                                        return null;
                                    }

                                    @Override
                                    public String getDescription() {
                                        return "Click on specific button";
                                    }

                                    @Override
                                    public void perform(UiController uiController, View view) {
                                        View button = view.findViewById(R.id.btn_view);

                                        button.performClick();
                                    }
                                })
                );
        SystemClock.sleep(1000);
        String[] ingredientStrings = tu.getStrings(top);
        for(int i=0;i<ingredientStrings.length;i++){
            onData(anything()).inAdapterView(withId(R.id.listView_data)).atPosition(i).
                    check(matches(withText(ingredientStrings[i])));
            onData(anything()).inAdapterView(withId(R.id.listView_data)).atPosition(i).perform(click());
        }
        SystemClock.sleep(500);
    }//method


    @Test
    public void testChangingQuantity(){
        onView(withId(R.id.rv_list)).perform(RecyclerViewActions.actionOnItemAtPosition(0,
                new ViewAction() {
                    @Override
                    public Matcher<View> getConstraints() {
                        return null;
                    }

                    @Override
                    public String getDescription() {
                        return "Click on specific button";
                    }

                    @Override
                    public void perform(UiController uiController, View view) {
                        View button = view.findViewById(R.id.btn_view);
                        button.performClick();
                    }
                })
        );
        onView(withId(R.id.spinner)).perform(click());
        onData(anything()).atPosition(3).perform(click());//Serving size should be 4
        String[] ingredientStrings = tu.getUpdatedIngredients(top,4);
        onData(anything()).inAdapterView(withId(R.id.listView_data)).atPosition(0).
                check(matches(withText(ingredientStrings[0])));
    }
}
