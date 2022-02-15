# Coding Standards
---

### Naming Conventions
---
- Constants are all uppercase with words seperated by underscores
- Methods should be in verbs
- Be consistent for related ideas such as getString1() vs. retrieveString2()
- variables and methods are camelcase
- Classes and interfaces should be camelcase, but start with a captial
- Avoid acronyms
- Booleans should be two words, starting with is or has
- 

### Comments
---
- Comments should not duplicate the code.
- No line-by-line comments
- Comments should be clear, succient, and clear any confusion
- Each method should have a comment block above their signature of the following form:
```Java
/* 
MethodName
* Inputs:
* Outputs:
* Description:
*/
```
### Methods
---
- There should be a space before the opening brace. 
- The opening brace is on the same line as the method signature.
- No extra whitespace between the end of code and closing brace and the closing brace should be on its own line.
- Methods should follow this template.
 ```Java
public int methodName(parameters) {
    //code
}
```
### Loops
---
- Loops follow same template as methods.
```Java
for (int i = 0; i < 25; i++) {
  //code
}

```
