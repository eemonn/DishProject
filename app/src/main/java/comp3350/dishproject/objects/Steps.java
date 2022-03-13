package comp3350.dishproject.objects;

public class Steps {
    private String directions;
    private Recipe recipe;

    public Steps(String directions, final Recipe recipe)
    {
        this.directions = directions;
        this.recipe = recipe;
    }




    //getters and setters
    public void setDirections(String newDirections) {
        this.directions = newDirections;
    }
    public String getDirections() {
        return this.directions;
    }
    public String getRecipeID() {return (recipe.getRecipeID());}


}
