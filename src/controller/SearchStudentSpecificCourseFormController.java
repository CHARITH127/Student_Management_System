package controller;

import bo.CourseBO;
import bo.QueryBO;
import bo.impl.QueryBOIMPL;
import bo.impl.CourseBOIMPL;
import dto.CustomDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SearchStudentSpecificCourseFormController {

    public TableView tblStudentCourse;
    public TableColumn colStudentName;
    public TableColumn colAddress;
    public TableColumn colTel;
    public ComboBox cmbCourseName;
    String courseName;
    QueryBO queryBO = new QueryBOIMPL();
    CourseBO courseBO = new CourseBOIMPL();

    public void initialize() {
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));

        cmbCourseName.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            courseName = String.valueOf(newValue);
        });

        loadCourseName();
    }

    private void loadCourseName() {
        cmbCourseName.getItems().addAll(courseBO.getAllCourseNames());
    }

    public void searchStudentOnAction(ActionEvent actionEvent) {
        ObservableList<CustomDTO> obsList =  queryBO.getListofStudentThatFollowingSpecificCourse(courseName);
        tblStudentCourse.setItems(obsList);
    }
}
