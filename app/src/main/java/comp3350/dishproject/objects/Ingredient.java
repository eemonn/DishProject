package comp3350.dishproject.objects;
import androidx.annotation.NonNull;

public class Ingredient {
    //Variables
    private String name;
    private double weight;
    private Recipe recipe;

    /*
    Input: Takes in a string name, string ID, int quantity, double weight, and double calorie
    Output: Constructor
    Description:ingredient class will have a name, id, quantity, weight and calorie
     */
    public Ingredient(String name,double weight, Recipe recipe) {
        this.name = name;
        this.weight = weight;
        this.recipe = recipe;
    }

    public String getRecipeID(){return recipe.getRecipeID();}
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    /*
    Input: takes in an ingredient
    Output: outputs a boolean
    Description: method to check ingredient and returns true if the two ingredient share the same
    name and id
     */
    public boolean isEqual(Ingredient i) {
        return this.name.equals(i.name) && this.getRecipeID().equals(i.getRecipeID());
    }

    /*
     Description: replacing the toString method
     */
    @NonNull
    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
