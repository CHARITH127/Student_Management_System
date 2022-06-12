package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Student {
    @Id
    private String studentId;
    private String studentName;
    private int studentAge;
    private String tel;
    private String address;
    private String studentEmail;
    @OneToMany(mappedBy = "student",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<StudentDetails> details = new ArrayList<>();

    public Student() {
    }

    public Student(String studentId, String studentName, int studentAge, String tel, String address, String studentEmail) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.tel = tel;
        this.address = address;
        this.studentEmail = studentEmail;
    }

    public Student(String studentId, String studentName, int studentAge, String tel, String address, String studentEmail, List<StudentDetails> details) {

        this.setStudentId(studentId);
        this.setStudentName(studentName);
        this.setStudentAge(studentAge);
        this.setTel(tel);
        this.setAddress(address);
        this.setStudentEmail(studentEmail);
        this.details = details;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentAge=" + studentAge +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                ", details=" + details +
                '}';
    }
}
