package comp3350.dishproject.persistence;

public interface StepsPersistence {
    String getDirections(final String recipeID);
    void updateDirections(final String recipeID, String newDirections);
}
