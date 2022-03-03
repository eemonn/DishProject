package comp3350.dishproject.logic;

import java.util.ArrayList;

import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.persistence.DataAccess;
import comp3350.dishproject.presentation.HomeCard;

public class AccessRecipes {
    //Note: Tests for this logic class are included in the persistence testing for iteration 1
    private DataAccess db;

    /*
    Input: No input
    Output: Constructor
    Description: constructor for getting access to the database
     */
    public AccessRecipes() {
        db = new DataAccess();
    }
    /*
    Description: calls getAllRecipe from database
     */
    public ArrayList<HomeCard> getAllRecipe() {
        return db.getAllRecipe();
    }

    /*
    Description: calls getDishes from database
     */
    public String[] getDishes() {
        return db.getDishes();
    }

    /*
    Description: calls getRecipe from database
     */
    public Recipe getRecipe() {
        return db.getRecipe();
    }


}
