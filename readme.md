## Seed code - Boilerplate for step 3 - Activity Stream Assignment

### Problem Statement


### Expected solution

### Following are the broad tasks:

### Project structure

The folders and files you see in this repositories, is how it is expected to be in projects, which are submitted for automated evaluation by Hobbes

    Project
	|
	├── com.stackroute.activitystream.config	           
	|	    └── ApplicationContextConfig.java
	|	    └── WebApplicationInitializer.java
	├── com.stackroute.activitystream.controller
	|		└── CircleController.java 
	|		└── MessageController.java 
	|		└── UserAuthController.java 
	|		└── UserCircleController.java 
	|		└── UserController.java 
	├── com.stackroute.activitystream.dao
	|		└── CircleDAO.java
	|		└── MessageDAO.java
	|		└── UserCircleDAO.java
	|		└── UserDAO.java
	├── com.stackroute.activitystream.daoimpl
	|		└── CircleDAOImpl.java
	|		└── MessageDAOImpl.java
	|		└── UserCircleDAOImpl.java
	|		└── UserDAOImpl.java
	├── com.stackroute.activitystream.model
	|		└── Circle.java
	|		└── Message.java
	|		└── User.java
	|		└── UserCircle.java
	|		└── UserTag.java
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