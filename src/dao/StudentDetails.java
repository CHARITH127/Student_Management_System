package dao;

public interface StudentDetails extends CrudDAO<entity.StudentDetails,String> {
    boolean getStudentDetails(String courseID, String studentID);
}
