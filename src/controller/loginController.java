package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class loginController {
    public TextField txtUseerName;
    public PasswordField txtPassword;
    public AnchorPane loginContext;


    public void LoginToDashBoard(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/MainDashBoard.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) loginContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
