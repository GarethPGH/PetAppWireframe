
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.text.*;

import java.util.ArrayList;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * PetRecordUI Class creates a scene that shows the individual views of each
 * PetRecord. If no pets have been added using btnAddPets Add Pet Records button
 * to activate PetObjectsUI a sample record is shown. Otherwise whatever pet
 * records have been added to the PetsList static pets array are shown
 * 
 * @return Scene
 */
public class PetRecordUI {

    final int MAX_HEIGHT = 1000;
    final int MAX_WIDTH = 1400;
    Image image;
    ImageView imageView;
    Alert alert = new Alert(AlertType.WARNING);
    // References to App.java
    Scene mainPage;
    Stage mainStage;
    // Labels for information
    Label lblPetGend = new Label();
    Label lblPetName = new Label();
    Label lblPetNeuter = new Label();
    Label lblLost = new Label();
    Label lblDate = new Label();
    Label lblPetDate = new Label();
    Label lblPetSpecies = new Label();
    TextArea txtDesc = new TextArea();
    // Counter indicies for individual PetClass pet.photos array and PetsList array
    int picIndex = 0;
    int recordIndex = 0;

    // DO NOT USE btnAddPets Create Pet Records, if using test data
    // Uncomment out bottom line to see test data
    // PetClass[] testPets = TestPets.getPetArray();
    // Comment out bottom line to see test data
    ArrayList<PetClass> petList = PetsList.getPetList();
    PetClass displayPet;

    /**
     * setData Method sets the Labels, text area and photos to the values stored in
     * PetClass objects
     * 
     * @param pet
     */
    public void setData(PetClass pet) {
        FileInputStream input;

        if (pet == null) {
            pet = new PetClass();
        }
        String[] photos = pet.getPhotos();
        lblPetGend.setText(pet.getGender());
        lblPetName.setText(pet.getPetName());
        lblPetSpecies.setText(pet.getSpecies());

        boolean check = pet.getNeuterStatus();
        if (check == true) {
            lblPetNeuter.setText("Yes");
        } else if (check == false) {
            lblPetNeuter.setText("No");
        }

        check = pet.getLostStatus();
        if (check == true) {
            lblLost.setVisible(true);
            lblDate.setVisible(true);
            lblPetDate.setVisible(true);
            lblPetDate.setText(pet.getDateLost());
        } else if (check == false) {
            lblLost.setVisible(false);
            lblDate.setVisible(false);
            lblPetDate.setVisible(false);
        }

        try {
            input = new FileInputStream(photos[0]);
            Image img = new Image(input);
            imageView.setImage(img);
            input.close();
        } catch (Exception exception) {
            imageView = new ImageView();
        }
        txtDesc.setText(pet.getPetDescription());
    }

    /**
     * createPage Method creates the Pet Records view and returns a Scene
     * 
     * @param stage
     * @param mainScene
     * @return Scene
     */
    public Scene createPage(Stage stage, Scene mainScene) {
        mainStage = stage;
        mainPage = mainScene;
        Font font = Font.font("Verdana", FontWeight.BOLD, 16);
        petList.trimToSize();

        // Comment out bottom line to see test data
        if (petList.size() > 0) {
            // Comment out bottom line to see test data
            displayPet = (PetClass) PetsList.get(0);
            // Uncomment out bottom line to see test data
            // displayPet = testPets[0];
        } else {
            displayPet = new PetClass();
        }
        // Buttons
        Button btnChangeRecord = new Button("See Next Record");
        Button btnChangeImage = new Button("Change Image");
        Button btnExit = new Button("Done Viewing Records");
        Button btnCreateJson = new Button("Create JSON file");
        btnChangeRecord.setFont(font);
        btnChangeImage.setFont(font);
        btnExit.setFont(font);
        btnCreateJson.setFont(font);
        btnChangeRecord.setTextFill(Color.DARKMAGENTA);
        btnChangeImage.setTextFill(Color.DARKRED);
        btnExit.setTextFill(Color.DARKCYAN);
        btnCreateJson.setTextFill(Color.DARKBLUE);

        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);
        flowPane.setHgap(25.0);
        flowPane.setVgap(7.0);
        flowPane.getChildren().addAll(btnChangeRecord, btnChangeImage, btnExit, btnCreateJson);

