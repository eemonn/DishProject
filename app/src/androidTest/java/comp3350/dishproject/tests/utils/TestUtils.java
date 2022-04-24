package comp3350.dishproject.tests.utils;
import java.util.Collections;
import java.util.List;

import comp3350.dishproject.logic.AccessIngredients;
import comp3350.dishproject.logic.AccessRecipes;
import comp3350.dishproject.logic.AccessShoppingCart;
import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.objects.Recipe;

public class TestUtils {

    private AccessRecipes ar;
    private AccessIngredients ai;
    private AccessShoppingCart asc;
    private List<Ingredient> shoppingIngredients;

    public TestUtils(){
         ar = new AccessRecipes();
         ai = new AccessIngredients();
         asc = new AccessShoppingCart();
    }

    public List<Ingredient> getIngredients(int recipeID) {
        return ai.getIngredients(recipeID);
    }

    public Recipe topRecipe(){
        List<Recipe> mlist = ar.getAllRecipes();
        Collections.sort(mlist, (object1, object2) -> Boolean.compare(object2.getFav(), object1.getFav()));
        return(mlist.get(0));
    }

    public String[] getStrings(Recipe r){
        List<Ingredient> ingredientList = ai.getIngredients(r.getRecipeID());
        return r.getIngredientListName(ingredientList);
    }

    public List<Recipe> getSortedRecipeList(){
        List<Recipe> mlist = ar.getAllRecipes();
        Collections.sort(mlist, (object1, object2) -> Boolean.compare(object2.getFav(), object1.getFav()));
        return mlist;
    }

    public String getDescriptionText(Recipe r){
        List<Ingredient> ingredientList = ai.getIngredients(r.getRecipeID());
        double totalCalories = r.calculateCalories(ingredientList);
        double totalWeight = r.calculateWeight(ingredientList);
        String description = "Calorie: " + totalCalories + "kcal "+ " Weight: " +  totalWeight + "g " + "Rating: ";
        return description;
    }

    public String[] getUpdatedIngredients(Recipe r, int scaleFactor){
        List<Ingredient> ingredientList = ai.getIngredients(r.getRecipeID());
        r.updateIngredients(scaleFactor,ingredientList);
        return r.getIngredientListName(ingredientList);
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
        int id = ar.findRecipeID(recipeName);
        ar.deleteRecipe(id);
    }

    public void clearShoppingList(){
        shoppingIngredients = asc.getEntireList();
        for(int i=0;i<shoppingIngredients.size();i++) {
            Ingredient ing = shoppingIngredients.get(i);
            asc.deleteFromList(ing.getName());
        }
    }

    public void resetShoppingList(){
        for(int i=0;i<shoppingIngredients.size();i++) {
            Ingredient ing = shoppingIngredients.get(i);
            asc.addToList(ing);
        }
    }

}
