package comp3350.dishproject.tests;


import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.contrib.DrawerActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.pressKey;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withResourceName;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.matcher.ViewMatchers.hasSibling;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;


import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.Matchers.anything;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.presentation.MainActivity;
import comp3350.dishproject.tests.utils.TestUtils;
import comp3350.dishproject.R;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ShoppingListTest {
    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);
    private TestUtils tu;
    private Recipe top;

    @Before
    public void setupTestUtilities(){
        tu = new TestUtils();
        top = tu.topRecipe();
    }

    //sizes are bugged - FIX
    @Test
    public void testAddAndDeleteIngredient(){
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open());
        onView(withId(R.id.nav_shopping_cart)).perform(click());
        onView(withId(R.id.input)).perform(typeText("Squid"));
        onView(withId(R.id.add)).perform(click());
        int size = tu.getNoOfIngredientsInShoppingList();//should be the last element
        onView(nthChildOf(nthChildOf(withId(R.id.listview), size),1)).check(matches(withText("Squid")));
        SystemClock.sleep(1500);
        onView(nthChildOf(nthChildOf(withId(R.id.listview), size),3)).perform(click());
        SystemClock.sleep(1500);
    }

    //goddam https://stackoverflow.com/questions/38566886/espresso-how-to-get-the-children-of-a-view-by-index
    public static Matcher<View> nthChildOf(final Matcher<View> parentMatcher, final int childPosition) {
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("with "+childPosition+" child view of type parentMatcher");
            }

            @Override
            public boolean matchesSafely(View view) {
                if (!(view.getParent() instanceof ViewGroup)) {
                    return parentMatcher.matches(view.getParent());
                }

                ViewGroup group = (ViewGroup) view.getParent();
                return parentMatcher.matches(view.getParent()) && group.getChildAt(childPosition).equals(view);
            }
        };
    }


    @Test
    public void testViewShoppingList(){
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open());
        onView(withId(R.id.nav_shopping_cart)).perform(click());
        onView(withId(R.id.des_title)).check(matches(withText("Shopping List")));
        //SystemClock.sleep(1500);
    }

    @Test
    public void addingMissingIngredients(){
        //opens top recipes
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

        //we have to assume at least one ingredient
        onData(anything()).inAdapterView(withId(R.id.listView_data)).atPosition(0).perform(click());
        onView(withId(R.id.item_done)).perform(click());
        Espresso.pressBack();
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open());
        onView(withId(R.id.nav_shopping_cart)).perform(click());
        int size = tu.getNoOfIngredientsInShoppingList();//should be the last element
        System.out.println(size);
        String firstIngredientName = tu.getIngredients(top.getRecipeID()).get(0).getName();
        onView(nthChildOf(nthChildOf(withId(R.id.listview), size-1),1)).check(matches(withText(firstIngredientName + " ")));
        SystemClock.sleep(1500);
        onView(nthChildOf(nthChildOf(withId(R.id.listview), size-1),3)).perform(click());
        SystemClock.sleep(1500);

    }



}
