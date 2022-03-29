Iteration 2 Worksheet
=====================

## Paying off technical debt
---


Show two instances of your group paying off technical debt. For these two instances:
- Explain how your are paying off the technical debt.
- Show commits, links to lines in your commit where you paid off technical debt.
- Classify the debt, and justify why you chose that classification with 1-3 sentences.

Fake database
-----------------
We payed off our technical debt with our fake database when we implemented our HSQLDB 
The debt would likely be Prudent Deliberate.
- The reason for this is because we knew that we would be taking on technical debt by implementing a fake database in iteration 1 and we decided to do it anyways to prioritize other features. We had to make a significant amount of changes when we implemented the real database, but using the fake DB allowed us to get our foundations down quickly. 

Home cards 
-----------
This is a rather small technical debt but still debt none the less. The add recipe feature implemented a button so that we could test the dialog and finish the feature, however this button was not what we wanted. We want to have the button in the navigation bar, however, it was better to implement an extra button for now than to halt production until it was done. 

This debt would again be prudent deliberate. 
- The reason for this is because again we knew that we were adding this debt, and we knew how we were going to fix it. As soon as the navbar was finished we were able to resolve the technical debt. 



## SOLID
---

Find a SOLID violation in the project of group with the same group number in the next class over - (n%3)+1 (A03 does A01) Open an issue in their project with the violation, clearly explaining the SOLID violation - specifying the type, provide a link to that issue. Be sure your links in the issues are to specific commits (not to main, or develop as those will be changed).

Provide a link to the issue you created here.

## Retrospective
---

Describe how the retrospective has changed the way you are doing your project. Is there evidence of the change in estimating/committing/peer review/timelines/testing? Provide those links and evidence here - or explain why there is not evidence.

In the past iteration we have a bit communication gap between team members because not all the team members are located in the same time zone. Name of the different time zones are following:

[Winnipeg timezone](https://greenwichmeantime.com/time-zone/north-america/canada/manitoba/winnipeg/time/)

[Other timezone](https://greenwichmeantime.com/time/bangladesh/)


But we minimized that by communicating well this time and divided up our work, and got our jobs done as best we could. We also came forward and put everything together at the end.

There is no evidence of change in estimating/timelines/testing on GitLab itself but we communicated internally using our own mediums of communication (Discord). 


## Design patterns
---

Show links to your project where you use a well-known design pattern. Which pattern is it? Provide links to the design pattern that you used(not dependency Injection.

We have used the Special Case/Null object design pattern. This means that a variable can be null in our system, we would have to surround it with null checking and avoidance in the case that the object was null. Instead of clogging up the code with this, we instead return a special case that has the same interface as what the caller is expecting. This helps by simplifying code and providing more reliability.

Links:

[Ex: 1](https://code.cs.umanitoba.ca/winter-2022-a02/group-4/dish-project/-/blob/clean-dev-iter2/app/src/main/java/comp3350/dishproject/persistence/hsqldb/RecipePersistenceHSQLDB.java#L79)

[Ex: 2](https://code.cs.umanitoba.ca/winter-2022-a02/group-4/dish-project/-/blob/clean-dev-iter2/app/src/main/java/comp3350/dishproject/persistence/hsqldb/RecipePersistenceHSQLDB.java#L105)

[Ex: 3](https://code.cs.umanitoba.ca/winter-2022-a02/group-4/dish-project/-/blob/clean-dev-iter2/app/src/main/java/comp3350/dishproject/persistence/hsqldb/StepsPersistenceHSQLDB.java#L50)

[Ex: 4](https://code.cs.umanitoba.ca/winter-2022-a02/group-4/dish-project/-/blob/clean-dev-iter2/app/src/main/java/comp3350/dishproject/persistence/stubs/RecipePersistenceStub.java#L50)

[Testing Ex: 1](https://code.cs.umanitoba.ca/winter-2022-a02/group-4/dish-project/-/blob/clean-dev-iter2/app/src/test/java/comp3350/dishproject/tests/logic/AccessRecipesTestIT.java#L63)

[Testing Ex: 2](https://code.cs.umanitoba.ca/winter-2022-a02/group-4/dish-project/-/blob/clean-dev-iter2/app/src/test/java/comp3350/dishproject/tests/logic/AccessRecipesTestIT.java#L63)


## Iteration 1 Feedback fixes
---

[Issue 1](https://code.cs.umanitoba.ca/winter-2022-a02/group-4/dish-project/-/issues/56) was about having Android specific annotation (import androidx.annotation.NonNull;) in Ingredient and Recipe classes.It was a code smell because it was increasing coupling. We have removed the annotation from both of the classes. 

[Issue 2](https://code.cs.umanitoba.ca/winter-2022-a02/group-4/dish-project/-/issues/55) was about not storing a result in a variable which was later called multiple times in a loop. For instances, In the ShowRecipe class “recipe.getIngredientArrayList().get(i)” was called multiple times in a loop which instead could have been stored in a variable. We have refactored the code and stored it in a variable instead of calling "getIngredientArrayList().get(i)"  each time. 

