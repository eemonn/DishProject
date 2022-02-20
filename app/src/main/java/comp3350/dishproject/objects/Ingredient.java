package comp3350.dishproject.objects;

import java.util.Objects;

public class Ingredient {
    private String name, id;
    private int quantity;
    private double weight,calorie;
    /*
    ingredient class will have a name, id, quantity, weight and calorie
     */
    public Ingredient(String name, String id, int quantity, double weight,double calorie){
        this.name=name;
        this.id=id;
        this.quantity=quantity;
        this.weight=weight;
        this.calorie=calorie;
    }
    /*
    method to get calorie
     */
    public double getCalorie() {
        return calorie;
    }
    /*
    method to set calorie
     */
    public void setCalorie(double calorie) {
        this.calorie = calorie;
    }
    /*
    method to get weight
     */
    public double getWeight() {
        return weight;
    }
    /*
        method to get quantity
     */
    public int getQuantity() {
        return quantity;
    }
    /*
    method to get id
     */
    public String getId() {
        return id;
    }
    /*
        method to get name
         */
    public String getName() {
        return name;
    }
    /*
        method to set id
     */
    public void setId(String id) {
        this.id = id;
    }
    /*
        method to set name
         */
    public void setName(String name) {
        this.name = name;
    }
    /*
        method to set quantity
    */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    /*
    method to increment quantity
     */
    public void incrementQuantity(int x){
        this.quantity+=x;
    }
    /*
    method to set weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }
    /*
        method to check ingredient
     */
    public boolean isEqual(Ingredient i){
        return this.name.equals(i.name) && this.id.equals(i.id);
    }

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
