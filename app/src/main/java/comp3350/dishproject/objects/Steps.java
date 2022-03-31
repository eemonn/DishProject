package comp3350.dishproject.objects;

public class Steps {
    private String directions;
    private final String recipeID;

    public Steps(String directions, final String recipeID)
    {
        this.directions = directions;
        this.recipeID = recipeID;
    }

    //getters
    public String getDirections() {
        return this.directions;
    }
    public String getRecipeID() {return (this.recipeID);}

    //Setters
    public void setDirections(String newDirections) {
        this.directions = newDirections;
    }

    @Override
    public String toString() {
        return "Steps: " + directions;
    }
}
