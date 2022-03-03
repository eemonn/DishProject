package comp3350.dishproject.persistence;
import comp3350.dishproject.R;
import comp3350.dishproject.objects.Ingredient;
import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.presentation.HomeCard;

import java.util.ArrayList;

public class DataAcess implements DBInterface {
    public ArrayList<HomeCard> reciPe;
    public int size;
    public String[] arrDishes;
    public Recipe burger;
    //constructor
    public DataAcess(){
        arrDishes=new String[]{"Burger", "Pizza", "Tacos", "Pancake", "Fish", "Pickles", "Parm",
                "Chicken Parm",
                "Paella", "Panfish", "Papaw", "Pecan Pie", "Persimmon", "Pheasant"};
        reciPe=new ArrayList<HomeCard>();
        reciPe.add(new HomeCard(R.drawable.burger, "Bobby's Burger"));
        reciPe.add(new HomeCard(R.drawable.pizza, "Paul's Pizza"));
        reciPe.add(new HomeCard(R.drawable.taco, "Timmy's Taco"));
        reciPe.add(new HomeCard(R.drawable.pancake, "Patricia's Pancake"));
        reciPe.add(new HomeCard(R.drawable.fish, "Freddy's Fish"));
        burger = new Recipe("Bobby's Burger", "1", 600.0, 450, new ArrayList<Ingredient>());
        Ingredient i = new Ingredient("Apple", "2", 2, 200.0, 2.0);
        Ingredient i1 = new Ingredient("Banana", "1", 1, 100.0, 1.0);
        Ingredient i2 = new Ingredient("Orange", "3", 3, 300.0, 3.0);
        burger.addIngredient(i);
        burger.addIngredient(i1);
        burger.addIngredient(i2);
        String ss = "Step 1\n" +
                "In a bowl, mix ground beef, egg, onion, bread crumbs, Worcestershire, garlic, 1/2 teaspoon salt, and 1/4 teaspoon pepper until well blended. Divide mixture into four equal portions and shape each into a patty about 4 inches wide.\n" +
                "\n" +
                "Step 2\n" +
                "Lay burgers on an oiled barbecue grill over a solid bed of hot coals or high heat on a gas grill (you can hold your hand at grill level only 2 to 3 seconds); close lid on gas grill. Cook burgers, turning once, until browned on both sides and no longer pink inside (cut to test), 7 to 8 minutes total. Remove from grill.\n" +
                "\n" +
                "Step 3\n" +
                "Lay buns, cut side down, on grill and cook until lightly toasted, 30 seconds to 1 minute.\n" +
                "\n" +
                "Step 4\n" +
                "Spread mayonnaise and ketchup on bun bottoms. Add lettuce, tomato, burger, onion, and salt and pepper to taste. Set bun tops in place.";

        burger.setDirectionMethod(ss);
        size=5;


    }

    //adding items
    @Override
    public void addRecipe(HomeCard name) {
         //when we want to add new recipe to the existing ones.
            this.reciPe.add(name);
            size++;
    }

    @Override
    public ArrayList<HomeCard> getRecipe(String name) {
        ArrayList<HomeCard>returnRecipe=new ArrayList<HomeCard>();
        for(HomeCard i:this.reciPe){
            if(i.getRecipeName().equals(name)){
                returnRecipe.add(i); //adding searched recipe name
            }
        }
        return returnRecipe;
    }

    @Override
    public int  removeRecipe(String name) {
        int reTurncode=-3; // if no recipe found to delete return -3
        boolean track=false;
        HomeCard nameOfRecipe;
        int i=0;
        while(i< reciPe.size() && !track){
            nameOfRecipe=reciPe.get(i); // getting the recipe from the from first Index
            if(nameOfRecipe.getRecipeName().equals(name)){
                track=true;
                reciPe.remove(i);
                size--;
                reTurncode=1; // when successfully remove something it will 1
            }

            if(track==false){//if not found the movie name with the index i, just increment i
                    i++;

            }
        }
        return reTurncode;
    }

    //returning all items at once
    @Override
    public ArrayList<HomeCard> getAllRecipe() {
        return this.reciPe;
    }

    public int getSizeofRecipe(){
        return this.size;
    }

    @Override
    public String[] getDishes() {
       return this.arrDishes;

    }

    @Override
    public Recipe getRecipe() {
        return burger;
    }
}
