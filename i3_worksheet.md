What technical debt has been cleaned up
========================================

<ins>Homecards Reckless Inadvertent</ins>

[Commit](https://code.cs.umanitoba.ca/winter-2022-a02/group-4/dish-project/-/commit/f6e61bed5a17743f0e9991d515c066d00e3bb139)

One of the biggest technical debts we payed off in iteration 3 related to our home cards. 
We had not properly planned out the dynamic adding of recipes to the home page, and because of this we were forced to close the app and restart it to have new recipes show up. 
I would call this **Reckless Inadvertent** because it was an oversight on our part, due to lack of planning. 
This was resolved by having the positive button in the add Recipe dialog, call for the home card recycler to refresh.
Fixing this technical debt allowed us a lot more opportunities to improve our home page, because we could now easily refresh the list (meaning we could sort, add favorite, and most importantly display new recipes). 

What technical debt did you leave?
==================================

We planned to remove an input field which asks user to provide the quantity required for an ingredient. However, all the UI and Database layer is already done. This creates a dependency issue which requires fixing a lot of classes. Upon inspection, we decided to not further change it. Fixing this issue requires a lot of code refactoring which given the time iteration 3 is due is hard to resolve. This means we can try and implement it later. It is hard to modify the database classes quickly. This type of debt was reckless inadvertant as we ignored design to move quickly.

Discuss a Feature or User Story that was cut/re-prioritized
============================================

When did you change the priority of a Feature or User Story? Why was it
re-prioritized? Provide a link to the Feature or User Story. This can be from any
iteration.

Fortunately, we did not have to change the priority of a feature or user story and we were able to implement them as they were designed right from the beginning. We were able to complete each user stories and feature for each of the iteration we had set. 

Acceptance test/end-to-end
==========================

Write a discussion about an end-to-end test that you wrote. What did you test,
how did you set up the test so it was not flaky? Provide a link to that test.

One of the most important end-to-end tests for the system was testing the add recipe functionality of the app. For this feature, the user should be able to specify a name, ingredients and their weights, and the directions of a desired recipe to be added to the system. So this test needed to open up the add dialog, add in text to the dialog, click the add button, check that the recipe is in the system, and then delete the newly added recipe to get the system back to normal state. A flaky test is a test that sometimes works and sometimes doesn't. In order to make this test not flaky, we first ran the test in a random order(with other tests). In addition, we debugged the code until we found a way which it fails. It fails if a recipe is already added in the system. To combat this, we made sure we picked a recipe that didn't exist within the system. We also ran the test multiple times to ensure that it worked everytime.

Link: - once we push to main


Acceptance test, untestable
===============

What challenges did you face when creating acceptance tests? What was difficult
or impossible to test?

One challenge that we faced when writing acceptance tests was interacting with dynamically created objects. In order to ensure our test would always be deterministic and pass every time, we had to make sure that we had the right order of actions in the app. This meant that we needed to fully flesh out the acceptance test first in writing to make sure all dynamically created objects were actually created and created in the right order. Within our app, there was nothing really difficult/impossible to test. We made our app have very few dependencies and this allowed us to fully test all user stories with our app.

Links to where this challenge:



Velocity/teamwork
=================

Did your estimates get better or worse through the course? Show some
evidence of the estimates/actuals from tasks.

We can see from our velocity chat that we have good estimation on iteration 1 and iteration 3. Estimated time and time needed for actual work do not differ that much. on the contrary, in  iteration 2 our estimted time goes a bit up compared to time spent for the work. This is becuase  when we moved from iteration 1 to iteration 2 it seemed at first that we migh need some  more time for iteration 2 as a few technical debts arose in iteration 1. So for  removing those techincal debts as well as implementing new features for itreation 2  we deemed higher time. But proper synchronization in team members and hard work from team members reduced the time a lot. Hence we able to finish our work way before the estimation time. We used our iteration 2 experience in next iteration thus had a good estimation between estimated and spent time.

[Velocity chart](https://code.cs.umanitoba.ca/winter-2022-a02/group-4/dish-project/-/blob/main/website/ProjectVelocity.png)
