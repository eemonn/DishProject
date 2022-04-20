package comp3350.dishproject.application;

import comp3350.dishproject.persistence.IngredientPersistence;
import comp3350.dishproject.persistence.RecipePersistence;
import comp3350.dishproject.persistence.ShoppingCartPersistence;
import comp3350.dishproject.persistence.StepsPersistence;
import comp3350.dishproject.persistence.hsqldb.IngredientPersistenceHSQLDB;
import comp3350.dishproject.persistence.hsqldb.RecipePersistenceHSQLDB;
import comp3350.dishproject.persistence.hsqldb.ShoppingCartPersistenceHSQLDB;
import comp3350.dishproject.persistence.hsqldb.StepsPersistenceHSQLDB;
import comp3350.dishproject.persistence.stubs.IngredientPersistenceStub;
import comp3350.dishproject.persistence.stubs.RecipePersistenceStub;
import comp3350.dishproject.persistence.stubs.ShoppingCartPersistenceStub;
import comp3350.dishproject.persistence.stubs.StepsPersistenceStub;

public class Services {

    //interfaces
    private static RecipePersistence recipePersistence = null;
    private static IngredientPersistence ingredientPersistence = null;
    private static StepsPersistence stepsPersistence = null;
    private static ShoppingCartPersistence shoppingListPersistence = null;

    //One line to change between real database and stub implementation
    private static final boolean useRealDatabase = true; //false if you want stub, true if you want real

    /*
    Input: no input
    Output: returns a object of type recipe persistence
    Description: Allows access to the recipe persistence class/interface
     */
    public static synchronized RecipePersistence getRecipePersistence() {
        if(recipePersistence == null) {
            if(useRealDatabase) {
                recipePersistence = new RecipePersistenceHSQLDB(Main.getDBPathName());
            } else {
                recipePersistence = new RecipePersistenceStub();
            }
        }
        return recipePersistence;
    }

    /*
   Input: no input
   Output: returns a object of type ingredient persistence
   Description: Allows access to the ingredient persistence class/interface
    */
    public static synchronized IngredientPersistence getIngredientPersistence() {
        if(ingredientPersistence == null) {
            if(useRealDatabase) {
                ingredientPersistence = new IngredientPersistenceHSQLDB(Main.getDBPathName());
            } else {
                ingredientPersistence = new IngredientPersistenceStub();
            }

        }
        return ingredientPersistence;
    }

    /*
   Input: no input
   Output: returns a object of type steps persistence
   Description: Allows access to the steps persistence class/interface
    */
    public static synchronized StepsPersistence getStepsPersistence() {
        if(stepsPersistence == null) {
            if(useRealDatabase) {
                stepsPersistence = new StepsPersistenceHSQLDB(Main.getDBPathName());
            } else {
                stepsPersistence = new StepsPersistenceStub();
            }

        }
        return stepsPersistence;
    }

     /*
   Input: no input
   Output: returns a object of type shopping cart persistence
   Description: Allows access to the shopping cart persistence class/interface
    */
    public static synchronized ShoppingCartPersistence getShoppingListPersistence() {
        if(shoppingListPersistence == null) {
            if(useRealDatabase) {
                shoppingListPersistence = new ShoppingCartPersistenceHSQLDB(Main.getDBPathName());
            } else {
                shoppingListPersistence = new ShoppingCartPersistenceStub();
            }
        }
        return shoppingListPersistence;
    }

     /*
   Input: no input
   Output: void
   Description: Resets each instance to null, used in testing to make sure we clean the database
    */
    public static synchronized void clean() {
        recipePersistence = null;
        ingredientPersistence = null;
        stepsPersistence = null;
        shoppingListPersistence=null;
    }
}
