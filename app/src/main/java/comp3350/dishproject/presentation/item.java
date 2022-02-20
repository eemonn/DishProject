package comp3350.dishproject.presentation;

public class item {

    int background;
    String recipeName;

    public item() {

    }

    //Constructor for item object, which will be displayed on home page cards
    public item(int background, String recipeName) {
        this.background = background;
        this.recipeName = recipeName;
    }

    //Getter for background image
    public int getBackground() {
        return background;
    }

    //Getter for recipe title
    public String getRecipeName() {
        return recipeName;
    }

    //Setter for background image
    public void setBackground(int background) {
        this.background = background;
    }

    //Setter for Recipe Title
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }


}
