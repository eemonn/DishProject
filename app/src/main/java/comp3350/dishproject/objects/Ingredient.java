package comp3350.dishproject.objects;
import androidx.annotation.NonNull;

public class Ingredient {
    //Variables
    private String name;
    private double weight;
    private Recipe recipe;
    private String id;
    private int quantity;
    private double calorie;

    /*
    Input: Takes in a string name, string ID, int quantity, double weight, and double calorie
    Output: Constructor
    Description:ingredient class will have a name, id, quantity, weight and calorie
     */

    public Ingredient(String name,String id, int quantity, double weight, double calorie, Recipe recipe) {
        this.name = name;
        this.id = id;
        this.calorie = calorie;
        this.quantity = quantity;
        this.weight = weight;
        this.recipe = recipe;
    }

    public String getID() {
        return this.id;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getCalorie() {
        return this.calorie;
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

    public void setId(String s) {
        this.id = s;
    }

    public void setQuantity(int i) {
        this.quantity = i;
    }

    public void setCalorie(double v) {
        this.calorie = v;
    }
}
