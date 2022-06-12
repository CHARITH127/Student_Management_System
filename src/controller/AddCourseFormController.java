package controller;

import bo.CourseBO;
import bo.impl.CourseBOIMPL;
import com.jfoenix.controls.JFXTextField;
import dto.CourseDTO;
import javafx.event.ActionEvent;

public class AddCourseFormController {
    public JFXTextField txtCourseID;
    public JFXTextField txtCourseName;
    public JFXTextField txtCourseFee;
    public JFXTextField txtCourseDuration;
CourseBO courseBO = new CourseBOIMPL();
    public void addCourseOnAction(ActionEvent actionEvent) {
        CourseDTO courseDTO = new CourseDTO(txtCourseID.getText(),txtCourseName.getText(),txtCourseDuration.getText(),Double.parseDouble(txtCourseFee.getText()));
        courseBO.addCourse(courseDTO);
    }
}
