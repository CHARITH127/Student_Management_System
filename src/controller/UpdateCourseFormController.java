package controller;

import bo.CourseBO;
import bo.impl.CourseBOIMPL;
import com.jfoenix.controls.JFXTextField;
import dao.CourseDAO;
import dto.CourseDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;

public class UpdateCourseFormController {
    public ComboBox cmbCourseName;
    public JFXTextField txtCourseId;
    public JFXTextField txtCourseDuration;
    public JFXTextField txtCourseFee;
    CourseBO courseBO = new CourseBOIMPL();
    String courseName;
    CourseDTO courseInName;

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
        courseInName = courseBO.getCourseInName(courseName);
        txtCourseId.setText(courseInName.getCourseId());
        txtCourseDuration.setText(courseInName.getDuration());
        txtCourseFee.setText(String.valueOf(courseInName.getFee()));
    }

    public void Update_Course_OnAction(ActionEvent actionEvent) {
        courseBO.updatecourse(courseInName);
    }
}
