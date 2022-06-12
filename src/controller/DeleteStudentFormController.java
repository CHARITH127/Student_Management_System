package controller;

import bo.StudentBO;
import bo.impl.StudentBOIMPL;
import com.jfoenix.controls.JFXTextField;
import dto.StudentDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class DeleteStudentFormController {
    public TextField txtStudentID;
    public JFXTextField txtStudentName;
    public JFXTextField txtStudentAge;
    public JFXTextField txtStudentTel;
    public JFXTextField txtStudentEmail;
    StudentBO studentBO = new StudentBOIMPL();


    public void StudentSearchOnAction(ActionEvent actionEvent) {
        StudentDTO student = studentBO.getStudent(txtStudentID.getText());
        txtStudentName.setText(student.getStudentName());
        txtStudentAge.setText(String.valueOf(student.getStudentAge()));
        txtStudentTel.setText(student.getTel());
        txtStudentEmail.setText(student.getStudentEmail());
    }

    public void StudentDeleteOnAction(ActionEvent actionEvent) {
        studentBO.deleteStudent(txtStudentID.getText());
    }
}
