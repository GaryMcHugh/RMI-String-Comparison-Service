Name: Gary McHugh
Student Number: G00308668
Email: g00308668@gmit.ie
GitHub Link: https://github.com/GaryMcHugh/RMI-String-Comparison-Service

An Asynchronous RMI String Comparison Service

Running the Project
========================
1. Import the war file into your IDE (eclipse for me), this will create the project
2. Go to the directory with the string-service.jar file in it and run the command: java –cp ./string-service.jar ie.gmit.sw.Servant
   The Server is now running
3. Run the client to see the output of the data using rmi in the console
   
   You can alternatively just run this in eclipse by first running the server, then running the client

Note:
I did not get the project fully finished, I have an RMI working(like in the labs)
I have also attempted the parts listed below

What I done:
The RMI between client and server receiveing output for the data entered
Created a Linked List and Map for the in and out Queue's
Created an object from the request variables and added them to the linked list
Generated a random job number
I also have code for outputting the result to the user and removing the finished task from the out queue

What I needed to do:
I needed to create code to get a task from the Linked List (inQueue) and process it
put the completed task in the map (the outQueue) so it can be returned to the user
have this loop until all the tasks are complete

I was close to finishing this project, I know what I had to do to finish this, but I didnt know how to code it.

==========================
What the classes I made do
==========================
Cient: gets an instance of string service and uses the compare method to get the difference between the strings using the algorithms

Commpare: determines what algorithm is being used and compares the strings using that algorithm

Compare Runner: an alternative compare method that I would have used if I got towards the end of the project

Create Object: makes an object fromt he request variables so I can add the object to the linked list

Servant: gets a handle on the remote service and tells the user that its ready

Service Handler: contains the declarations of the ina nd out queue, adds the object to the out queue and detects when the task is finished and outputs the result to the user