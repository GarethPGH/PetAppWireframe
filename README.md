# PetAppWireframe
 
This JavaFX app was created as the final assignment for Object Oriented Java 2 (CIT-244) Spring semester 2021. It has three screens.

Main screen opens up and gives the user three options, to Create Pet Records, View Pet Records or Close the application

Create Pet Records features a list of questions in a VBox. Pet records are created using this screen by assigning textfield values to a PetClass Object. This object is then added to a static PetClass ArrayList. 

View Pet Records reads the values stored in the ArrayList. It then creates screens that shows the Pets name, species, whether the pet is missing, what date it was last seen, its gender, whether it is spayed, or neutered, and includes a photo. The photo can be changed if the user supplied more than one name of a file to the textfield for photos. These photos must be in the project's Images folder, and must all be .jpg files. The page features three main buttons. User can change the record to view a different record in the ArrayList, return to the main screen, or create a JSON file containing all of the records in the ArrayList. Created JSON files can be found in the JSON folder.

The Logic folder contains the files needed to create JSON files. The JSON syntax was formatted manually without using an import. A static counter class allows files to be created in sequential order and they are all named PetRecord<counter>.json.
 
 ## Todo
 
 Refactor the application using FXML  
 Add screenshots of the application to Github when VSCode stops pretending my application doesn't work (it was working fine last time I opened it).
 
 Readme2 contains a listing of the file structure of the program
