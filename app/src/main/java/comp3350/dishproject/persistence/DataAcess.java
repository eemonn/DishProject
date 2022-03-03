package comp3350.dishproject.persistence;
import comp3350.dishproject.R;
import comp3350.dishproject.presentation.item;
import java.util.ArrayList;

public class DataAcess implements fakeDB{
    public ArrayList<item> reciPe;
    public int size;
    //constructor
    public DataAcess(){

        reciPe=new ArrayList<item>();
        reciPe.add(new item(R.drawable.burger, "Bobby's Burger"));
        reciPe.add(new item(R.drawable.pizza, "Paul's Pizza"));
        reciPe.add(new item(R.drawable.taco, "Timmy's Taco"));
        reciPe.add(new item(R.drawable.pancake, "Patricia's Pancake"));
        reciPe.add(new item(R.drawable.fish, "Freddy's Fish"));
        size=5;
    }

    //adding items
    @Override
    public void addRecipe(item name) {
         //when we want to add new recipe to the existing ones.
            this.reciPe.add(name);
            size++;
    }

    @Override
    public ArrayList<item> getRecipe(String name) {
        ArrayList<item>returnRecipe=new ArrayList<item>();
        for(item i:this.reciPe){
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
        item nameOfRecipe;
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
    public ArrayList<item> getAllRecipe() {
        return this.reciPe;
    }

    public int getSizeofRecipe(){
        return this.size;
    }
}
