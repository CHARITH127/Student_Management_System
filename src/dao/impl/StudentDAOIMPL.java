package dao.impl;

import configuration.FactoryConfiguration;
import dao.StudentDAO;
import entity.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOIMPL implements StudentDAO {
    @Override
    public boolean add(entity.Student student) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        entity.Student student = session.get(entity.Student.class, s);
        session.delete(student);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(entity.Student student) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(student);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public entity.Student search(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        entity.Student student = session.get(entity.Student.class, id);
        transaction.commit();
        session.close();
        return student;
    }

    @Override
    public ArrayList<entity.Student> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Student> dataList = session.createQuery("select a from Student a", Student.class).getResultList();
        ArrayList<Student> studentList = new ArrayList<>();
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
}
