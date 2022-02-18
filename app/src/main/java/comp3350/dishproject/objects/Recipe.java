package comp3350.dishproject.objects;

import java.util.ArrayList;
import java.util.Objects;

public class Recipe {
    private String name,id,direction;
    private double calorie;
    private ArrayList<Ingredient>ingredientArrayList;
    private int rating;
    public Recipe(String name,String id, double calorie, ArrayList<Ingredient> ingredientArrayList){
        this.name=name;
        this.id=id;
        this.calorie=calorie;
        this.ingredientArrayList=ingredientArrayList;
        this.rating=0;
        this.direction="";
    }
    public void setDirectionMethod(String s){
        this.direction=s;
    }

    public String getDirection() {
        return direction;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setCalorie(double calorie) {
        this.calorie = calorie;
    }

    public void setIngredientArrayList(ArrayList<Ingredient> ingredientArrayList) {
        this.ingredientArrayList = ingredientArrayList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Double.compare(recipe.calorie, calorie) == 0 && Objects.equals(name, recipe.name) && Objects.equals(id, recipe.id) && Objects.equals(ingredientArrayList, recipe.ingredientArrayList);
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

    @Override
    public int hashCode() {
        return Objects.hash(name, id, calorie, ingredientArrayList);
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCalorie(float calorie){
        this.calorie=calorie;
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

    public double getCalorie() {
        return calorie;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", calorie=" + calorie +
                ", ingredientArrayList=" + ingredientArrayList +
                '}';
    }
}
