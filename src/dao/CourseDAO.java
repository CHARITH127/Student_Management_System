package dao;

import entity.Course;

public interface CourseDAO extends CrudDAO<Course,String> {
    Course getCoureInCourseName(String name);
}
