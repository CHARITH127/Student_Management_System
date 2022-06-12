package bo;

import dto.StudentDTO;

public interface StudentBO {
    boolean addStudent(StudentDTO dto);
    StudentDTO getStudent(String id);
    boolean updateStudent(StudentDTO dto);
    boolean deleteStudent(String id);
}
