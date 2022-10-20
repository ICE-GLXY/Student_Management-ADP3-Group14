package za.ac.cput.domain;
/*
Titilayo Akinjole - 220283982
ADP3
School Management
*/

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

public class grade {

    @Id @NotNull
    private String gradeId;

    @Id @NotNull
    private String gradeStudentId;


    private grade(Builder b){
        this.gradeId = b.gradeId;
        this.gradeStudentId = b.gradeStudentId;
    }

    public String getGradeId() {
        return gradeId;
    }

    public String getGradeStudentId() {
        return gradeStudentId;
    }

    @Override
    public String toString() {
        return "grade{" +
                "gradeId='" + gradeId + '\'' +
                ", gradeStudentId='" + gradeStudentId + '\'' +
                '}';
    }

        public static class Builder {
            private String gradeId;
            private String gradeStudentId;


            public Builder gradeId(String gradeId) {
                this.gradeId = gradeId;
                return this;
            }

            public Builder gradeStudentId(String gradeStudentId) {
                this.gradeStudentId = gradeStudentId;
                return this;
            }

            public Builder copy(grade e) {
                this.gradeId = e.gradeId;
                this.gradeStudentId = e.gradeStudentId;
                return this;
            }

            public grade build() {
                return new grade(this);
            }
        }}




