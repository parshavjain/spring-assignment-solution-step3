## Seed code - Boilerplate for step 3 - Activity Stream Assignment

### Assignment Step Description

In this Case study: Activity Stream Step 3, we will create a RESTful application. 

Representational State Transfer (REST) is an architectural style that specifies constraints. 
In the REST architectural style, data and functionality are considered resources and are accessed using Uniform Resource Identifiers (URIs), typically links on the Web.

Resources are manipulated using a fixed set of four create, read, update, delete operations: PUT, GET, POST, and DELETE. 
 - PUT creates a new resource, which can be then deleted by using DELETE. 
 - GET retrieves the current state of a resource in some representation. 
 - POST transfers a new state onto a resource. 

### Problem Statement

In this case study, we will develop a RESTful application with which we will register a user, create a circle and delete a circle, add users to the circle, 
and send messages to various circle created. Also, we will perform authentication like login and log out. All these operations will be tested with the help of Postman API.

### Solution Step

        Step 1: Configure Postman in your Google Chrome
        Step 2: Use URI's mentioned in the controller to check all the expected operations using Postman.

### Following are the broad tasks:

### Project structure

The folders and files you see in this repositories, is how it is expected to be in projects, which are submitted for automated evaluation by Hobbes

    Project
	|
	├── com.stackroute.activitystream.config	           
	|	    └── ApplicationContextConfig.java     // This class will contain the application-context for the application.
	|	    └── WebApplicationInitializer.java    // This class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer class.
	├── com.stackroute.activitystream.controller
	|		└── CircleController.java           // This class is responsible for processing all requests related to Circle and builds an appropriate model and passes it to the view for rendering.
	|		└── MessageController.java          // This class is responsible for processing all requests related to Message and builds an appropriate model and passes it to the view for rendering.
	|		└── UserAuthController.java         // This class is responsible for processing all requests related to UserAuthController and builds an appropriate model and passes it to the view for rendering.
	|		└── UserCircleController.java       // This class is responsible for processing all requests related to UserCircleController and builds an appropriate model and passes it to the view for rendering.
	|		└── UserController.java             // This class is responsible for processing all requests related to UserController and builds an appropriate model and passes it to the view for rendering.
	├── com.stackroute.activitystream.dao
	|		└── CircleDAO.java                  // This interface contains all the behaviours of Circle Model
	|		└── MessageDAO.java                 // This interface contains all the behaviours of Message Model    
	|		└── UserCircleDAO.java              // This interface contains all the behaviours of UserCircle Model
	|		└── UserDAO.java                    // This interface contains all the behaviours of User Model
	├── com.stackroute.activitystream.daoimpl
	|		└── CircleDAOImpl.java              // This class implements the CircleDAO interface. This class has to be annotated with @Repository annotation.
	|		└── MessageDAOImpl.java             // This class implements the MessageDAO interface. This class has to be annotated with @Repository annotation.
	|		└── UserCircleDAOImpl.java          // This class implements the UserCircleDAO interface. This class has to be annotated with @Repository annotation.
	|		└── UserDAOImpl.java                // This class implements the UserDAO interface. This class has to be annotated with @Repository annotation.
	├── com.stackroute.activitystream.model
	|		└── Circle.java                     // This class will be acting as the data model for the circle Table in the database.
	|		└── Message.java                    // This class will be acting as the data model for the message Table in the database.
	|		└── User.java                       // This class will be acting as the data model for the user Table in the database.
	|		└── UserCircle.java                 // This class will be acting as the data model for the user_circle Table in the database.
	|		└── UserTag.java                    // This class will be acting as the data model for the user_tag Table in the database.
	├── com.stackroute.activitystream.test      // All the test case classes are made available in this package
	|		└── CircleTest.java
	|		└── MessageTest.java  
	|		└── UserAuthTest.java 
	|		└── UserCircleTest.java
	|		└── UserTest.java      
	├── .classpath			                    // This file is generated automatically while creating the project in eclipse
	├── .hobbes   			                    // Hobbes specific config options, such as type of evaluation schema, type of tech stack etc., Have saved a default values for convenience
	├── .project			                    // This is automatically generated by eclipse, if this file is removed your eclipse will not recognize this as your eclipse project. 
	├── pom.xml 			                    // This is a default file generated by maven, if this file is removed your project will not get recognised in hobbes.
	└── PROBLEM.md  		                    // This files describes the problem of the assignment/project, you can provide as much as information and clarification you want about the project in this file

> PS: All lint rule files are by default copied during the evaluation process, however if need to be customizing, you should copy from this repo and modify in your project repo


#### To use this as a boilerplate for your new project, you can follow these steps

1. Clone the base boilerplate in the folder **assignment-solution-step3** of your local machine
     
    `git clone https://gitlab-dev.stackroute.in/activity-stream-java/step3-boilerplate.git assignment-solution-step3`

2. Navigate to assignment-solution-step3 folder

    `cd assignment-solution-step3`

3. Remove its remote or original reference

     `git remote rm origin`

4. Create a new repo in gitlab named `assignment-solution-step3` as private repo

5. Add your new repository reference as remote

     `git remote add origin https://gitlab.training.com/{{yourusername}}/assignment-solution-step3.git`

     **Note: {{yourusername}} should be replaced by your username from gitlab**

5. Check the status of your repo 
     
     `git status`

6. Use the following command to update the index using the current content found in the working tree, to prepare the content staged for the next commit.

     `git add .`
 
7. Commit and Push the project to git

     `git commit -a -m "Initial commit | or place your comments according to your need"`

     `git push -u origin master`

8. Check on the git repo online, if the files have been pushed

### Important instructions for Participants
> - We expect you to write the assignment on your own by following through the guidelines, learning plan, and the practice exercises
> - The code must not be plagirized, the mentors will randomly pick the submissions and may ask you to explain the solution
> - The code must be properly indented, code structure maintained as per the boilerplate and properly commented
> - Follow through the problem statement shared with you

### Further Instructions on Release

*** Release 0.1.0 ***

- Right click on the Assignment select Run As -> Java Application to run your Assignment.
- Right click on the Assignment select Run As -> JUnit Test to run your Assignment.