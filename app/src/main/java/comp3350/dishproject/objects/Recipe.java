package comp3350.dishproject.objects;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Recipe {
    private String name, id, direction;
    private double calorie, weight;
    private ArrayList<Ingredient> ingredientArrayList;
    private float rating;
    private String recipeID;

    /*
    Input: Takes in a string name, string ID, double calorie, double weight, and an arraylist of
     ingredients
    Output: Constructor
    Description:recipe class will have a name, id, calorie, weight, arraylist of Ingredients
    it also has rating which is set to 0 and direction which is empty
     */
    public Recipe(String name, String recipeID) {
        this.name = name;
        this.id = id;
        this.recipeID = recipeID;
        this.calorie = calorie;
        this.weight = weight;
        this.ingredientArrayList = ingredientArrayList;
        this.rating = 0;
        this.direction = "";
    }

    /*
    Description: method to get weight
     */
    public double getWeight() {
        return weight;
    }
    public String getRecipeID() {return recipeID;}

    /*
    Description: method to set weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /*
    Description: method to set direction
     */
    public void setDirectionMethod(String s) {
        this.direction = s;
    }

    /*
    Description: method to get direction
     */
    public String getDirection() {
        return direction;
    }

    /*
    Description: method to get rating
     */
    public float getRating() {
        return rating;
    }

    /*
    Description: method to set rating
     */
    public void setRating(float rating) {
        this.rating = rating;
    }

    /*
    Input: Takes in ingredient object
    Output: returns a boolean
    Description:method to check if ingredient present in list of ingredients
     */
    public boolean hasIngredient(Ingredient ingredient) {
        for (int i = 0; i < this.getIngredientArrayList().size(); i++) {
            if (ingredient.getName().equals(this.getIngredientArrayList().get(i).getName()) &&
                    ingredient.getId().equals(this.getIngredientArrayList().get(i).getId())) {
                return true;
            }
        }
        return false;
    }

    /*
    Input: takes in an recipe object
    Output: outputs a boolean
    Description: method to check recipe and returns true if the two recipe share the same
    name and id
     */
    public boolean isEquals(Recipe recipeObject) {
        return this.name.equals(recipeObject.name) && this.id.equals(recipeObject.id);
    }

    /*
    Input: takes in ingredient object
    Output: void
    Description: method to remove ingredient from recipe
     */
    public void removeIngredientFromRecipe(Ingredient ingredient) {
        for (int i = 0; i < this.ingredientArrayList.size(); i++) {
            if (ingredient.getName().equals(ingredientArrayList.get(i).getName()) && ingredient.
                    getId().equals(ingredientArrayList.get(i).getId())) {
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
    Input: takes in int num which is the id
    Output: void
    Description: method to update information of ingredient list
     */
    public void updateIngredientList(int num) {
        for (int i = 0; i < this.ingredientArrayList.size(); i++) {
            ingredientArrayList.get(i).setQuantity(ingredientArrayList.get(i).getOriginalCount() * num);
            ingredientArrayList.get(i).setCalorie(ingredientArrayList.get(i).getOriginalCalorie() * num);
            ingredientArrayList.get(i).setWeight(ingredientArrayList.get(i).getOriginalWeight() * num);

        }
    }

    /*
    Description: method to change calorie
     */
    public void increaseCalorie(double x) {
        this.calorie += x;
    }

    /*
    Input: takes in ingredient object i
    Output: void
    Description: method to add recipe. if ingredient already present, only update amount
     */
    public void addIngredient(Ingredient i) {

        if (hasIngredient(i)) {
            for (int j = 0; j < this.ingredientArrayList.size(); j++) {
                if (i.getName().equals(ingredientArrayList.get(j).getName()) && i.getId().
                        equals(ingredientArrayList.get(j).getId())) {
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
    Description: method to get array list
     */
    public ArrayList<Ingredient> getIngredientArrayList() {
        return ingredientArrayList;
    }

    /*
    Description: make a new list pointer
     */
    public void setIngredientArrayList(ArrayList<Ingredient> ingredientArrayList) {
        this.ingredientArrayList = ingredientArrayList;
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
        Description: Replaces toString
         */
    @NonNull
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
