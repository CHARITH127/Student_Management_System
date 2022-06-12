package dao.impl;

import configuration.FactoryConfiguration;
import dao.CourseDAO;
import dao.StudentDAO;
import dao.StudentDetails;
import entity.Course;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;


public class StudentDetailsDAOIMPL implements StudentDetails {
    public entity.StudentDetails details1;
    CourseDAO courseDAO = new CourseDAOIMPL();
    StudentDAO studentDAO = new StudentDAOIMPL();
    @Override
    public boolean add(entity.StudentDetails studentDetails) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(studentDetails);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        entity.StudentDetails studentDetails = session.load(entity.StudentDetails.class, s);
        session.delete(studentDetails);
        transaction.commit();
        session.close();
        return false;
    }

    @Override
    public boolean update(entity.StudentDetails studentDetails) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(studentDetails);
        transaction.commit();
        session.close();
        return false;
    }

    @Override
    public entity.StudentDetails search(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        entity.StudentDetails student = session.get(entity.StudentDetails.class,id);
        transaction.commit();
        session.close();
        return null;
    }

    @Override
    public ArrayList<entity.StudentDetails> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<entity.StudentDetails> dataList = session.createQuery("select a from StudentDetails a", entity.StudentDetails.class).getResultList();
        ArrayList<entity.StudentDetails> studentList = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            studentList.add(i,dataList.get(i));
        }

        transaction.commit();
        session.close();

        if (studentList==null) {
            return null;
        }else {
            return studentList;
        }
    }

    @Override
    public boolean getStudentDetails(String courseID , String studentID) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Course coure = courseDAO.getCoureInCourseName(courseID);
        Student student = studentDAO.search(studentID);
        Query query = session.createQuery("FROM StudentDetails sd WHERE sd.course =:cid AND sd.student=:sid");
        query.setParameter("cid", coure);
        query.setParameter("sid", student);
        List courses = query.list();
        transaction.commit();
        session.close();

        if (courses.isEmpty()) {
            return true;
        }else {
            return false;
        }

    }
}
