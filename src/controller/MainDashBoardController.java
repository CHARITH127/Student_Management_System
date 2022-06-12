package controller;

import bo.*;
import bo.impl.CourseBOIMPL;
import bo.impl.StudentBOIMPL;
import bo.impl.StudentDetailBOIMPL;
import bo.impl.StudentRegistrationBOIMPL;
import com.jfoenix.controls.JFXTextField;
import dto.CourseDTO;
import dto.StudentDTO;
import dto.StudentDetailsDTO;
import entity.Course;
import entity.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainDashBoardController {
    public ComboBox cmbCourseName;
    public JFXTextField txtCousreId;
    public JFXTextField txtCousreFee;
    public TextField txtStudentID;
    public TextField txtStudentName;
    public TextField txtStudentAge;
    public TextField txtStudentTel;
    public TextField txtStudentAddress;
    public TextField txtStudentEmail;
    public JFXTextField txtCousreDuration;
    public Label lblDate;
    public ImageView mainDashboardContext;
    String courseName;
    Date date;

    StudentBO studentBO = new StudentBOIMPL();
    StudentDetailsBO detailsBO = new StudentDetailBOIMPL();
    StudentRegistrationBO registrationBO = new StudentRegistrationBOIMPL();
    CourseBO courseBO = new CourseBOIMPL();

    public void initialize() {
        setCourseName();
        loadDate();
        /*Combo box lisners========================================================*/
        cmbCourseName.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            courseName = String.valueOf(newValue);
        });
    }

    private void setCourseName() {
        List<String> allCourseNames = courseBO.getAllCourseNames();
        cmbCourseName.getItems().addAll(allCourseNames);
    }

    private void loadDate() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(f.format(date));
    }

    public void Cousre_Search_OnAction(ActionEvent actionEvent) {
        CourseDTO courseDTO = courseBO.getCourseInName(courseName);
        txtCousreId.setText(courseDTO.getCourseId());
        txtCousreDuration.setText(courseDTO.getDuration());
        txtCousreFee.setText(String.valueOf(courseDTO.getFee()));
    }

    public void Sudent_Search_OnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/StudentSearchForm.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void Student_Register_OnAction(ActionEvent actionEvent) throws ParseException {
            Student student = new Student(txtStudentID.getText(), txtStudentName.getText(), Integer.parseInt(txtStudentAge.getText()), txtStudentTel.getText(), txtStudentAddress.getText(), txtStudentEmail.getText());
            StudentDTO studentDTO = new StudentDTO(txtStudentID.getText(), txtStudentName.getText(), Integer.parseInt(txtStudentAge.getText()), txtStudentTel.getText(), txtStudentAddress.getText(), txtStudentEmail.getText());
            Course course = new Course(txtCousreId.getText(),courseName,txtCousreDuration.getText(),Double.parseDouble(txtCousreFee.getText()));
            String attendDate = lblDate.getText();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            date = df.parse(attendDate);
            StudentDetailsDTO detailsDTO = new StudentDetailsDTO(date,student,course);
            registrationBO.registerStudent(studentDTO, detailsDTO);

    }

    public void Managemnt_Context(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ManagementForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) mainDashboardContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
