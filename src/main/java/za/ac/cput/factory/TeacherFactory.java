package za.ac.cput.factory;
/*
 * Author Lelihle Gazi - (214258041)
 * TeacherFactory.java
 * Created an object for Teacher class
 * 2022
 */


import za.ac.cput.domain.Teacher;
import za.ac.cput.util.Helper;

public class TeacherFactory {

    public  static Teacher createTeacher(String teacherID, String username, String password, String email) {

        if (!Helper.isValidEmail(email))
            return null;

        if(Helper.isEmpty(teacherID) || Helper.isEmpty(username) || Helper.isEmpty(password))
            return null;

        return new Teacher.Builder().setTeacherID(teacherID)
                .setUserName(username)
                .setPassword(password).setEmail(email)
                .build();
    }
}