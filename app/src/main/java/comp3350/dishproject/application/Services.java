package comp3350.dishproject.application;

import comp3350.dishproject.persistence.IngredientPersistence;
import comp3350.dishproject.persistence.RecipePersistence;
import comp3350.dishproject.persistence.hsqldb.IngredientPersistenceHSQLDB;
import comp3350.dishproject.persistence.hsqldb.RecipePersistenceHSQLDB;

public class Services {

    private static RecipePersistence recipePersistence = null;
    private static IngredientPersistence ingredientPersistence = null;


    public static synchronized RecipePersistence getRecipePersistence() {
        if(recipePersistence == null) {
            //recipePersistence = new RecipePersistenceStub(); //fake database
            recipePersistence = new RecipePersistenceHSQLDB(Main.getDBPathName());
        }
        return recipePersistence;
    }

    public static synchronized IngredientPersistence getIngredientPersistence() {
        if(ingredientPersistence == null) {
            //recipePersistence = new IngredientPersistenceStub(); //fake database
            ingredientPersistence = new IngredientPersistenceHSQLDB(Main.getDBPathName());
        }
        return ingredientPersistence;
    }

    public static synchronized void clean() {
        recipePersistence = null;
        ingredientPersistence = null;
    }



}
