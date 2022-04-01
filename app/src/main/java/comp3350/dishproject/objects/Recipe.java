package comp3350.dishproject.objects;
public class Recipe {
    private String name,recipeID;
    private double rating;
    private boolean isFav;

    /*
    Description: Constructor if we have all three parameters
    */
    public Recipe(String name, String recipeID,double rating, boolean isFav) {
        this.name = name;
        this.recipeID = recipeID;
        this.rating = rating;
        this.isFav = isFav;
    }

    //Getters
    public double getRating(){
        return this.rating;
    }
    public String getName(){ return name;}
    public String getRecipeID(){return recipeID;}
    public boolean getFav(){return this.isFav;}

    //Setters
    public void setName(String newName) {this.name = newName;}
    public void setRecipeID(String newRecipeID) {this.recipeID = newRecipeID;}
    public void setRating(double rating){this.rating =rating;}
    public void setFav(boolean fav){this.isFav = fav;}
}