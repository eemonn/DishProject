package comp3350.dishproject.logic;

import java.util.ArrayList;
import java.util.List;

import comp3350.dishproject.objects.Recipe;

public class RecipeValidator {

    /*
    Input: takes in a string of a dish name
    Output: returns true if dish is in the system
    Description: checks to see if a dish is in the system
     */
    public static boolean checkIfDishInSystem(String nameOfDish,List<Recipe> allRecipes) {
        for(int i=0;i<allRecipes.size();i++) {
            Recipe r = allRecipes.get(i);
            if(r.getName().toLowerCase().equals((nameOfDish.toLowerCase()))) {
                return true;
            }
        }
        return false;
    }

    /*
    Input: takes in a string of a recipe ID
    Output: returns true is recipeID in the system
    Description: checks to see if a given recipeID is valid
    */
    public static boolean validateRecipeID(String recipeID,List<Recipe> allRecipes){
        for(int i=0;i<allRecipes.size();i++) {
            String compareRecipeID = allRecipes.get(i).getRecipeID();
            if(compareRecipeID.equals(recipeID)) {
                return true;
            }
        }
        return false;
    }

    /*
    Input: takes in a string of a search query and an array of string dishes(their names)
    Output: returns a list of all the elements that match the filtering system
    Description: checks to see which dishes matches what the user is typing
     */
    public static ArrayList<String> filterSearchSuggestions(String searchQuery, String[] dishes) {
        ArrayList<String> filtered = new ArrayList<>();
        for (String dish : dishes) {
            String[] stringsToCheck = dish.split(" ");//Example: For dish of Chicken Parm, a search query of "Parm" will return Chicken Parm
            for (String s : stringsToCheck) {
                if (s.toLowerCase().contains(searchQuery.toLowerCase())) {//only lowercase cleaning
                    filtered.add(dish);
                }
            }
        }
        return filtered;
    }


}
