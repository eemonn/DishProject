What technical debt has been cleaned up
========================================

Show links to a commit where you paid off technical debt. Write 2-5 sentences
that explain what debt was paid, and what its classification is.

What technical debt did you leave?
==================================

What one item would you like to fix, and can't? Anything you write will not
be marked negatively. Classify this debt.

Discuss a Feature or User Story that was cut/re-prioritized
============================================

When did you change the priority of a Feature or User Story? Why was it
re-prioritized? Provide a link to the Feature or User Story. This can be from any
iteration.

Acceptance test/end-to-end
==========================

Write a discussion about an end-to-end test that you wrote. What did you test,
how did you set up the test so it was not flaky? Provide a link to that test.

One of the most important end-to-end tests for the system was testing the add recipe functionality of the app. For this feature, the user should be able to specify a name, ingredients and their weights, and the directions of a desired recipe to be added to the system. So this test needed to open up the add dialog, add in text to the dialog, click the add button, check that the recipe is in the system, and then delete the newly added recipe to get the system back to normal state. A flaky test is a test that sometimes works and sometimes doesn't. In order to make this test not flaky, we first ran the test in a random order(with other tests). In addition, we debugged the code until we found a way which it fails. It fails if a recipe is already added in the system. To combat this, we made sure we picked a recipe that didn't exist(the likelihood of a person ever creating that recipe is very low).

Link: - once we push to main


Acceptance test, untestable
===============

What challenges did you face when creating acceptance tests? What was difficult
or impossible to test?

One challenge was creating system tests while not knowing the current state of the system. Our homepage and shopping list page both have different layouts depending on the state of the system. The add recipe functionality also depends on the state of the system. For the add recipe test, we needed to come up with a recipe that would never be added to the system. For this challenge, we had to do some background processing to get the state of the system before moving onto the end-to-end tests. 

Links to where this challenge:



Velocity/teamwork
=================

Did your estimates get better or worse through the course? Show some
evidence of the estimates/actuals from tasks.
