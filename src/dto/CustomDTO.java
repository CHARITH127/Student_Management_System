package dto;

public class CustomDTO {
    private String studentName;
    private String address;
    private String tel;

    public CustomDTO() {
    }

    public CustomDTO(String studentName, String address, String tel) {
        this.setStudentName(studentName);
        this.setAddress(address);
        this.setTel(tel);
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
