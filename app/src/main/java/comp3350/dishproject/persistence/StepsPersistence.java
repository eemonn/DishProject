package comp3350.dishproject.persistence;

import comp3350.dishproject.objects.Recipe;

public interface StepsPersistence {
    String getDirections(final String recipeID);
    boolean updateDirections(final String recipeID, String newDirections);
    boolean insertSteps(final String directions,final Recipe recipe);
}
