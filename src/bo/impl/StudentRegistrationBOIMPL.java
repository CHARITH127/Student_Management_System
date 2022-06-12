package bo.impl;

import bo.StudentBO;
import bo.StudentDetailsBO;
import bo.StudentRegistrationBO;
import dto.StudentDTO;
import dto.StudentDetailsDTO;

public class StudentRegistrationBOIMPL implements StudentRegistrationBO {
    StudentBO studentBO = new StudentBOIMPL();
    StudentDetailsBO detailsBO = new StudentDetailBOIMPL();
    @Override
    public boolean registerStudent(StudentDTO studentDTO, StudentDetailsDTO studentDetails) {
        if (addStudent(studentDTO)) {
            if (addStudentDetails(studentDetails)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addStudent(StudentDTO studentDTO) {
        return studentBO.addStudent(studentDTO);
    }

    @Override
    public boolean addStudentDetails(StudentDetailsDTO studentDetails) {
        return detailsBO.addStudentDetails(studentDetails);
    }
}
