package bo;

import dto.CourseDTO;
import entity.Course;

import java.util.ArrayList;

public interface CourseBO {
    boolean addCourse(CourseDTO dto);
    CourseDTO getCourseDetails(String id);
    boolean updatecourse(CourseDTO dto);
    boolean deleteCourse(String id);
    CourseDTO getCourseInName(String name);
    ArrayList<String> getAllCourseNames();
}
