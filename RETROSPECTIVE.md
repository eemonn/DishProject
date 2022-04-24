Retrospective
====

---
#### Part of project that has not been as successful as we would've liked and how we can improve it this iteration.
--------------

As a team, we met for our iteration 2 retrospective and we discussed both the good and bad things that happened over the past two iterations. As a team, we felt that we had a really good foundation for the team and many things were going smoothly. There were some things however that we felt we needed to adjust for the future. We discussed needing to work more on communication and things like meeting deadlines better. During the retrospective, the team felt that our feature of home cards(and the corresponding home page) felt underwhelming and not fully realised in terms of customer experience.

 For our initial design, the homepage was nothing more than a place for buttons to go to specific recipes. We wanted this homepage to be more dynamic, making new recipes be added directly to the homepage and be accessible from there as well. We also wanted to make sure the layout of the cards had meaning and this could be accomplished by allowing the users to favourite certain recipes. As a team, we agreed that we would devote more time and effort into making the home page and home cards more fleshed out.

The first way of improvement was to add integration for dynamic home card addition to the homepage.There was some technical debt to resolve with this. We had not properly planned for the home card adapter to reset when a recipe was added, so we would only see the new recipe if we closed the app and re-opened it (as onCreate()  would be called). By having a dynamic home card addition, it acts like a signal to the customer showing that their recipe has successfully been added to the system.So to improve the design of the home cards, we needed to make the cards update in real time as a recipe is added to the system.

The second way of improvement was making recipes capable of being favourites. Similar to the above paragraph, we had an issue with recipes not showing up as favourites until the app was closed, because the home card adapter could not refresh. So in addition to needing the favourite system to update in real time(for the sake of the customer), we also needed an icon to show if a recipe was a favourite. This icon will mean the customer will instantly know if that recipe was favoured by them(in case they forget).

Additionally, we needed to add the ability to sort the home cards when they were being displayed, so that favourite recipes would show up at the top always. This was done again for the improvement of the customer experience. We wanted to have the customer access their favourite recipes first as they are more likely to open them than non-favourite recipes.

After following our set out improvements, as a team we will have another retrospective at the end of iteration 3 to determine the success of our new vision regarding the home cards.In order to know we were successful from an objective point of view, we would see if we had completed all the features related to the home cards at the end of the iteration. If we had completed each feature associated with improving the home cards during this iteration, we would say that the improvement of the home cards was a success. For a subjective point of view, we would get customers feedback on the new design of the home cards and homepage and see if they prefer it to the old design.


#### Project Velocity
--- 
![](./ProjectVelocity.png)
