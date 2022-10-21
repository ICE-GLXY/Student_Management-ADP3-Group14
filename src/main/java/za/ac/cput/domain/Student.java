package za.ac.cput.domain;
/* Student.java
Entity for the Student
Author: Chante Lewis: 216118395
Date: 30 September 2022
 */

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Student implements Serializable {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentID;
    @NotNull private String studentName;
    @NotNull private String email;
    @NotNull private String address;
    @NotNull private String username;
    @NotNull private String password;
    @NotNull private String school;
    @NotNull private int grade;

    private Student(StudentBuilder builder) {
        this.studentID = builder.studentID;
        this.studentName = builder.studentName;
        this.email = builder.email;
        this.address = builder.address;
        this.username = builder.username;
        this.password = builder.password;
        this.school = builder.school;
        this.grade = builder.grade;
    }

    protected Student() {
    }

    public int getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSchool() {
        return school;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", studentName='" + studentName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", school='" + school + '\'' +
                ", grade=" + grade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentID == student.studentID && grade == student.grade && Objects.equals(studentName, student.studentName) && Objects.equals(email, student.email) && Objects.equals(address, student.address) && Objects.equals(username, student.username) && Objects.equals(password, student.password) && Objects.equals(school, student.school);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID, studentName, email, address, username, password, school, grade);
    }

    public static class StudentBuilder {
        private int studentID;
        private String studentName;
        private String email;
        private String address;
        private String username;
        private String password;
        private String school;
        private int grade;


        public StudentBuilder setStudentID(int studentID) {
            this.studentID = studentID;
            return this;
        }

        public StudentBuilder setStudentName(String studentName) {
            this.studentName = studentName;
            return this;
        }

        public StudentBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public StudentBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public StudentBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public StudentBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public StudentBuilder setSchool(String school) {
            this.school = school;
            return this;
        }

        public StudentBuilder setGrade(int grade) {
            this.grade = grade;
            return this;
        }

        public StudentBuilder copy(Student student){
            this.studentID = student.studentID;
            this.studentName = student.studentName;
            this.email = student.email;
            this.address = student.address;
            this.username = student.username;
            this.password = student.password;
            this.school = student.school;
            this.grade = student.grade;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
