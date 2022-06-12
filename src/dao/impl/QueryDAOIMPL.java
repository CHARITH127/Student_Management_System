package dao.impl;

import configuration.FactoryConfiguration;
import dao.CourseDAO;
import dao.QueryDAO;
import dto.CustomDTO;
import entity.Course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class QueryDAOIMPL implements QueryDAO {
    CourseDAO courseDAO = new CourseDAOIMPL();
    @Override
    public ObservableList<CustomDTO> getListofStudentThatFollowingSpecificCourse(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Course search = courseDAO.getCoureInCourseName(id);
        Query query = session.createQuery("SELECT Distinct s.studentName, s.address, s.tel FROM Student s INNER JOIN StudentDetails d ON s.studentId = d.student where d.course=:id");
        query.setParameter("id",search);
        List<Object[]> list = query.list();
        ObservableList<CustomDTO> details = FXCollections.observableArrayList();
        for (Object[] objects : list) {
            details.add(new CustomDTO(objects[0].toString(),objects[1].toString(),objects[2].toString()));
        }
        transaction.commit();
        session.close();
        return details;
    }
}
