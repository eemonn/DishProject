package comp3350.dishproject.objects;
public class Recipe {
    private String name,recipeID;
    private double rating;

    /*
    Description: Constructor if we have all three parameters
    */
    public Recipe(String name, String recipeID,double rating) {
        this.name = name;
        this.recipeID = recipeID;
        this.rating = rating;
    }

    //Getters
    public double getRating(){
        return this.rating;
    }
    public String getName(){ return name;}
    public String getRecipeID(){return recipeID;}

    //Setters
    public void setName(String newName) {this.name = newName;}
    public void setRecipeID(String newRecipeID) {this.recipeID = newRecipeID;}
    public void setRating(double rating){this.rating =rating;}
}