package dao;

import dto.CustomDTO;
import javafx.collections.ObservableList;

import java.util.List;

public interface QueryDAO {
   ObservableList< CustomDTO> getListofStudentThatFollowingSpecificCourse(String id);
}
