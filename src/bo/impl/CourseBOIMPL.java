package bo.impl;

import bo.CourseBO;
import configuration.FactoryConfiguration;
import dao.CourseDAO;
import dao.impl.CourseDAOIMPL;
import dto.CourseDTO;
import entity.Course;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class CourseBOIMPL implements CourseBO {
    CourseDAO courseDAO = new CourseDAOIMPL();
    @Override
    public boolean addCourse(CourseDTO dto) {
       return courseDAO.add(new Course(dto.getCourseId(),dto.getCourseName(),dto.getDuration(),dto.getFee()));
    }

    @Override
    public CourseDTO getCourseDetails(String id) {
        Course search = courseDAO.search(id);
        return new CourseDTO(search.getCourseId(),search.getCourseName(),search.getDuration(),search.getFee());
    }

    @Override
    public boolean updatecourse(CourseDTO dto) {
        return courseDAO.update(new Course(dto.getCourseId(),dto.getCourseName(),dto.getDuration(),dto.getFee()));
    }

    @Override
    public boolean deleteCourse(String id) {
        return courseDAO.delete(id);
    }

    @Override
    public CourseDTO getCourseInName(String name) {
        Course courseName = courseDAO.getCoureInCourseName(name);
        return new CourseDTO(courseName.getCourseId(),courseName.getCourseName(),courseName.getDuration(),courseName.getFee());
    }

    @Override
    public ArrayList<String> getAllCourseNames() {
        ArrayList<Course> all = courseDAO.getAll();
        ArrayList<String> courseName = new ArrayList<>();

        for (int i = 0; i < all.size(); i++) {
            courseName.add(i,all.get(i).getCourseName());
        }

        return courseName;
    }
}
