package za.ac.cput.domain;
/*
 * Author Lelihle Gazi - (214258041)
 * Teacher.java
 * Created entity for Teacher class
 * 2022
 */

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
public class Teacher implements Serializable {
    @Id
    @NotNull
    private String teacherID;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String email;

    protected Teacher() {
    }

    private Teacher(Builder builder){
        this.teacherID = builder.teacherID;
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;

    }

    public String getTeacherID() {
        return teacherID;
    }
    public String getUsername() {return username; }

    public String getPassword() {return password; }

    public String getEmail() {
        return email;
    }



    @Override
    public String toString() {
        return "Teacher{" +
                "teacherID='" + teacherID + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    public static class Builder {
        private String teacherID;
        private String username;
        private String password;
        private String email;

        public Builder setTeacherID(String teacherID){
            this.teacherID = teacherID;
            return this;
        }

        public Builder setUserName(String userName){
            this.username = userName;
            return this;
        }
        public Builder setPassword(String Password){
            this.password= Password;
            return this;
        }
        public Builder setEmail(String email){
            this.email = email;
            return this;
        }
        public Builder copy(Teacher teacher){
            this.teacherID = teacher.teacherID;
            this.username = teacher.username;
            this.password = teacher.password;
            this.email = teacher.email;
            return this;

        }
        public Teacher build(){
            return  new Teacher(this);
        }

    }
}