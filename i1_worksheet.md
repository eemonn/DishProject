Iteration 1 Worksheet
=====================

Adding a feature
-----------------

Tell the story of how one of your features was added to the project.
Provide links to the
feature, user stories, and merge requests (if used), associated tests, and merge commit
that was used complete the feature.

Use one or two paragraphs which can have point-form within them.

Exceptional code
----------------

Provide a link to a test of exceptional code. In a few sentences,
provide an explanation of why the exception is handled or thrown
in the code you are testing.

test for exceptional code can be found [here](https://code.cs.umanitoba.ca/winter-2022-a02/group-4/dish-project/-/blob/fake-database-emon/app/src/test/java/comp3350/dishproject/tests/persistence/dbTest.java). 

This exception is added to the test class dbTest on the test method exceptionTest() method. In DataAcess class we are adding our items to an 
arraylist. Initially, we are added 5 items there. Therefore, when we are trying to get out any items more than the arraylist holds then it throws 
"outOfBoundException" since it get past the array of items where that index in the array does not have any items.

Branching
----------

Provide a link to where you describe your branching strategy.

Provide screen shot of a feature being added using your branching strategy
successfully. The [GitLab Graph tool can do this](https://code.cs.umanitoba.ca/comp3350-summer2019/cook-eBook/-/network/develop),
as well as using `git log --graph`.

SOLID
-----

After a thorough check about SOLID principles in the codebase of Group 5. We did not find any violations so far. The codes were organized. 

Link to the issue created: https://code.cs.umanitoba.ca/winter-2022-a02/group-5/nibble-pad/-/issues/27

Agile Planning
--------------

Write a paragraph about any plans that were changed. Did you
'push' any features to iteration 2? Did you change the description
of any Features or User Stories? Have links to any changed or pushed Features
or User Stories.
