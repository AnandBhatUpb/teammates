The Teammates is a team administration service developed in Spring Boot that handles user-related operations such as retrieving user information, creating new users, editing and deleting user.

## **Endpoints**

`POST /user` creates new users

`PUT /user/{id}` edits the user with given id

`GET /users` returns all the users

`DELETE /user/{id}` deletes user with given id


The project also includes http files in the /http folder which can be used to call the REST endpoints implemented.

