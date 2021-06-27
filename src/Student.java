public class Student {
    int studentId;
    String studentName;
    int grade;
    String address;
    
    public void showStudentinfo() { //학생이름  + 주소 표현합니다.
        System.out.println(studentName + " ," + address);
    }
    
    public static void main(String[] args) {
        Student student = new Student();
        student.studentName = "이순신";
        student.address = "포항시";
        student.showStudentinfo();
    }
}
