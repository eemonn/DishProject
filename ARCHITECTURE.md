# Architecture Overview
---

We will be using a 3-tier architecture consisting of the presentation, data(persistence), and logic layers. With this architecture, our project is broken up into 5 java packages of `application`, `logic`, `objects`, `persistence`, and `presentation`.
 
## Presentation Layer
---
In its current iteration, the presentation layer contains 4 classes of HomeCard, viewRecipe, Adapter, and MainActivity.
- `mainActivity` acts as the homepage for our app. Within this home screen, it will contain the popular dish "cards" that provides the user quicker access to these recipes. Recipes that can't be accessed this way are accessible via the search bar. It will also contain a navigation bar that allows the user to add a recipe into the system.
- `HomeCard` is used as a helper class in displaying the popular recipe cards on the homepage.
- `ViewRecipe` will be used to show the recipes the user is looking at. Within this will be pictures, directions, ingredients, and a rating system.
- `Adapter` is used as a helper class in displaying the popular recipe cards on the homepage.
- `AddDialog` is used as a GUI feature that opens up a user input field that lets the user add their own recipe to the system.
- `Messages` will be used for displaying error and warning messages to the user.
- `ShoppingCartActivity` is the page responsible for displaying the shopping cart list.
- `ShoppingCartAdapter` is a helper method to display the shopping cart.

## Persistence Layer
---
- `StepsPersistence` is the interface that handles the updating, validation, and loading of the directions for a given recipe using the domain object `Steps`.
- `RecipePersistence` is the interface that handles the updating, removal, validation, adding, and loading of a specific recipe using the domain object `Recipe`.
- `IngredientPersistence` is the interface that handles loading, validation, and updating of certain ingredients for a given recipe using the domain object `Ingredient`.
- There are 3 HSQLDB files which implement the methods specified in the interfaces named `StepsPersistenceHSQLDB`, `RecipePersistenceHSQLDB`, and `IngredientsPersistenceHSQLDB`
- There are 3 Stub files which implement the methods specified in the interface named `StepsPersistenceStub`, `RecipePersistenceStub`, and `IngredientsPersistenceStub`
- `Services`,` Main`, and `DBHelper` are all additional classes that aid with using and operating the HSQLDB database

## Logic Layer
---
- `ShowRecipe` handles all the logic and information about the recipe that the user is trying to look at.
- `AccessRecipes` will contain functionality for accessing and checking data from the recipe persistence interface. 
- `AccessSteps` will contain functionality for accessing data from the steps persistence interface. 
- `AccessIngredients` will contain functionality for accessing data from the ingredients persistence interface. 
- `AddRecipe` will be the helper class to add a recipe into the system
- `AccessShoppingCart` will contain functionality for accessing and checking data from the shopping cart persistence interface. 


## Domain Specific Objects
---
- `Ingredient` will be used to contain information about the ingredients in any given dish.
- `Recipe` contains most of the information surrounding the actual preparation of the dish.
- `Steps` will contain all information related to the directions of making a given recipe.

## Diagram
---
![diagram](arc.png)
