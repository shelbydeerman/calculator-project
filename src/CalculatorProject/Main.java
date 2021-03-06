package CalculatorProject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

/**
 * Main class for Calculator Project
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Creates the calculator window specified by the calculator.fxml file
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("calculator.fxml")));
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
