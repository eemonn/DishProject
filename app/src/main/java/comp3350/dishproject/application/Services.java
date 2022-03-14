package comp3350.dishproject.application;

import comp3350.dishproject.persistence.IngredientPersistence;
import comp3350.dishproject.persistence.RecipePersistence;
import comp3350.dishproject.persistence.StepsPersistence;
import comp3350.dishproject.persistence.hsqldb.IngredientPersistenceHSQLDB;
import comp3350.dishproject.persistence.hsqldb.RecipePersistenceHSQLDB;
import comp3350.dishproject.persistence.hsqldb.StepsPersistenceHSQLDB;
import comp3350.dishproject.persistence.stubs.IngredientPersistenceStub;
import comp3350.dishproject.persistence.stubs.RecipePersistenceStub;
import comp3350.dishproject.persistence.stubs.StepsPersistenceStub;

public class Services {

    private static RecipePersistence recipePersistence = null;
    private static IngredientPersistence ingredientPersistence = null;
    private static StepsPersistence stepsPersistence = null;

    //only change this line
    private static boolean useRealDatabase = false; //false if you want stub, true if you want real


    public static synchronized RecipePersistence getRecipePersistence() {
        if(recipePersistence == null) {
            if(useRealDatabase)recipePersistence = new RecipePersistenceHSQLDB(Main.getDBPathName());
            else recipePersistence = new RecipePersistenceStub(); //fake database
        }
        return recipePersistence;
    }

    public static synchronized IngredientPersistence getIngredientPersistence() {
        if(ingredientPersistence == null) {
            if(useRealDatabase)ingredientPersistence = new IngredientPersistenceHSQLDB(Main.getDBPathName());
            else ingredientPersistence = new IngredientPersistenceStub(); //fake database

        }
        return ingredientPersistence;
    }

    public static synchronized StepsPersistence getStepsPersistence() {
        if(stepsPersistence == null) {
            if(useRealDatabase)  stepsPersistence = new StepsPersistenceHSQLDB(Main.getDBPathName());
            else stepsPersistence = new StepsPersistenceStub(); //fake database

        }
        return stepsPersistence;
    }

    public static synchronized void clean() {
        recipePersistence = null;
        ingredientPersistence = null;
    }



}
