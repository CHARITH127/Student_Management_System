package entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Course {
    @Id
    private String courseId;
    private String courseName;
    private String duration;
    private double fee;
    @OneToMany(mappedBy = "course" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<StudentDetails> details = new ArrayList<>();

    public Course(String courseId, String courseName, String duration, double fee) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public Course() {
    }

    public Course(String courseId, String courseName, String duration, double fee, List<StudentDetails> details) {
        this.setCourseId(courseId);
        this.setCourseName(courseName);
        this.setDuration(duration);
        this.setFee(fee);
        this.setDetails(details);
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public List<StudentDetails> getDetails() {
        return details;
    }

    public void setDetails(List<StudentDetails> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", duration='" + duration + '\'' +
                ", fee=" + fee +
                ", details=" + details +
                '}';
    }
}
