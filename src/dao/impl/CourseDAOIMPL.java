package dao.impl;

import configuration.FactoryConfiguration;
import dao.CourseDAO;
import entity.Course;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CourseDAOIMPL implements CourseDAO {
    @Override
    public boolean add(Course course) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(course);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Course course = session.load(Course.class, s);
        session.delete(course);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Course course) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(course);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Course search(String s) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Course course = session.get(Course.class, s);
        transaction.commit();
        session.close();
        return course;
    }

    @Override
    public ArrayList<Course> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Course> dataList = session.createQuery("select a from Course a", Course.class).getResultList();
        ArrayList<Course> courseList = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            courseList.add(i, dataList.get(i));
        }

        transaction.commit();
        session.close();
        if (courseList == null) {
            return null;
        } else {
            return courseList;
        }
    }

    @Override
    public Course getCoureInCourseName(String name) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("FROM Course C WHERE C.courseName =:names");
        query.setParameter("names", name);
        List<Course> courses = query.list();
        transaction.commit();
        session.close();
        for (Course cours : courses) {
            return new Course(cours.getCourseId(), cours.getCourseName(), cours.getDuration(), cours.getFee());
        }
        return null;
    }
}
