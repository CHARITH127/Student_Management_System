package dto;

import entity.Course;
import entity.Student;

import java.util.Date;

public class StudentDetailsDTO {
    private Date date;
    private Student student;
    private Course course;

    public StudentDetailsDTO() {
    }

    public StudentDetailsDTO( Date date, Student student, Course course) {
        this.date = date;
        this.student = student;
        this.course = course;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
