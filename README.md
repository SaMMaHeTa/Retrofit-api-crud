Introduction
============

This is a User API CRUD with Retrofit Service Provider, an Android Java project which performs Create, Read, Update and Delete (CRUD) operations for User data using Retrofit library for REST API communication.

Retrofit is a type-safe HTTP client for Android and Java that allows to send HTTP requests with parameters and receive responses as objects, making it easy to interact with APIs. This project provides an example of how to use Retrofit to perform CRUD operations on User data, and can be used as a template for other projects.

Features
========

* Create new User
* Retrieve User information
* Update User information
* Delete User information

Prerequisites
=============

To use this project, you must have the following software installed on your system:

* Android Studio
* Retrofit library (already included in the project)
* Internet connection to access the REST API endpoint

Getting started
===============

1.  Clone the project from Github
2.  Open Android Studio and select "Open an existing Android Studio project"
3.  Navigate to the project directory and select the project
4.  Wait for Gradle to sync the project
5.  Run the project on an emulator or physical device

How to use
==========

This project has a simple user interface with four buttons:

1.  Create User: This button will open a dialog to enter the details of a new User. After entering the details, click "Save" to create the User. The new User will be displayed in the list of Users.
    
2.  Retrieve User: This button will open a dialog to enter the ID of the User to retrieve. After entering the ID, click "Retrieve" to get the details of the User. The User details will be displayed in the dialog.
    
3.  Update User: This button will open a dialog to enter the ID of the User to update. After entering the ID, click "Update" to open a dialog to enter the updated details of the User. After entering the updated details, click "Save" to update the User. The updated User details will be displayed in the list of Users.
    
4.  Delete User: This button will open a dialog to enter the ID of the User to delete. After entering the ID, click "Delete" to delete the User. The User will be removed from the list of Users.
    

API endpoint
============

The API endpoint used in this project is a free online service called Reqres ([https://reqres.in](https://reqres.in)). This service provides a mock REST API for testing and prototyping.

License
=======

This project is licensed under the MIT License - see the LICENSE.md file for details.

Acknowledgments
===============

This project was created using the following resources:

* Retrofit library: [https://square.github.io/retrofit/](https://square.github.io/retrofit/)
* Reqres API endpoint: [https://reqres.in](https://reqres.in)
* Icons8 for icons: [https://icons8.com/](https://icons8.com/)
