package comp3350.dishproject.logic;

import comp3350.dishproject.application.Services;
import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.persistence.StepsPersistence;

public class AccessSteps {
    private final StepsPersistence stepPersistence;

    /*
    Description: constructor if recipePersistence object passed in
    */
    public AccessSteps() {
        stepPersistence = Services.getStepsPersistence();
    }

    /*
    Description: constructor if recipePersistence object passed in
    */
    public AccessSteps(final StepsPersistence stepPersistence) {
        this.stepPersistence = stepPersistence;
    }

    /*
    Input: takes om string of recipe ID and gets its directions
    Output: returns a string detailing the recipe instructions
    Description: deletes a recipe object from the system
     */
    public String getDirections(final String recipeID) {
        return stepPersistence.getDirections(recipeID);
    }

    /*
    Input: takes om string of recipe ID and a string of new directions
    Output: void
    Description: updates a recipes directions
     */
    public boolean updateDirections(final String recipeID, String newDirections) {
        return stepPersistence.updateDirections(recipeID,newDirections);
    }

    /*
    Input: takes a string of directions and a recipe object r
    Output: void
    Description: inserts a recipes directions
    */
    public boolean insertSteps(final String directions, Recipe r) {
        return stepPersistence.insertSteps(directions,r);
    }
}
