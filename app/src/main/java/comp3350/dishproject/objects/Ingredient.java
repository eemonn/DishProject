package comp3350.dishproject.objects;
import androidx.annotation.NonNull;

public class Ingredient {
    //Variables
    private String name;
    private double weight;
    private Recipe recipe;
    private int quantity;
    private double calorie;
    private int initQuantity;
    public double initCal;
    public double initWeight;

    /*
    Description: Constructor
     */
    public Ingredient(String name, int quantity, double weight, double calorie, Recipe recipe) {
        this.name = name;
        this.calorie = calorie;
        this.quantity = quantity;
        this.weight = weight;
        this.recipe = recipe;
        this.initCal=calorie;
        this.initQuantity=quantity;
        this.initWeight=weight;
    }

    //Getters
    public int getInitQuantity(){
        return initQuantity;
    }
    public double getInitCal(){
        return initCal;
    }
    public double getInitWeight(){
        return initWeight;
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
    public String getName(){return this.name;}

    //Setters
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setQuantity(int quantity){this.quantity=quantity;}
    public void setCalorie(double calorie){this.calorie =calorie;}

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
