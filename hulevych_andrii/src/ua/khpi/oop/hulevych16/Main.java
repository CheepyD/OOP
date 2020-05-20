package ua.khpi.oop.hulevych16;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Main.class.getResource("/login.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root,638,362));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void app(String[] args) {
        launch(args);
    }
}