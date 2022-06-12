package bo.impl;

import bo.QueryBO;
import dao.QueryDAO;
import dao.impl.QueryDAOIMPL;
import dto.CustomDTO;
import javafx.collections.ObservableList;

import java.util.List;

public class QueryBOIMPL implements QueryBO {

    QueryDAO queryDAO = new QueryDAOIMPL();
    @Override
    public ObservableList<CustomDTO> getListofStudentThatFollowingSpecificCourse(String id) {
        return queryDAO.getListofStudentThatFollowingSpecificCourse(id);
    }
}
