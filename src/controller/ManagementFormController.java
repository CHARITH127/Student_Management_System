package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ManagementFormController {
    public AnchorPane loadContext;

    public void Logout(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/MainDashBoard.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) loadContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void Load_Student_Update_OnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/UpdateStudentForm.fxml");
        Parent load = FXMLLoader.load(resource);
        loadContext.getChildren().clear();
        loadContext.getChildren().add(load);
    }

    public void Load_Student_Delete_OnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DeleteStudentForm.fxml");
        Parent load = FXMLLoader.load(resource);
        loadContext.getChildren().clear();
        loadContext.getChildren().add(load);
    }

    public void Load_Course_Update_OnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/UpdateCourseForm.fxml");
        Parent load = FXMLLoader.load(resource);
        loadContext.getChildren().clear();
        loadContext.getChildren().add(load);
    }

    public void Load_Course_Delete_OnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DeleteCourseForm.fxml");
        Parent load = FXMLLoader.load(resource);
        loadContext.getChildren().clear();
        loadContext.getChildren().add(load);
    }

    public void AddCourseOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/addCourseForm.fxml");
        Parent load = FXMLLoader.load(resource);
        loadContext.getChildren().clear();
        loadContext.getChildren().add(load);
    }

    public void GoToStudentSearchByCourse(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/searchStudentSpecificCourseForm.fxml");
        Parent load = FXMLLoader.load(resource);
        loadContext.getChildren().clear();
        loadContext.getChildren().add(load);
    }
}
