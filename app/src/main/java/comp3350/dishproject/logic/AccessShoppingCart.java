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

    public boolean addToList(Ingredient ingredient)
    {
        return shoppingListPersistence.addToList(ingredient);
    }

    public boolean deleteFromList(Ingredient ingredient){
        return shoppingListPersistence.deleteFromList(ingredient);
    }

    public List<Ingredient> getEntireList(){
        return shoppingListPersistence.getEntireList();
    }

}
