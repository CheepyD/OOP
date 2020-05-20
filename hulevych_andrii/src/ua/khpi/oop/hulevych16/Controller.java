package ua.khpi.oop.hulevych16;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
    private static final String login = "admin";
    private static final String password = "1337228";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button authSignInButton;

    @FXML
    void initialize() {
        authSignInButton.setOnAction(actionEvent -> {
            if (loginField.getText().equals(login) && passwordField.getText().equals(password)) {
                authSignInButton.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/app.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.showAndWait();

            } else {
                Warning.showAlertWithHeaderText("Э");
                System.out.println("Incorrect user or password");
            }
        });

    }

    public static void main(String[] args) {
        Main.app(args);
    }
}