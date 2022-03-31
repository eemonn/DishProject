package comp3350.dishproject.persistence.stubs;

import java.util.ArrayList;
import java.util.List;


import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.objects.Steps;
import comp3350.dishproject.persistence.StepsPersistence;

public class StepsPersistenceStub implements StepsPersistence {
    private final List<Steps> directions;

    /*
    Description: Constructor
     */
    public StepsPersistenceStub() {
        this.directions = new ArrayList<>();
        final Recipe burger = new Recipe("Burger", "100",5);
        final Recipe pizza = new Recipe("Pizza", "200",4);
        final Recipe taco = new Recipe("Taco", "300",3);
        final Recipe pancake = new Recipe("Pancake", "400",1);
        final Recipe fish = new Recipe("Fish", "500",1.5);

        final String d1 = "Cheese on top of beef and put that between buns";
        final String d2 = "Sauce and Cheese on dough and cook";
        final String d3 = "Beef and cheese into shell";
        final String d4 = "Cook batter and put syrup and butter on top";
        final String d5 = "Put salt on fish and cook";

        this.directions.add(new Steps(d1,burger.getRecipeID()));
        this.directions.add(new Steps(d2,pizza.getRecipeID()));
        this.directions.add(new Steps(d3,taco.getRecipeID()));
        this.directions.add(new Steps(d4,pancake.getRecipeID()));
        this.directions.add(new Steps(d5,fish.getRecipeID()));
    }

    /*
    Input: takes in a string of the recipe ID
    Output: returns a string of that recipes directions
    Description: returns a string of a given recipes directions
     */
    @Override
    public String getDirections(final String recipeID) {
        for(int i=0;i<directions.size();i++) {
            Steps s = directions.get(i);
            if(s.getRecipeID().equals(recipeID)) {
                return s.getDirections();
            }
        }
        return "No Directions";
    }

    /*
    Input: takes in a string of the recipe ID and a string of new directions
    Output: boolean
    Description: updates a recipes directions
     */
    @Override
    public boolean updateDirections(final String recipeID, String newDirections) {
        for(int i=0;i<directions.size();i++) {
            Steps s = directions.get(i);
            if(s.getRecipeID().equals(recipeID)) {
                s.setDirections(newDirections);
                return true;
            }
        }
        return false;
    }

    /*
    Input: String of directions and recipe object
    Output: boolean
    Description: adds steps of a given new recipe
     */
    @Override
    public boolean insertSteps(final String directions,Recipe r){
        if(getDirections(r.getRecipeID()).equals("No Directions")) {
            this.directions.add(new Steps(directions,r.getRecipeID()));
            return true;
        } else {
            return false;
        }
    }
}
