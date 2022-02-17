package comp3350.dishproject.objects;

import java.util.ArrayList;
import java.util.Objects;

public class Recipe {
    private String name,id;
    private float calorie;
    private ArrayList<Ingredient>ingredientArrayList;
    public Recipe(String name,String id, float calorie, ArrayList<Ingredient> ingredientArrayList){
        this.name=name;
        this.id=id;
        this.calorie=calorie;
        this.ingredientArrayList=ingredientArrayList;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Float.compare(recipe.calorie, calorie) == 0 && Objects.equals(name, recipe.name) && Objects.equals(id, recipe.id) && Objects.equals(ingredientArrayList, recipe.ingredientArrayList);
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
    public void increaseCalorie(float x){
        this.calorie+=calorie;
    }
    public void addIngredient(Ingredient i){
        this.ingredientArrayList.add(i);
        increaseCalorie(i.getCalorie());
    }

    public ArrayList<Ingredient> getIngredientArrayList() {
        return ingredientArrayList;
    }

    public float getCalorie() {
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
