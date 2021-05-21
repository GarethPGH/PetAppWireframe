import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.BlurType;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.text.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Name: PetRegistrationAppWireframe *Date: 5/15/2021 *Author: Gareth Warren
 * 
 * This app allows the user to create pet records to view pet records and to
 * save pet records to a properly formatted JSON file
 * 
 * More on the structure of the App in Readme.md
 */
public class App extends Application {
    // Sizing
    final int MAX_HEIGHT = 300;
    final int MAX_WIDTH = 1000;
    // Initiate UI objects
    PetClass pet = new PetClass();
    PetRecordUI seePetRecordUI = new PetRecordUI();
    PetObjectsUI createPetObjectUI = new PetObjectsUI();
    Scene mainScene;
    Font font = Font.font("Verdana", FontWeight.BOLD, 20);

    /**
     * createShadow creates a DropShadow effect intended to enhance buttons
     * 
     * @return DropShadow
     */
    public DropShadow createShadow() {
        DropShadow drop = new DropShadow();
        drop.setBlurType(BlurType.GAUSSIAN);
        drop.setColor(Color.DARKGRAY);
        drop.setHeight(100);
        drop.setWidth(150);
        drop.setOffsetX(10);
        drop.setOffsetY(10);
        drop.setSpread(0.2);
        drop.setRadius(10);
        return drop;
    }

    /**
     * setButtonStyle styles the three buttons, by altering the Modena UI defaults
     * so that the buttons will feel more interactive Created because changing the
     * button background color overwrote the styles and disabled default behaviour.
     * 
     * @param btn1
     * @param btn2
     * @param btn3
     */
    public void setButtonStyle(Button btn1, Button btn2, Button btn3) {
        String styleOnMouseOver = "-fx-shadow-highlight-color: #ff0000;" + "-fx-body-color:  #f2b773;"
                + "-fx-background-insets: 0 0 -1 0, 0, 1, 2;" + "-fx-background-radius: 3px, 3px, 2px, 1px;"
                + "-fx-padding: 0.333333em 0.666667em 0.333333em 0.666667em;" + "-fx-text-fill: -fx-text-base-color;"
                + "-fx-alignment: CENTER;" + "-fx-content-display: LEFT;";

        String styleDefault = "-fx-background-color: #f2b773;";

        btn1.setStyle(styleDefault);
        btn2.setStyle(styleDefault);
        btn3.setStyle(styleDefault);
        btn1.setOnMouseEntered(e -> {
            btn1.setStyle(styleOnMouseOver);
        });
        btn1.setOnMouseExited(e -> {
            btn1.setStyle(styleDefault);
        });

        btn2.setOnMouseEntered(e -> {
            btn2.setStyle(styleOnMouseOver);
        });
        btn2.setOnMouseExited(e -> {
            btn2.setStyle(styleDefault);
        });
        btn3.setOnMouseEntered(e -> {
            btn3.setStyle(styleOnMouseOver);
        });
        btn3.setOnMouseExited(e -> {
            btn3.setStyle(styleDefault);
        });
    }

    /** Start point of Application. Stiches the app together */
    @Override
    public void start(Stage PrimaryStage) throws Exception {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(15, 15, 15, 15));
        pane.setVgap(15.0);
        pane.setHgap(15.0);
        DropShadow dropShadow = createShadow();

        // Build Buttons
        Button btnClose = new Button("Close Program");
        Button btnSeePets = new Button("View Pet Records");
        Button btnAddPets = new Button("Create Pet Records");
        btnClose.setFont(font);
        btnSeePets.setFont(font);
        btnAddPets.setFont(font);
        btnClose.setEffect(dropShadow);
        btnAddPets.setEffect(dropShadow);
        btnSeePets.setEffect(dropShadow);

        setButtonStyle(btnClose, btnSeePets, btnAddPets);

        pane.add(btnAddPets, 1, 1);
        pane.add(btnSeePets, 2, 1);
        pane.add(btnClose, 3, 1);

        mainScene = new Scene(pane, MAX_WIDTH, MAX_HEIGHT);

        btnClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("Stage is closing");
                System.exit(0);
            }
        });
        btnSeePets.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                Scene scene = seePetRecordUI.createPage(PrimaryStage, mainScene);
                PrimaryStage.setScene(scene);
            }
        });
        btnAddPets.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                Scene scene = createPetObjectUI.createPage(PrimaryStage, mainScene);
                PrimaryStage.setScene(scene);
            }
        });

        // Build stage
        PrimaryStage.setTitle("Create and View Pet Records");
        PrimaryStage.setScene(mainScene);
        PrimaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent windowEvent) {
                System.out.println("Stage is closing");
            }
        });
        PrimaryStage.show();
    }

    /**
     * Main execution point
     * 
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
