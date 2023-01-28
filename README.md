# csc212-escape-house-final-project

*Title of project:* Escape House Game      
*Contributor(s):* Elena Wang, Jamie Anderson, Margaret Zhang      
*Course:* CSC 212 Programming with Data Structures, Fall 2021      
*Instructors:* Jordan Crouser, Nick Howe      
*Timeline:* December 2021      

### *How to run this project:*      
To run this project, download and run the source code from this repo.

### *Overview:*      
This is the final project that I created with my group members for the CSC 212 Programming with Data Structures class at Smith College. Our goal for this project was to create a text-based choose-your-own-adventure game using data structures.

### *What this project does:*     
This premise of the game is that the player finds themself in an unfamiliar house and needs to navigate their way out. In the process, the player must collect certain items in order to be able to exit the house. The game displays the information in text format, and the player interacts with the game by typing the commands they want to perform. A HashMap stores all of the rooms of the house for navigation, and an ArrayList stores the user's inventory of items. Each room has an associated HashMap containing its neighboring rooms and an associated array containing its takeable items.

### *What we used:*      
The code was written in Java.

### *Files:*   
* Main.java: welcomes the user to the game and calls Adventure.java
* Adventure.java: class to facilitate gameplay
* Book.java: class for the book item in the game
* checklist.md: document to keep track of completed requirements
* instructions.md: contains the instructions for the project as provided by the course instructors, Jordan Crouser and Nick Howe
* NullDirectionException.java: custom exception that is thrown when the user cannot move in the direction that they specify
* Phone.java: class for the phone item in the game
* README.md: contains information about the project
* Room.java: class for the rooms of the house in the game
