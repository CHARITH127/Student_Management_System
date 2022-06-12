package bo;

import dto.CustomDTO;
import javafx.collections.ObservableList;

import java.util.List;

public interface QueryBO {
    ObservableList<CustomDTO> getListofStudentThatFollowingSpecificCourse(String id);
}
