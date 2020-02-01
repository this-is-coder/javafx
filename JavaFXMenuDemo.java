import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class JavaFXMenuDemo extends Application {
    // A class to demo JavaFX menus, information alerts, and custom dialogs

    private MenuBar menuBar;

    private Menu fileMenu;
    private Menu helpMenu;
    private Menu saveMenu;

    private MenuItem factoryPopUpMI;
    private MenuItem myDialogMI;
    private MenuItem exitMI;
    private MenuItem aboutMI;
    private MenuItem saveMI;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // initialise all the GUI components
        menuBar = new MenuBar();

        fileMenu = new Menu("File");
        helpMenu = new Menu("Help");
        saveMenu = new Menu("Save");

        factoryPopUpMI = new MenuItem("Factory PopUp...");
        myDialogMI = new MenuItem("Custom Dialog Box");
        exitMI = new MenuItem("Exit");
        aboutMI = new MenuItem("About...");
        saveMI = new MenuItem("Save Results");

        // add menu items to menus and menus to the menu bar
        fileMenu.getItems().add(factoryPopUpMI);
        fileMenu.getItems().add(myDialogMI);
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(exitMI);

        helpMenu.getItems().add(aboutMI);

        saveMenu.getItems().add(saveMI);

        menuBar.getMenus().addAll(fileMenu, helpMenu, saveMenu);


        // add listeners to the menu items to make things happen
        exitMI.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        factoryPopUpMI.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Factory Message");
                dialog.setHeaderText("I come in many canned forms.");
                dialog.setContentText("Factory Information");
                dialog.showAndWait();
                //System.out.println();
                //Alert factoryAlert = new Alert(Alert.AlertType.INFORMATION);
                //factoryAlert.setTitle("Factory Message");
                //factoryAlert.setContentText("I come in many canned forms. ");
                //factoryAlert.setHeaderText("Factory Information");
                //factoryAlert.showAndWait();
            }
        });

        myDialogMI.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ExampleDialog dialog = new ExampleDialog();
                dialog.initModality(Modality.APPLICATION_MODAL);
                dialog.initOwner(primaryStage);
                dialog.show();
            }
        });

        saveMI.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert saveAlert = new Alert(Alert.AlertType.INFORMATION);
                saveAlert.setTitle("Save Information");
                saveAlert.setContentText("Results have been saved");
                saveAlert.setHeaderText("Save Results");
                saveAlert.showAndWait();
            }
        });


        // create a VBox, and add the menu bar to it
        VBox vb = new VBox();
        vb.getChildren().add(menuBar);

        // add the VBox to a 'scene'...
        Scene scene = new Scene(vb, 350,150);

        // ... and add the scene to the primary stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Menu Demo");
        primaryStage.show();

    }
}
