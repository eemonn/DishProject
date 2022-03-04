# Guide to Contributing
---
Guidelines for contributing to the project. This project will follow a Git flow branching strategy with some modifications.

### Branching Strategy
--- 
-  `main` branch will be used for offical realeases for a given interation. No code will be directly added to `master` without a merge request.
-  `develop` branch will be used as integration branch for features. This branch will be treated as pre-production should be a working version. No code will be directly added to `develop` without a merge request except for small spelling or related errors.
-  When working on a feature, you must create a new branch about that feature and work with that branch.
-  Once you are done with the feature, make a merge request to `develop`. All code committed must work and include tests.
-  A clean-Dev branch will be made before merging `develop` to `main` that will make sure code matches standards.

### Branch Naming Conventions
---
- Feature followed by name(if working alone) separated by hypens

### Commit messages
--- 
- Correct spelling and proper grammar
- Use the imperative mood in the subject line
- If you need to, use the body to explain what changes you have made and why you made them

### Merge Requests
--- 
- Give the merge request an appropriate and succinct title.
- Always provide a description with some context.
- A few sentences or bullet points is fine for the description.
- If possible, assign at least 2 to look over a merge request

