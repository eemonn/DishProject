package comp3350.dishproject.logic;

import comp3350.dishproject.application.Services;
import comp3350.dishproject.persistence.StepsPersistence;

public class AccessSteps {
    private StepsPersistence stepPersistence;

    public AccessSteps() {
        stepPersistence = Services.getStepsPersistence();
    }

    public AccessSteps(final StepsPersistence stepPersistence) {
        this();
        this.stepPersistence = stepPersistence;
    }

    public String getDirections(final String recipeID) {
        return stepPersistence.getDirections(recipeID);
    }

    public void updateDirections(final String recipeID, String newDirections) {
        stepPersistence.updateDirections(recipeID,newDirections);
    }
}
