package controller;

import bo.CourseBO;
import bo.impl.CourseBOIMPL;
import com.jfoenix.controls.JFXTextField;
import dto.CourseDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;

public class DeleteCourseFormController {
    public ComboBox cmbCourseName;
    public JFXTextField txtCourseId;
    public JFXTextField txtCourseDuration;
    public JFXTextField txtCourseFee;
    String courseName;
CourseBO courseBO = new CourseBOIMPL();

    public void initialize() {
        loadCourseNames();
        cmbCourseName.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
           courseName = String.valueOf(newValue);
        });
    }

    private void loadCourseNames() {
        cmbCourseName.getItems().addAll(courseBO.getAllCourseNames());
    }

    public void Search_Course_OnAction(ActionEvent actionEvent) {
        CourseDTO courseInName = courseBO.getCourseInName(courseName);
        txtCourseId.setText(courseInName.getCourseId());
        txtCourseDuration.setText(courseInName.getDuration());
        txtCourseFee.setText(String.valueOf(courseInName.getFee()));
    }

    public void Delete_Course_OnAction(ActionEvent actionEvent) {
        courseBO.deleteCourse(txtCourseId.getText());
    }
}
