package entity;

import javax.persistence.*;
import java.util.Date;
@Entity
public class StudentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    @ManyToOne
    @JoinColumn
    private Student student;
    @ManyToOne
    @JoinColumn
    private Course course   ;

    public StudentDetails() {
    }

    public StudentDetails(int id, Date date, Student student, Course course) {
        this.id = id;
        this.date = date;
        this.student = student;
        this.course = course;
    }

    public StudentDetails(Date date, Student student, Course course) {
        this.date = date;
        this.student = student;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "StudentDetails{" +
                "id=" + id +
                ", date=" + date +
                ", student=" + student +
                ", course=" + course +
                '}';
    }
}
