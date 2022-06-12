package bo;

import dto.StudentDetailsDTO;

import java.util.ArrayList;

public interface StudentDetailsBO {
    boolean addStudentDetails(StudentDetailsDTO dto);
    boolean deleteStudentDetail(String id);
    ArrayList<StudentDetailsDTO> getAllStudentDetails();
    boolean getStudentDetails(String coureID , String studentID);
}
