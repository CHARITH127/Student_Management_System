package bo.impl;

import bo.StudentDetailsBO;
import dao.impl.StudentDetailsDAOIMPL;
import dto.StudentDetailsDTO;
import entity.StudentDetails;

import java.util.ArrayList;

public class StudentDetailBOIMPL implements StudentDetailsBO {
    dao.StudentDetails  details = new StudentDetailsDAOIMPL();

    @Override
    public boolean addStudentDetails(StudentDetailsDTO dto) {
        return details.add(new StudentDetails(dto.getDate(),dto.getStudent(),dto.getCourse()));
    }

    @Override
    public boolean deleteStudentDetail(String id) {
        return details.delete(id);
    }

    @Override
    public ArrayList<StudentDetailsDTO> getAllStudentDetails() {
        ArrayList<StudentDetails> all = details.getAll();
        ArrayList<StudentDetailsDTO> details = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            details.add(i,new StudentDetailsDTO(all.get(i).getDate(),all.get(i).getStudent(),all.get(i).getCourse()));
        }
        return details;
    }

    @Override
    public boolean getStudentDetails(String courseID , String studentID) {
        return details.getStudentDetails(courseID,studentID);/*new StudentDetailsDTO(studentDetails.getDate(),studentDetails.getStudent(),studentDetails.getCourse());*/
    }
}
