# Simple Task Tracker Web Application

## This project centered around building a simple task tracker Full-Stack Application. This is a basic CRUD application equipped with a front end design which allows a user to perform the following tasks:

1. Create new tasks
2. Display existing tasks
3. Update existing tasks
4. Delete existing tasks

### All the above tasks are exposed by a REST API from a SpringBoot running backend application. A client application running in Angular consumes the REST API and provides a neat UI to the end user to perform the tasks.


### An in-memory database (H2) is used in the application. The user is allowed to login as well as logout. For security and access control, JSON Web Token (JWT) is used. A REST endpoint which accepts the username is exposed and the client app makes an HTTP request to this endpoint to authenticate the user.



### Technologies Used: 
#### Backend Components: SpringBoot, Maven, Tomcat, H2 Database
#### Frontend Components: Angular, Typescript, HTML5, CSS3, Bootstrap.

### A few snippets of the application: 

#### Home Page
![Home_Page](https://github.com/animeshpaul91/Spring-and-Hibernate-Masterclass/blob/main/Full_Stack_with_SpringBoot_and_Angular/Applicationv2.0/snaps/login.png?raw=true)

#### Login Page
![Login_Page](https://github.com/animeshpaul91/Spring-and-Hibernate-Masterclass/blob/main/Full_Stack_with_SpringBoot_and_Angular/Applicationv2.0/snaps/login.png?raw=true)

#### Add new Task
![Create_task](https://github.com/animeshpaul91/Spring-and-Hibernate-Masterclass/blob/main/Full_Stack_with_SpringBoot_and_Angular/Applicationv2.0/snaps/todos.png?raw=true)