package comp3350.dishproject.objects;

import java.util.ArrayList;
import java.util.Objects;

public class Recipe {
    private String name,id,direction;
    private double calorie,weight;
    private ArrayList<Ingredient>ingredientArrayList;
    private int rating;
    /*
    recipe class will have a name, id, calorie, weight, arraylist of Ingredients
    it also has rating which is set to 0 and direction which is empty
     */
    public Recipe(String name,String id, double calorie,double weight, ArrayList<Ingredient> ingredientArrayList){
        this.name=name;
        this.id=id;
        this.calorie=calorie;
        this.weight=weight;
        this.ingredientArrayList=ingredientArrayList;
        this.rating=0;
        this.direction="";
    }
    /*
    method to set weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }
    /*
    method to get weight
     */
    public double getWeight() {
        return weight;
    }
    /*
    method to set direction
     */
    public void setDirectionMethod(String s){
        this.direction=s;
    }
    /*
    method to get direction
     */
    public String getDirection() {
        return direction;
    }
    /*
    method to set id
     */
    public void setId(String id) {
        this.id = id;
    }
    /*
    method to get rating
     */
    public int getRating() {
        return rating;
    }
    /*
    method to set rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }
    /*
    method to set calorie
     */
    public void setCalorie(double calorie) {
        this.calorie = calorie;
    }

    public boolean hasIngredient(Ingredient ingredient){
        for(int i=0;i<this.getIngredientArrayList().size();i++){
            System.out.println(this.getIngredientArrayList().size());//this.getIngredientArrayList().get(i).getName()
            System.out.println(this.getIngredientArrayList().get(i).getName());
            System.out.println(this.getIngredientArrayList().get(i)!=null);
            if(ingredient.getName().equals(this.getIngredientArrayList().get(i).getName()) && ingredient.getId().equals(this.getIngredientArrayList().get(i).getId())){
                return true;
            }
        }
        return false;
    }
    public void setIngredientArrayList(ArrayList<Ingredient> ingredientArrayList) {
        this.ingredientArrayList = ingredientArrayList;
    }
    public boolean isEquals(Recipe o) {
        return this.name.equals(o.name) && this.id.equals(o.id);
    }
    public void removeIngredientFromRecipe(Ingredient ingredient){
        for(int i=0;i<this.ingredientArrayList.size();i++){
            if(ingredient.getName().equals(ingredientArrayList.get(i).getName()) && ingredient.getId().equals(ingredientArrayList.get(i).getId())){
                ingredientArrayList.get(i).incrementQuantity(-1);
                if(ingredientArrayList.get(i).getQuantity()<1){
                    ingredientArrayList.remove(i);
                }
                break;
            }
        }
    }
    /*
    method to set name
     */
    public void setName(String name) {
        this.name = name;
    }

    public void increaseCalorie(double x){
        this.calorie+=calorie;
    }
    public void addIngredient(Ingredient i){
        this.ingredientArrayList.add(i);
        increaseCalorie((i.getCalorie()));
    }

    public ArrayList<Ingredient> getIngredientArrayList() {
        return ingredientArrayList;
    }
    /*
    method to get calorie
     */
    public double getCalorie() {
        return calorie;
    }
    /*
    method to get name
     */
    public String getName() {
        return name;
    }
    /*
    method to get id
     */
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", calorie=" + calorie +
                ", weight=" + calorie +
                ", ingredientArrayList=" + ingredientArrayList +
                '}';
    }
}
