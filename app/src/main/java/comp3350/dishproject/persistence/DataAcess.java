package comp3350.dishproject.persistence;
import comp3350.dishproject.presentation.item;
import java.util.ArrayList;

public class DataAcess implements fakeDB{
    private ArrayList<item> reciPe;

    //constructor
    public DataAcess(){
        reciPe=new ArrayList<item>();
    }

    //adding items
    @Override
    public void addRecipe(item name) {
         //when we want to add new recipe to the existing ones.
            this.reciPe.add(name);
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
        int reTruncode=-3; // if no recipe found to delete return -3
        boolean track=false;
        item nameOfRecipe;
        int i=0;
        while(i< reciPe.size() && !track){
            nameOfRecipe=reciPe.get(i); // getting the recipe from the from first Index
            if(nameOfRecipe.getRecipeName().equals(name)){
                track=true;
                reciPe.remove(i);
                reTruncode=1; // when successfully remove something it will 1
            }
            else{
                if(track==false){//if not found the movie name with the index i, just increment i
                    i++;
                }
            }
        }
        return reTruncode;
    }

    //returning all items at once
    @Override
    public ArrayList<item> getAllRecipe() {
        return this.reciPe;
    }
}
