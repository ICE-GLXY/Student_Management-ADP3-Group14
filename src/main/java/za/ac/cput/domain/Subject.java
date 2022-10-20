package za.ac.cput.domain;

/* Subject.java
Entity for the Subject
Author: Chante Lewis: 216118395
Date: 30 September 2022
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Subject implements Serializable {

    @NotNull
    @Id private int subjectID;
    @NotNull private String subjectName;

    protected Subject(){}

    private Subject(SubjectBuilder builder){
        this.subjectID = builder.subjectID;
        this.subjectName = builder.subjectName;
    }


    public int getSubjectID() {
        return subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectID=" + subjectID +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return subjectID == subject.subjectID && Objects.equals(subjectName, subject.subjectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectID, subjectName);
    }

    public static class SubjectBuilder{
        private int subjectID;
        private String subjectName;

        public SubjectBuilder setSubjectID(int subjectID) {
            this.subjectID = subjectID;
            return this;
        }

        public SubjectBuilder setSubjectName(String subjectName) {
            this.subjectName = subjectName;
            return this;
        }

        public SubjectBuilder copy (Subject subject){
            this.subjectID = subject.subjectID;
            this.subjectName = subject.subjectName;
            return this;
        }

        public Subject build() {
            return new Subject(this);
        }

    }

}