        // Button Event Handlers
        // This button changes Pet records to next in the Arraylist. If index reaches an
        // index that is out of bounds, it is reset
        btnChangeRecord.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                PetClass pet;
                try {
                    if (petList.size() > 0) {

                        if (recordIndex < petList.size() - 1) {
                            recordIndex++;
                        } else {
                            recordIndex = 0;
                        }
                        pet = (PetClass) petList.get(recordIndex);
                        setData(pet);
                    }
                } catch (Exception exception) {
                    alert.setContentText("No Pet Records to Show");
                    alert.show();
                }
            }
        });
        // This button sets the image to the next image in the PetClass pet.photos
        // array. If index reaches an index that is out of bounds, it is reset
        btnChangeImage.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                PetClass pet;
                FileInputStream input;
                try {
                    if (petList.size() > 0) {
                        petList.trimToSize();
                        pet = petList.get(recordIndex);
                        if (pet.photos.length > 0) {
                            String[] photos = pet.getPhotos();

                            if (picIndex < photos.length - 1) {
                                picIndex++;
                            } else {
                                picIndex = 0;
                            }
                            try {
                                input = new FileInputStream(photos[picIndex]);
                                Image img = new Image(input);
                                imageView.setImage(img);
                                input.close();
                            } catch (Exception exception) {
                                imageView = new ImageView();
                            }
                        }
                    }
                } catch (Exception exception) {
                    alert.setContentText("No Photos to Show");
                    alert.show();
                }
            }
        });
        // Returns to App.java
        btnExit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                System.out.println("Returning to Main Screen");
                mainStage.setScene(mainPage);
            }
        });
        // Calls writeFile to create JSON. Created JSON files can be found in JSON
        // folder
        btnCreateJson.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (petList.size() > 0) {
                    petList.trimToSize();
                    CreateJSON.writeFile(petList);
                } else {
                    alert.setContentText("No Items to Write to JSON file");
                    alert.show();
                }
            }
        });

        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(15, 15, 15, 15));
        BorderPane picture = createPictureFrame(displayPet);
        BorderPane info = createInfoList();
        pane.setLeft(info);
        pane.setRight(picture);
        pane.setTop(flowPane);

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent windowEvent) {
                System.out.println("Stage is Exiting");
            }
        });
        // Sets data of initial display pet
        setData(displayPet);

        Scene scene = new Scene(pane, MAX_WIDTH, MAX_HEIGHT);
        return scene;
    }

    /**
     * Creates the view of the picture frame and description box given a pet record
     * 
     * @param pet
     * @return
     */
    public BorderPane createPictureFrame(PetClass pet) {
        Insets insets = new Insets(10);
        BorderPane pane = new BorderPane();
        BorderPane.setMargin(pane, insets);
        String[] photos = pet.getPhotos();
        String imageName;
        Image image;
        Font font = Font.font("Ariel", 20);

        FileInputStream input;

        if (photos.length > 0) {
            imageName = photos[0];
        } else {
            imageName = "Images/default.jpg";
        }

        try {
            input = new FileInputStream(imageName);
            image = new Image(input);
            imageView = new ImageView();
            imageView.setImage(image);
        } catch (FileNotFoundException exception) {
            imageView = new ImageView();
        }
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(600.0);
        imageView.setFitWidth(750.0);

        txtDesc.setText(pet.getPetDescription());
        txtDesc.setEditable(false);
        txtDesc.setFont(font);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        pane.setTop(grid);
        pane.setCenter(imageView);
        pane.setBottom(txtDesc);
        return pane;
    }

    /**
     * Creates an info list, and adds all labels and textfields to it Pet
     * information is added to the labels by using setData in createPage.
     * 
     * @return
     */
    public BorderPane createInfoList() {
        BorderPane pane = new BorderPane();
        Insets insets = new Insets(100, 15, 15, 15);
        GridPane gridPane = new GridPane();
        BorderPane.setMargin(pane, insets);
        Font font = Font.font("Ariel", FontWeight.BOLD, 20);

        gridPane.setHgap(10);
        gridPane.setVgap(20);

        Label lblName = new Label("Pet Name:");
        Label lblNeuter = new Label("Is Pet Spayed/Neutered?");
        Label lblGender = new Label("Sex:");
        Label lblSpecies = new Label("Species:");

        lblLost.setText("Pet Is Missing!");
        lblDate.setText("Date Lost:");

        GridPane.setColumnSpan(lblLost, 2);

        lblName.setFont(font);
        lblDate.setFont(font);
        lblGender.setFont(font);
        lblNeuter.setFont(font);
        lblSpecies.setFont(font);

        font = Font.font("Ariel", FontWeight.BOLD, 28);
        lblLost.setFont(font);
        lblLost.setTextFill(Color.RED);

        font = Font.font("Ariel", 20);
        lblPetName.setFont(font);
        lblPetDate.setFont(font);
        lblPetGend.setFont(font);
        lblPetNeuter.setFont(font);
        lblPetSpecies.setFont(font);

        gridPane.add(lblName, 0, 0);
        gridPane.add(lblPetName, 1, 0);
        gridPane.add(lblSpecies, 0, 1);
        gridPane.add(lblPetSpecies, 1, 1);
        gridPane.add(lblGender, 0, 2);
        gridPane.add(lblPetGend, 1, 2);
        gridPane.add(lblNeuter, 0, 3);
        gridPane.add(lblPetNeuter, 1, 3);
        gridPane.add(lblLost, 0, 4);
        gridPane.add(lblDate, 0, 5);
        gridPane.add(lblPetDate, 1, 5);

        pane.setCenter(gridPane);

        GridPane.setMargin(pane, insets);

        return pane;
    }

}
