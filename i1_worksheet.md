Iteration 1 Worksheet
=====================

Adding a feature
-----------------

Tell the story of how one of your features was added to the project.
Provide links to the
feature, user stories, and merge requests (if used), associated tests, and merge commit
that was used complete the feature.

Use one or two paragraphs which can have point-form within them.

The feature was introduced during our first ideation session as a way for users to search for their favourite dishes by name. As this was a recipe app at the core, we wanted to make sure that we could include as many recipes as possible and have the user be able to access all of them. Without making the UI too clunky, access to all these recipes was to be offered through the search bar. After the ideation period and designing how the search bar would work, the feature was broken down into user stories as a group.
[Feature Issue](https://code.cs.umanitoba.ca/winter-2022-a02/group-4/dish-project/-/issues/3)
[User Story 1](https://code.cs.umanitoba.ca/winter-2022-a02/group-4/dish-project/-/issues/1)
[User Story 2](https://code.cs.umanitoba.ca/winter-2022-a02/group-4/dish-project/-/issues/2)

Once the feature was explained at a high level, the user stories were broken down into developer tasks as a group. These developer tasks were assigned to the person who would be completing this feature. Time estimates within the developer tasks were formulated as a team to ensure the feature would not take too much time for one person.
[Dev Task 1](https://code.cs.umanitoba.ca/winter-2022-a02/group-4/dish-project/-/issues/23)
[Dev Task 2](https://code.cs.umanitoba.ca/winter-2022-a02/group-4/dish-project/-/issues/24)
[Dev Task 3](https://code.cs.umanitoba.ca/winter-2022-a02/group-4/dish-project/-/issues/25)
[Dev Task 4](https://code.cs.umanitoba.ca/winter-2022-a02/group-4/dish-project/-/issues/26)
[Dev Task 5](https://code.cs.umanitoba.ca/winter-2022-a02/group-4/dish-project/-/issues/27)

After the developer tasks were created and a rough deadline assigned, the feature was coded. This feature was heavily focused around UI and thus no unit tests were implemented in Iteration 1. Since it was a UI feature, there were design and feedback sessions held throughout the coding process to make sure the design fit with the other UI components. Once the coding was finished, the feature was merged into the `develop` branch following the approval of another team member. Once merged, the associated issues were closed.
[Merge request](https://code.cs.umanitoba.ca/winter-2022-a02/group-4/dish-project/-/merge_requests/10)
[Merge Commits](https://code.cs.umanitoba.ca/winter-2022-a02/group-4/dish-project/-/merge_requests/10/commits)


Exceptional code
----------------

Provide a link to a test of exceptional code. In a few sentences,
provide an explanation of why the exception is handled or thrown
in the code you are testing.

test for exceptional code can be found [here](https://code.cs.umanitoba.ca/winter-2022-a02/group-4/dish-project/-/blob/main/app/src/test/java/comp3350/dishproject/tests/persistence/dbTest.java). 

This exception is added to the test class dbTest on the test method exceptionTest() method. In DataAcess class we are adding our items(Homecards) to 
an arraylist. Initially, we are added 5 items there. Therefore, when we are trying to get out any items more than the arraylist holds then it throws 
"outOfBoundException" since it get past the array of items where that index in the array does not have any items.

Branching
----------

**Linked to Branching strategy: 
[Branching Guideline](https://code.cs.umanitoba.ca/winter-2022-a02/group-4/dish-project/-/blob/main/ContributingGuidelines.md)**

![Branching Strategy Graph](/branchPhoto.png)

An example of our branching strategy is shown above. Tim first pulled existing Development to his own branch. Then he merged it locally and pushed his branch to Development. 

SOLID
-----

After a thorough check about SOLID principles in the codebase of Group 5. We did not find any violations so far. The codes were organized. 

Link to the issue created: https://code.cs.umanitoba.ca/winter-2022-a02/group-5/nibble-pad/-/issues/27

Agile Planning
--------------

We were fortunate enough not to have to move any of our features to iteration 2, as we properly planned for iteration 1. However, we actually ended up 
needing to implement a feature that we had not thought about originally. We had planned all of the main pages and important features for our app and forgotten that 
we would require a home/landing page. This feature was added to our issues early in iteration 1 and we drew out a simple design prototype. The code for the homepage UI was 
written and upon seeing it, we made a design change to it and ended up completely overhauling and redesigning the UI. The new UI was written and implemented towards the end of iteration 1. 

**Linked Feature: 
[Homepage](https://code.cs.umanitoba.ca/winter-2022-a02/group-4/dish-project/-/issues/19)**
