package comp3350.dishproject.persistence;
import comp3350.dishproject.R;
import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.presentation.HomeCard;

import java.util.ArrayList;

public class DataAccess implements DBInterface {
    private ArrayList<HomeCard> recipe;
    private int size;
    private String[] arrDishes;
    private Recipe burger;

    /*
    Input: No input
    Output: Constructor
    Description: constructor for the fake database of iteration 1
     */
    public DataAccess(){
        arrDishes=new String[]{"Burger", "Pizza", "Tacos", "Pancake", "Fish", "Pickles", "Parm",
                "Chicken Parm", "Paella", "Panfish", "Papaw", "Pecan Pie", "Persimmon", "Pheasant"};

        //Home Page Cards
        recipe=new ArrayList<>();
        recipe.add(new HomeCard(R.drawable.burger, "Bobby's Burger"));
        recipe.add(new HomeCard(R.drawable.pizza, "Paul's Pizza"));
        recipe.add(new HomeCard(R.drawable.taco, "Timmy's Taco"));
        recipe.add(new HomeCard(R.drawable.pancake, "Patricia's Pancake"));
        recipe.add(new HomeCard(R.drawable.fish, "Freddy's Fish"));

        //Burger Page
        burger = new Recipe("Bobby's Burger", "1", 600.0, 450, new ArrayList<>());
        Ingredient i = new Ingredient("Apple", "2", 2, 200.0, 2.0);
        Ingredient i1 = new Ingredient("Banana", "1", 1, 100.0, 1.0);
        Ingredient i2 = new Ingredient("Orange", "3", 3, 300.0, 3.0);
        burger.addIngredient(i);
        burger.addIngredient(i1);
        burger.addIngredient(i2);
        String recipeSteps = "Step 1\n" +
                "In a bowl, mix ground beef, egg, onion, bread crumbs, Worcestershire, garlic, 1/2 " +
                "teaspoon salt, and 1/4 teaspoon pepper until well blended. Divide mixture into four " +
                "equal portions and shape each into a patty about 4 inches wide.\n" +
                "\n" +
                "Step 2\n" +
                "Lay burgers on an oiled barbecue grill over a solid bed of hot coals or high heat " +
                "on a gas grill (you can hold your hand at grill level only 2 to 3 seconds); close " +
                "lid on gas grill. Cook burgers, turning once, until browned on both sides and no " +
                "longer pink inside (cut to test), 7 to 8 minutes total. Remove from grill.\n" +
                "\n" +
                "Step 3\n" +
                "Lay buns, cut side down, on grill and cook until lightly toasted, 30 seconds to 1 " +
                "minute.\n" +
                "\n" +
                "Step 4\n" +
                "Spread mayonnaise and ketchup on bun bottoms. Add lettuce, tomato, burger, onion, " +
                "and salt and pepper to taste. Set bun tops in place.";
        burger.setDirectionMethod(recipeSteps);
        size=5;//how many home cards we have
    }

    /*
    Input: takes in home card object
    Output: void
    Description: Adds a recipe to the existing ones as a home card
     */
    @Override
    public void addRecipe(HomeCard name) {
            this.recipe.add(name);
            size++;
    }

    /*
    Input: takes in string name
    Output: returns an array list of type homecards
    Description: returns a list of recipes on our homecards that matches the string name
     */
    @Override
    public ArrayList<HomeCard> getRecipe(String name) {
        ArrayList<HomeCard> returnRecipe = new ArrayList<>();
        for(HomeCard i:this.recipe){
            if(i.getRecipeName().equals(name)){
                returnRecipe.add(i); //adding searched recipe name
            }
        }
        return returnRecipe;
    }

    /*
    Input: takes in string name of recipe to remove
    Output: returns error code indicating success or not
    Description:
     */
    @Override
    public int removeRecipe(String name) {
        int errorCode=-3; // if no recipe found to delete return -3
        boolean isTracked = false;
        HomeCard nameOfRecipe;
        int i=0;
        while(i< recipe.size() && !isTracked){
            nameOfRecipe=recipe.get(i); // getting the recipe from the from first Index
            if(nameOfRecipe.getRecipeName().equals(name)){
                isTracked=true;
                recipe.remove(i);
                size--;
                errorCode=1; // when successfully remove something it will 1
            }
            if(!isTracked){//if not found the recipe name with the index i, just increment i
                    i++;
            }
        }
        return errorCode;
    }

    /*
    Description: returned all home cards
     */
    @Override
    public ArrayList<HomeCard> getAllRecipe() {
        return this.recipe;
    }

    /*
    Description: getting how many recipes we have
     */
    public int getSizeofRecipe(){
        return this.size;
    }

    /*
    Description: get Dishes to be used in search suggestions. Different than home cards since it
    should contain all recipes
     */
    @Override
    public String[] getDishes() {
       return this.arrDishes;
    }

    /*
    Description: return the burger recipe object used in iteration 1
     */
    @Override
    public Recipe getRecipe() {
        return burger;
    }
}
