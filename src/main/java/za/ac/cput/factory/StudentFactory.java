package za.ac.cput.factory;

/* StudentFactory.java
Author: Chante Lewis: 216118395
Date: 30 September 2022
 */
import za.ac.cput.domain.Student;
import za.ac.cput.util.Helper;

public class StudentFactory{
    //creating student objects
    public static Student build(int studentID,String studentName, String email, String address, String username, String password, String school, int grade){

        Helper.isEmpty("studentID");
        Helper.isEmpty("studentName");
        Helper.isEmpty("username");
        Helper.isEmpty("password");
        Helper.isEmpty("school");

        Helper.isValidEmail("email");

        return new Student.StudentBuilder().setStudentID(studentID)
                .setStudentName(studentName)
                .setEmail(email)
                .setAddress(address)
                .setUsername(username)
                .setPassword(password)
                .setSchool(school)
                .setGrade(grade)
                .build();

    }
}
