package comp3350.dishproject.presentation;

public class HomeCard {

    private int background;
    private String recipeName;

    /*
    Input: Takes in a int for background and string of the recipe name
    Output: Constructor
    Description: Constructor for item object, which will be displayed on home page cards
    */
    public HomeCard(int background, String recipeName) {
        this.background = background;
        this.recipeName = recipeName;
    }

    /*
    Description: Getter for background image
     */
    public int getBackground() {
        return background;
    }

    /*
    Description: Setter for background image
    */
    public void setBackground(int background) {
        this.background = background;
    }
    /*
    Description: Getter for recipe title
    */
    public String getRecipeName() {
        return recipeName;
    }

    /*
    Description: Setter for Recipe Title
     */
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
}
