package comp3350.dishproject.objects;

import java.util.ArrayList;
import java.util.Objects;

public class Recipe {
    private String name, id, direction;
    private double calorie, weight;
    private ArrayList<Ingredient> ingredientArrayList;
    private float rating;

    //
    /*
    recipe class will have a name, id, calorie, weight, arraylist of Ingredients
    it also has rating which is set to 0 and direction which is empty
     */
    public Recipe(String name, String id, double calorie, double weight, ArrayList<Ingredient> ingredientArrayList) {
        this.name = name;
        this.id = id;
        this.calorie = calorie;
        this.weight = weight;
        this.ingredientArrayList = ingredientArrayList;
        this.rating = 0;
        this.direction = "";
    }

    /*
    method to get weight
     */
    public double getWeight() {
        return weight;
    }

    /*
    method to set weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /*
    method to set direction
     */
    public void setDirectionMethod(String s) {
        this.direction = s;
    }

    /*
    method to get direction
     */
    public String getDirection() {
        return direction;
    }

    /*
    method to get rating
     */
    public float getRating() {
        return rating;
    }

    /*
    method to set rating
     */
    public void setRating(float rating) {
        this.rating = rating;
    }

    /*
    method to check if ingredient present in list of ingredients
     */
    public boolean hasIngredient(Ingredient ingredient) {
        for (int i = 0; i < this.getIngredientArrayList().size(); i++) {
            if (ingredient.getName().equals(this.getIngredientArrayList().get(i).getName()) && ingredient.getId().equals(this.getIngredientArrayList().get(i).getId())) {
                return true;
            }
        }
        return false;
    }

    /*
    method to check 2 recipe object
     */
    public boolean isEquals(Recipe o) {
        return this.name.equals(o.name) && this.id.equals(o.id);
    }

    /*
    method to remove ingredient
     */
    public void removeIngredientFromRecipe(Ingredient ingredient) {
        for (int i = 0; i < this.ingredientArrayList.size(); i++) {
            if (ingredient.getName().equals(ingredientArrayList.get(i).getName()) && ingredient.getId().equals(ingredientArrayList.get(i).getId())) {
                increaseCalorie((-ingredient.getCalorie()));
                ingredientArrayList.get(i).incrementQuantity(-1);
                if (ingredientArrayList.get(i).getQuantity() < 1) {
                    ingredientArrayList.remove(i);
                }
                break;
            }
        }
    }

    /*
    method to update information of ingredient list
     */
    public void updateIngredientList(int num) {
        for (int i = 0; i < this.ingredientArrayList.size(); i++) {
            ingredientArrayList.get(i).setQuantity(ingredientArrayList.get(i).getOriginalCount() * num);
            ingredientArrayList.get(i).setCalorie(ingredientArrayList.get(i).getOriginalCalorie() * num);
            ingredientArrayList.get(i).setWeight(ingredientArrayList.get(i).getOriginalWeight() * num);

        }
    }

    /*
    method to change calorie
     */
    public void increaseCalorie(double x) {
        this.calorie += x;
    }

    /*
    method to add recipe. if ingredient already present, only update amount
     */
    public void addIngredient(Ingredient i) {
        int counter = i.getQuantity();
        double counter2 = i.getCalorie();
        if (hasIngredient(i)) {
            for (int j = 0; j < this.ingredientArrayList.size(); j++) {
                if (i.getName().equals(ingredientArrayList.get(j).getName()) && i.getId().equals(ingredientArrayList.get(j).getId())) {
                    increaseCalorie((i.getQuantity() * i.getCalorie()));

                    ingredientArrayList.get(j).incrementQuantity(i.getQuantity());
                    break;
                }
            }
        } else {
            increaseCalorie((i.getQuantity() * i.getCalorie()));
            this.ingredientArrayList.add(i);
        }
    }

    /*
    method to get array list
     */
    public ArrayList<Ingredient> getIngredientArrayList() {
        return ingredientArrayList;
    }

    /*
    make a new list pointer
     */
    public void setIngredientArrayList(ArrayList<Ingredient> ingredientArrayList) {
        this.ingredientArrayList = ingredientArrayList;
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
    method to get name
     */
    public String getName() {
        return name;
    }

    /*
    method to set name
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
    method to get id
     */
    public String getId() {
        return id;
    }

    /*
    method to set id
     */
    public void setId(String id) {
        this.id = id;
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
