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


    public static synchronized RecipePersistence getRecipePersistence() {
        if(recipePersistence == null) {
            recipePersistence = new RecipePersistenceStub(); //fake database
            //recipePersistence = new RecipePersistenceHSQLDB(Main.getDBPathName());
        }
        return recipePersistence;
    }

    public static synchronized IngredientPersistence getIngredientPersistence() {
        if(ingredientPersistence == null) {
            ingredientPersistence = new IngredientPersistenceStub(); //fake database
            //ingredientPersistence = new IngredientPersistenceHSQLDB(Main.getDBPathName());
        }
        return ingredientPersistence;
    }

    public static synchronized StepsPersistence getStepsPersistence() {
        if(stepsPersistence == null) {
            stepsPersistence = new StepsPersistenceStub(); //fake database
            //stepsPersistence = new StepsPersistenceHSQLDB(Main.getDBPathName());
        }
        return stepsPersistence;
    }

    public static synchronized void clean() {
        recipePersistence = null;
        ingredientPersistence = null;
    }



}
