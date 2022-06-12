package bo;

import dto.StudentDTO;
import dto.StudentDetailsDTO;
import entity.Student;
import entity.StudentDetails;

public interface StudentRegistrationBO {
    boolean registerStudent(StudentDTO studentDTO, StudentDetailsDTO studentDetails);
    boolean addStudent(StudentDTO studentDTO);
    boolean addStudentDetails(StudentDetailsDTO studentDetails);
}
