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
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;


import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.Matchers.anything;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
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
public class RecipeTest {
    private Recipe top;
    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);
    private TestUtils tu;

    @Before
    public void setupTestUtilities(){
        tu = new TestUtils();
        top = tu.topRecipe();
    }



    @Test//tests feature and displaying it and nav bar
    public void testAddRecipe(){
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open());
        onView(withId(R.id.nav_add_recipe)).perform(click());
        onView(withId(R.id.add_recipe_name)).perform(typeText("Turkey"));
        onView(withId(R.id.add_recipe_directions)).perform(typeText("cook the bird"));
        onView(withId(R.id.button_add_ingredient)).perform(click());
        onView(withId(R.id.edit_ingredient_name)).perform(typeText("turkey bird"));
        onView(withId(R.id.edit_ingredient_weight)).perform(typeText("360"));
        //onView(nthChildOf(nthChildOf(withId(R.id.layout_list), 0),1)).check(matches(withText("hi")));
        closeSoftKeyboard();
        onView(withText("Add")).perform(click());
        SystemClock.sleep(1500);
        onView(withId(R.id.action_search)).perform(click());
        onView(withId(R.id.search_src_text)).perform(typeText("turkey")).perform(pressKey(KeyEvent.KEYCODE_ENTER));
        onView(withId(R.id.des_title)).check(matches(withText("turkey")));
        tu.deleteRecipe("turkey");



    }

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

    @Test//tests favourite a recipe and having it show up as first
    public void testFavourite(){
        boolean isFav = top.getFav();//burger is not fav
        clickFirstButton();//get to burger page

        onView(withId(R.id.switch1)).perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                Matcher <View> isRatingBarConstraint = ViewMatchers.isAssignableFrom(Switch.class);
                return isRatingBarConstraint;
            }

            @Override
            public String getDescription() {
                return "Custom view action to set rating.";
            }

            @Override
            public void perform(UiController uiController, View view) {

                Switch sw = (Switch) view;
                if(isFav){//if its favourite
                    sw.setChecked(false);//set to not be a favourite anymore
                }else {//ifs it not
                    sw.setChecked(true);//set it to be a favourite
                }
            }
        });
        SystemClock.sleep(2500);//need
        Espresso.pressBack();
        SystemClock.sleep(2500);

        int position = tu.getPositionOfSorted(top.getName());
        onView(withId(R.id.rv_list)).perform(RecyclerViewActions.actionOnItemAtPosition(position,
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

        if(isFav) {//if originially a favourite checked thats its not anymore
            onView(withId(R.id.switch1)).check(matches(not(isChecked())));
        } else {
            onView(withId(R.id.switch1)).check(matches((isChecked())));
        }
        //SystemClock.sleep(2500);
        //checking if Added






        //Reset - make sure you get right positon

        onView(withId(R.id.switch1)).perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                Matcher <View> isRatingBarConstraint = ViewMatchers.isAssignableFrom(Switch.class);
                return isRatingBarConstraint;
            }

            @Override
            public String getDescription() {
                return "Custom view action to set rating.";
            }

            @Override
            public void perform(UiController uiController, View view) {

                Switch sw = (Switch) view;
                if(isFav){//if its favourite
                    sw.setChecked(true);//set to not be a favourite anymore
                }else {//ifs it not
                    sw.setChecked(false);//set it to be a favourite
                }
            }
        });

    }//method









    @Test//tests viewing a recipe
    public void testViewRecipe(){
        List<Recipe> sortedRecipes = tu.getSortedRecipeList();
        //Lets check the first 3 recipes to see if they go to the correct page
        for(int i=0;i<3;i++) {
            onView(withId(R.id.rv_list)).perform(RecyclerViewActions.actionOnItemAtPosition(i,
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

            //Checking were viewing the right recipe

            onView(withId(R.id.des_title)).check(matches(withText(sortedRecipes.get(i).getName())));
            Espresso.pressBack();
        }//for loop

    }

    @Test//tests the rating dish system
    public void testRateADish(){
        clickFirstButton();
        double originalRating = top.getRating();
        onView(withId(R.id.ratingBar2)).perform(scrollTo());
        onView(withId(R.id.ratingBar2)).perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                Matcher <View> isRatingBarConstraint = ViewMatchers.isAssignableFrom(RatingBar.class);
                return isRatingBarConstraint;
            }

            @Override
            public String getDescription() {
                return "Custom view action to set rating.";
            }

            @Override
            public void perform(UiController uiController, View view) {
                RatingBar ratingBar = (RatingBar) view;
                ratingBar.setRating(5);
            }
        });
        Espresso.pressBack();
        clickFirstButton();
        onView(withId(R.id.ratingBar2)).perform(scrollTo());
        SystemClock.sleep(1000);
        String comparison = tu.getDescriptionText(top) + "5.0\n";
        onView(withId(R.id.des_text)).check(matches(withText(comparison)));

        //reset it back to the original
        onView(withId(R.id.ratingBar2)).perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                Matcher <View> isRatingBarConstraint = ViewMatchers.isAssignableFrom(RatingBar.class);
                return isRatingBarConstraint;
            }

            @Override
            public String getDescription() {
                return "Custom view action to set rating.";
            }

            @Override
            public void perform(UiController uiController, View view) {
                RatingBar ratingBar = (RatingBar) view;
                ratingBar.setRating((float)originalRating);
            }
        });

    }

    private void clickFirstButton(){
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
    }

    private void clickIthButton(int i){
        onView(withId(R.id.rv_list)).perform(RecyclerViewActions.actionOnItemAtPosition(i,
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
    }

    @Test//tests the search recipe via the search bar
    public void testSearchForRecipe(){
        String nameToType = top.getName().toLowerCase();
        onView(withId(R.id.action_search)).perform(click());
        onView(withId(R.id.search_src_text)).perform(typeText(nameToType)).perform(pressKey(KeyEvent.KEYCODE_ENTER));
        onView(withId(R.id.des_title)).check(matches(withText(nameToType)));
    }


}
