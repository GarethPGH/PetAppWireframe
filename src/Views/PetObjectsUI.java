
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import javafx.scene.text.*;

/**
 * PetObjectsUI creates a form for inputting the attributes of Pet Objects
 * 
 */
public class PetObjectsUI {
    final int MAX_HEIGHT = 800;
    final int MAX_WIDTH = 1000;
    Image image;
    ImageView imageView;
    Insets insets = new Insets(10);

    // TextFields
    TextField txtName = new TextField();
    TextField txtSpecies = new TextField();
    TextField txtDateLost = new TextField();
    TextField txtGender = new TextField();
    TextField txtNeutered = new TextField();
    TextField txtIsLost = new TextField();
    TextField txtPhotoList = new TextField();
    TextArea txtDescription = new TextArea();
    Scene mainPage;
    Stage mainStage;

    /**
     * createPage Method Creates a Scene that contains the form. This scene is
     * accessed through the button btnAddPets in App.java
     * 
     * @param stage     A reference to PrimaryStage from App
     * @param mainScene A reference to mainScene from App
     * @return Scene
     */
    public Scene createPage(Stage stage, Scene mainScene) {
        mainStage = stage;
        mainPage = mainScene;
        Font font = Font.font("Verdana", FontWeight.BOLD, 16);

        VBox box = createQuestions();

        // Create Buttons
        Button btnAddPet = new Button("Add Pet");
        Button btnExit = new Button("Done Adding Pets");
        btnAddPet.setFont(font);
        btnExit.setFont(font);
        btnAddPet.setTextFill(Color.DARKMAGENTA);
        btnExit.setTextFill(Color.DARKMAGENTA);

        // Sets the info in each Pet object
        btnAddPet.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                setPetInfo();
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

        FlowPane btnPane = new FlowPane();
        btnPane.getChildren().addAll(btnAddPet, btnExit);
        btnPane.setHgap(25.0);
        btnPane.setAlignment(Pos.CENTER);

        BorderPane pane = new BorderPane();
        pane.setCenter(box);
        pane.setBottom(btnPane);
        BorderPane.setMargin(pane.getBottom(), insets);
        Scene scene = new Scene(pane, MAX_WIDTH, MAX_HEIGHT);

        // For the X button
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent windowEvent) {
                System.out.println("Stage is closing");
            }
        });
        return scene;
    }

    /**
     * createQuestions Method Creates the Contents of the Form
     * 
     * @return VBox
     */
    public VBox createQuestions() {
        Font font = Font.font("Ariel", FontWeight.BOLD, 13);
        VBox box = new VBox();
        String photosLabel = "Add a list of the names of photos you want to add separated with spaces"
                + "\nThe names must match the name of a .jpg file in the Images folder minus the extension."
                + "\nOnly add .jpg files to the Images Folder!";

        Label lblName = new Label("What is your Pet's Name");
        Label lblSpecies = new Label("What Species is your Pet?");
        Label lblLost = new Label("Is your Pet Missing?");
        Label lblDate = new Label("What Date did your Pet go missing?");
        Label lblNeuter = new Label("Is your Pet Spayed or Neutered?");
        Label lblGender = new Label("Is your Pet Male or Female?");
        Label lblDescription = new Label("Describe your Pet's most identifiable features");
        Label lblPhotos = new Label(photosLabel);
        lblPhotos.setMinHeight(70);
        lblPhotos.setWrapText(true);

        lblName.setFont(font);
        lblSpecies.setFont(font);
        lblLost.setFont(font);
        lblDate.setFont(font);
        lblNeuter.setFont(font);
        lblGender.setFont(font);
        lblDescription.setFont(font);
        lblPhotos.setFont(font);

        lblName.setTextFill(Color.DARKSLATEBLUE);
        lblSpecies.setTextFill(Color.DARKSLATEBLUE);
        lblLost.setTextFill(Color.DARKSLATEBLUE);
        lblDate.setTextFill(Color.DARKSLATEBLUE);
        lblNeuter.setTextFill(Color.DARKSLATEBLUE);
        lblGender.setTextFill(Color.DARKSLATEBLUE);
        lblDescription.setTextFill(Color.DARKSLATEBLUE);
        lblPhotos.setTextFill(Color.DARKSLATEBLUE);

        box.getChildren().addAll(lblName, txtName, lblSpecies, txtSpecies, lblLost, txtIsLost, lblDate, txtDateLost,
                lblGender, txtGender, lblNeuter, txtNeutered, lblPhotos, txtPhotoList, lblDescription, txtDescription);

        VBox.setMargin(lblName, insets);
        VBox.setMargin(txtName, insets);
        VBox.setMargin(lblSpecies, insets);
        VBox.setMargin(txtSpecies, insets);
        VBox.setMargin(lblLost, insets);
        VBox.setMargin(txtIsLost, insets);
        VBox.setMargin(lblDate, insets);
        VBox.setMargin(txtDateLost, insets);
        VBox.setMargin(lblGender, insets);
        VBox.setMargin(txtGender, insets);
        VBox.setMargin(lblNeuter, insets);
        VBox.setMargin(txtNeutered, insets);
        VBox.setMargin(lblPhotos, insets);
        VBox.setMargin(txtPhotoList, insets);
        VBox.setMargin(lblDescription, insets);
        VBox.setMargin(txtDescription, insets);

        return box;
    }

    /**
     * setPetInfo Method This method sets the properties of a supplied PetClass
     * object, by using values obtained from the various textfields in the form It
     * then adds each object to the static ArrayList PetsList
     * 
     * @param pet
     */
    public void setPetInfo() {
        PetClass pet = new PetClass();

        String name = txtName.getText();
        String species = txtSpecies.getText();
        String neutered = txtNeutered.getText();
        String isLost = txtIsLost.getText();
        String date = txtDateLost.getText();
        String gender = txtGender.getText();
        String description = txtDescription.getText();
        String photos = txtPhotoList.getText();

        pet.setPetName(name);
        pet.setPetSpecies(species);
        pet.setNeuterStatus(neutered);
        pet.setLostStatus(isLost);
        pet.setDateLost(date);
        pet.setGender(gender);
        pet.setPetDescription(description);
        pet.setPhotos(photos);

        // Uncomment if to check the values created Objects
        // System.out.println(pet.getPetName());
        // System.out.println(pet.getSpecies());
        // System.out.println(pet.getPetDescription());
        // System.out.println(pet.getGender());
        // System.out.println(pet.getNeuterStatus());
        // System.out.println(pet.getLostStatus());
        // System.out.println(pet.getDateLost());
        // System.out.println(Arrays.toString(pet.getPhotos()));

        txtName.setText("");
        txtSpecies.setText("");
        txtDateLost.setText("");
        txtDescription.setText("");
        txtGender.setText("");
        txtIsLost.setText("");
        txtNeutered.setText("");
        txtPhotoList.setText("");

        PetsList.add(pet);
    }
}
