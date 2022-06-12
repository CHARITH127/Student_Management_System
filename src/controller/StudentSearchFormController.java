package controller;

import bo.CourseBO;
import bo.StudentBO;
import bo.StudentDetailsBO;
import bo.StudentRegistrationBO;
import bo.impl.CourseBOIMPL;
import bo.impl.StudentBOIMPL;
import bo.impl.StudentDetailBOIMPL;
import bo.impl.StudentRegistrationBOIMPL;
import com.jfoenix.controls.JFXTextField;
import dao.StudentDAO;
import dao.StudentDetails;
import dao.impl.StudentDetailsDAOIMPL;
import dto.CourseDTO;
import dto.StudentDTO;
import dto.StudentDetailsDTO;
import entity.Course;
import entity.Student;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StudentSearchFormController {
    public TextField txtStudentID;
    public JFXTextField txtStudentName;
    public JFXTextField txtStudentAge;
    public JFXTextField txtStudentTel;
    public JFXTextField txtStudentAddress;
    public JFXTextField txtStudentEmail;
    public ComboBox cmbCourseNameOnAction;
    public JFXTextField txtCourseID;
    public JFXTextField txtCourseFee;
    public Label lblDate;
    public JFXTextField txtCourseDuration;
    StudentBO studentBO = new StudentBOIMPL();
    CourseBO courseBO = new CourseBOIMPL();
    StudentDetailsBO detailsBO = new StudentDetailBOIMPL();
    StudentRegistrationBO registrationBO = new StudentRegistrationBOIMPL();
    Date date;

    String courseName;

    public void initialize() {
        loadCourseNames();
        loadDate();
        /*combo boox listner=========================================================================*/
        cmbCourseNameOnAction.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            courseName = String.valueOf(newValue);
        });
    }

    private void loadCourseNames() {
        List<String> allCourseNames = courseBO.getAllCourseNames();
        cmbCourseNameOnAction.getItems().addAll(allCourseNames);
    }

    private void loadDate() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(f.format(date));
    }

    public void Search_Student_OnAction(ActionEvent actionEvent) {
        StudentDTO student = studentBO.getStudent(txtStudentID.getText());
        txtStudentName.setText(student.getStudentName());
        txtStudentAge.setText(String.valueOf(student.getStudentAge()));
        txtStudentTel.setText(student.getTel());
        txtStudentAddress.setText(student.getAddress());
        txtStudentEmail.setText(student.getStudentEmail());
    }

    public void Course_Search_OnAction(ActionEvent actionEvent) {
        CourseDTO course = courseBO.getCourseInName(courseName);
        txtCourseID.setText(course.getCourseId());
        txtCourseFee.setText(String.valueOf(course.getFee()));
        txtCourseDuration.setText(course.getDuration());
    }

    public void Register_On_Action(ActionEvent actionEvent) throws ParseException {

        if (detailsBO.getStudentDetails(courseName,txtStudentID.getText())) {
            Student student = new Student(txtStudentID.getText(), txtStudentName.getText(), Integer.parseInt(txtStudentAge.getText()), txtStudentTel.getText(), txtStudentAddress.getText(), txtStudentEmail.getText());
            StudentDTO studentDTO = new StudentDTO(txtStudentID.getText(), txtStudentName.getText(), Integer.parseInt(txtStudentAge.getText()), txtStudentTel.getText(), txtStudentAddress.getText(), txtStudentEmail.getText());
            Course course = new Course(txtCourseID.getText(), courseName, txtCourseDuration.getText(), Double.parseDouble(txtCourseFee.getText()));
            String attendDate = lblDate.getText();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            date = df.parse(attendDate);
            StudentDetailsDTO detailsDTO = new StudentDetailsDTO(date, student, course);
            registrationBO.addStudentDetails(detailsDTO);
        }else {
            new Alert(Alert.AlertType.ERROR,"This Student is allready registed into this course").showAndWait();
        }


    }
}
