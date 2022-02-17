package comp3350.dishproject.objects;

import java.util.Objects;

public class Ingredient {
    private String name, id;
    private int quantity;
    private float weight,calorie;
    public Ingredient(String name, String id, int quantity, float weight,float calorie){
        this.name=name;
        this.id=id;
        this.quantity=quantity;
        this.weight=weight;
        this.calorie=calorie;
    }

    public float getCalorie() {
        return calorie;
    }

    public void setCalorie(float calorie) {
        this.calorie = calorie;
    }

    public float getWeight() {
        return weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void incrementQuantity(int x){
        this.quantity+=x;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

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
