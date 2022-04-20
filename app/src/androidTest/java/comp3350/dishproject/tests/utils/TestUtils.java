package comp3350.dishproject.tests.utils;
import java.util.Collections;
import java.util.List;

import comp3350.dishproject.logic.AccessIngredients;
import comp3350.dishproject.logic.AccessRecipes;
import comp3350.dishproject.logic.AccessShoppingCart;
import comp3350.dishproject.logic.AccessSteps;
import comp3350.dishproject.logic.ShowRecipe;
import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.objects.Recipe;

public class TestUtils {

    private AccessRecipes ar;
    private AccessIngredients ai;
    private AccessSteps as;
    private ShowRecipe sr;
    private AccessShoppingCart asc;

    public TestUtils(){
         ar = new AccessRecipes();
         ai = new AccessIngredients();
         as = new AccessSteps();
         asc = new AccessShoppingCart();
    }

    public List<Ingredient> getIngredients(String recipeID) {
        return ai.getIngredients(recipeID);
    }

    public Recipe topRecipe(){
        List<Recipe> mlist = ar.getAllRecipes();
        Collections.sort(mlist, (object1, object2) -> Boolean.compare(object2.getFav(), object1.getFav()));
        return(mlist.get(0));
    }

    public String[] getStrings(Recipe r){
        sr = new ShowRecipe(r);
        return sr.getIngredientListName();
    }

    public List<Recipe> getSortedRecipeList(){
        List<Recipe> mlist = ar.getAllRecipes();
        Collections.sort(mlist, (object1, object2) -> Boolean.compare(object2.getFav(), object1.getFav()));
        return mlist;
    }

    public String getDescriptionText(Recipe r){
        sr = new ShowRecipe(r);
        double totalCalories = sr.calculateCalories();
        double totalWeight = sr.calculateWeight();
        String description = "Calorie: " + totalCalories + "kcal "+ " Weight: " +  totalWeight + "g " + "Rating: ";
        return description;
    }

    public String[] getUpdatedIngredients(Recipe r, int scaleFactor){
        sr = new ShowRecipe(r);
        sr.updateIngredients(scaleFactor);
        return sr.getIngredientListName();
    }

    public int getPositionOfSorted(String name){
        List<Recipe> mlist = ar.getAllRecipes();
        Collections.sort(mlist, (object1, object2) -> Boolean.compare(object2.getFav(), object1.getFav()));
        for(int i=0;i<mlist.size();i++){
            Recipe r = mlist.get(i);
            if(r.getName().toLowerCase().equals(name)) return i;
        }
        return -1;
    }

    public int getNoOfIngredientsInShoppingList()
    {
        return asc.getEntireList().size();
    }

    public void deleteRecipe(String recipeName)
    {
        String id = ar.findRecipeID(recipeName);
        ar.deleteRecipe(id);
    }

}
