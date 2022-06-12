package bo.impl;

import bo.StudentBO;
import dao.DAOFactory;
import dao.StudentDAO;
import dao.impl.StudentDAOIMPL;
import dto.StudentDTO;
import entity.Student;

public class StudentBOIMPL implements StudentBO {
    StudentDAO studentDAO = new StudentDAOIMPL();

    @Override
    public boolean addStudent(StudentDTO dto) {
        return studentDAO.add(new Student(dto.getStudentId(), dto.getStudentName(), dto.getStudentAge(), dto.getTel(), dto.getAddress(), dto.getStudentEmail()));
    }

    @Override
    public StudentDTO getStudent(String id) {
        Student search = studentDAO.search(id);
        return new StudentDTO(search.getStudentId(), search.getStudentName(), search.getStudentAge(), search.getTel(), search.getAddress(), search.getStudentEmail());
    }

    @Override
    public boolean updateStudent(StudentDTO dto) {
        return studentDAO.update(new Student(dto.getStudentId(), dto.getStudentName(), dto.getStudentAge(), dto.getTel(), dto.getAddress(), dto.getStudentEmail()));
    }

    @Override
    public boolean deleteStudent(String id) {
        return studentDAO.delete(id);
    }
}
