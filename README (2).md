## Name of the App:
Pet Registration App Wireframe

- `App` : App Class is the entry point of the application
  
## The Folder Structure of the App is as follows:
- `JSON` :  to hold PetRecord JSON files
- `src` : the folder to maintain sources
- `lib` : contains the JavaFX library
- `vscode` : contains settings for use in Visual Studio Code Editor, If using another editor, delete this folder

## Src Folder is broken down into the following sections:
- `Logic` : contains Count.java, and CreateJSON.java files to create JSON records, separate of UI logic
- `ModelClasses` : contains PetClass.java to create PetClass objects that holds information about single pets
                 A static PetsList.java file to create a persistent ArrayList of PetClass objects
                 A static TestPets.java file which has an example ArrayList containing 4 PetClass objects for the purposes of testing app functionality
- `Views` : contains files that control the visual design of the App, and implement the JavaFX library
                PetObjectsUI.java allows users to create records for individual pets
                PetRecordUI.java allows users to view the created records, and implements the functionality of CreateJSON to save the records to a JSON file 
                   
## Images information:
- `Dog Image` : Icon image for original pet app build, created by Gareth Warren in 2019, altered to fit as an example
- `Pet Photos` : Pets the author has cared for throughout the years. Names have been changed to protect the innocent.