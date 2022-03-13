package comp3350.dishproject.persistence.stubs;

import java.util.ArrayList;
import java.util.List;


import comp3350.dishproject.objects.Recipe;
import comp3350.dishproject.objects.Steps;
import comp3350.dishproject.persistence.StepsPersistence;

public class StepsPersistenceStub implements StepsPersistence {
    private List<Steps> directions;

    public StepsPersistenceStub() {
        this.directions = new ArrayList<>();
        final Recipe burger = new Recipe("Burger","100");
        final Recipe pizza = new Recipe("Pizza","200");
        final Recipe taco = new Recipe("Taco","300");
        final Recipe pancake = new Recipe("Pancake","400");
        final Recipe fish = new Recipe("Fish","500");

        final String d1 = "Cheese on top of beef and put that between buns";
        final String d2 = "Sauce and Cheese on dough and cook";
        final String d3 = "Beef and cheese into shell";
        final String d4 = "Cook batter and put syrup and butter on top";
        final String d5 = "Put salt on fish and cook";


        this.directions.add(new Steps(d1,burger));
        this.directions.add(new Steps(d2,pizza));
        this.directions.add(new Steps(d3,taco));
        this.directions.add(new Steps(d4,pancake));
        this.directions.add(new Steps(d5,fish));

    }

    public String getDirections(final String recipeID) {
        for(int i=0;i<directions.size();i++) {
            Steps s = directions.get(i);
            if(s.getRecipeID().equals(recipeID)) {
                return s.getDirections();
            }
        }
        return "Not found";
    }

    public void updateDirections(final String recipeID, String newDirections) {
        for(int i=0;i<directions.size();i++) {
            Steps s = directions.get(i);
            if(s.getRecipeID().equals(recipeID)) {
                s.setDirections(newDirections);
            }
        }
    }
}
