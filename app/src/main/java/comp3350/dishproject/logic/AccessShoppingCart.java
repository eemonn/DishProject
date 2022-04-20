package comp3350.dishproject.logic;

import java.util.List;

import comp3350.dishproject.application.Services;
import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.persistence.ShoppingCartPersistence;

public class AccessShoppingCart {
    private final ShoppingCartPersistence shoppingListPersistence;

    /*
    Description: constructor
     */
    public AccessShoppingCart() {
        shoppingListPersistence = Services.getShoppingListPersistence();
    }

    /*
    Description: constructor if passed in ingredientPersistence object
     */
    public AccessShoppingCart(final ShoppingCartPersistence shoppingListPersistence) {
        this.shoppingListPersistence = shoppingListPersistence;
    }


    /*
    Input: Takes in an ingredient object
    Output: returns a boolean, true if successful add to list
    Description: Adds a specified ingredient to the shopping list
     */
    public boolean addToList(Ingredient ingredient)
    {
        return shoppingListPersistence.addToList(ingredient);
    }

    /*
    Input: takes in a string of the Ingredient name
    Output: boolean, true if successful delete
    Description: Deletes an ingredient from the shopping list
     */
    public boolean deleteFromList(String ingredientName){
        return shoppingListPersistence.deleteFromList(ingredientName);
    }

    /*
    Input: no input
    Output: returns a List of ingredients objects in the shopping cart
    Description: returns a List of ingredients in the shopping cart
     */
    public List<Ingredient> getEntireList(){
        return shoppingListPersistence.getEntireList();
    }

}
