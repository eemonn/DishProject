package comp3350.dishproject.objects;

public class Ingredient {
    //Variables
    private String name,recipeID;
    private double weight,calorie, initCal, initWeight;
    private int quantity, initQuantity;

    /*
    Description: Constructor
     */
    public Ingredient(String name, int quantity, double weight, double calorie, String recipeID) {
        this.name = name;
        this.calorie = calorie;
        this.quantity = quantity;
        this.weight = weight;
        this.recipeID = recipeID;
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
    public String getRecipeID(){return recipeID;}
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
    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
