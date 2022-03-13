package comp3350.dishproject.objects;
import androidx.annotation.NonNull;

public class Ingredient {
    //Variables
    private final double originalWeight;
    private final double originalCalorie;
    private final int originalCount;
    private String name, id;
    private int quantity;
    private double weight;
    private double calorie;
    private Recipe recipe;

    /*
    Input: Takes in a string name, string ID, int quantity, double weight, and double calorie
    Output: Constructor
    Description:ingredient class will have a name, id, quantity, weight and calorie
     */
    public Ingredient(String name, Recipe recipe) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.weight = weight;
        this.calorie = calorie;
        this.originalCount = quantity;
        this.originalCalorie = calorie;
        this.originalWeight = weight;
        this.recipe = recipe;
    }

    /*
    Description: get original quantity
     */
    public int getOriginalCount() {
        return originalCount;
    }
    public String getRecipeID(){return recipe.getRecipeID();}

    /*
    Description: gets original calories of ingredient
     */
    public double getOriginalCalorie() {
        return originalCalorie;
    }

    /*
    Description: gets original weight
     */
    public double getOriginalWeight() {
        return originalWeight;
    }

    /*
      Description: method to get calorie
    */
    public double getCalorie() {
        return calorie;
    }

    /*
    Description: method to set calorie
     */
    public void setCalorie(double calorie) {
        this.calorie = calorie;
    }

    /*
    Description: method to get weight
     */
    public double getWeight() {
        return weight;
    }

    /*
    Description: method to set weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /*
     Description: method to get quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /*
     Description: method to set quantity
    */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /*
    Description: method to get id
     */
    public String getId() {
        return id;
    }

    /*
     Description: method to set id
     */
    public void setId(String id) {
        this.id = id;
    }

    /*
    Description: method to get name
    */
    public String getName() {
        return name;
    }

    /*
     Description: method to set name
    */
    public void setName(String name) {
        this.name = name;
    }

    /*
    Description: method to increment quantity
     */
    public void incrementQuantity(int x) {
        this.quantity += x;
    }

    /*
    Input: takes in an ingredient
    Output: outputs a boolean
    Description: method to check ingredient and returns true if the two ingredient share the same
    name and id
     */
    public boolean isEqual(Ingredient i) {
        return this.name.equals(i.name) && this.id.equals(i.id);
    }

    /*
     Description: replacing the toString method
     */
    @NonNull
    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", quantity=" + quantity +
                ", weight=" + weight +
                '}';
    }
}
