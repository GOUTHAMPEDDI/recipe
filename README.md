<h1 align="center"> Recipe Management System</h1>

>### Framework Used 
* [SpringBoot](javatpoint.com/spring-boot-tutorial)

>### Language Used
* [Java](https://www.java.com/en/download/help/whatis_java.html)
>## Data flow
In this project, we have four layers-
* **Controller** - The controller layer handles the HTTP requests, translates the JSON parameter to object, and authenticates the request and transfer it to the business (service) layer.
* **Repository** - Here database is stored, for which I have used arrayList. In the database layer, CRUD operations are performed.
* **Service** -The business layer handles all the business logic. It consists of service classes and uses services provided by data access layers.
* **Model** - Here the classes recipe, user, authentication token, comment is defined and the mappings were given to them accordingly.

>## Data Structure used in my project
In our project [List](https://www.geeksforgeeks.org/internal-working-of-list-in-java/) and the methods involved with List, like add method for posting new Recipe, remove method for deleting a Recipe, and linear search function for searching a user in Java by specific userId.
>## Project Summary
Our project basically maintains the upcoming recipe information which includes -
* RecipeId
* RecipeName
* RecipeIngredients
* RecipeInstructions
* Commenter
* RecipeOwner

The above project implements a Recipe Management in which the endpoints provided are:-

* SignUp user
* SignIn user
* Add recipe
* Update recipe
* Get all recipies
* Delete recipe by Id
* Get recipe by Id
* Add comment on recipe
* Get all comments on recipe
* Delete comment by Id
* Sign out user

* The above operations are performed only by successfull authorisation of a particular user.
