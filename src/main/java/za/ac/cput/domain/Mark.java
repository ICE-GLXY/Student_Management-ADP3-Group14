package za.ac.cput.domain;

/*
 * Author Lelihle Gazi - (214258041)
 * Mark.java
 * Created domain entity for Mark class
 * 2022
 */

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
public class Mark implements Serializable {
    @Id
    @NotNull
    private String markID;
    @NotNull
    private String markDescription;
    @NotNull
    private String markStudentId;
    @NotNull
    private String markSubjectId;
    @NotNull
    private float markResult;

    protected Mark() {
    }
    private Mark(Builder builder){
        this.markID = builder.markID;
        this.markDescription = builder.markDescription;
        this.markStudentId = builder.markStudentID;
        this.markSubjectId = builder.markSubjectId;
        this.markResult = builder.markResult;

    }

    public String getMarkID() {return markID;}

    public String getMarkDescription() {
        return markDescription;
    }

    public String getMarkStudentId() {
        return markStudentId;
    }

    public String getMarkSubjectId() {
        return markSubjectId;
    }

    public float getMarkResult() {
        return markResult;
    }


    @Override
    public String toString() {
        return "Mark{" +
                "markID='" + markID + '\'' +
                ", markDescription='" + markDescription + '\'' +
                ", markStudentId='" + markStudentId + '\'' +
                ", markSubjectId='" + markSubjectId + '\'' +
                ", markResult=" + markResult +
                '}';
    }

    public static class Builder {
        private String markID;
        private String markDescription;
        private String markStudentID;
        private String markSubjectId;
        private float markResult;

        public Builder setMarkID(String markID) {
            this.markID = markID;
            return  this;
        }

        public Builder setMarkDescription(String markDescription) {
            this.markDescription = markDescription;
            return this;
        }

        public Builder setMarkStudentID(String markStudentID) {
            this.markStudentID = markStudentID;
            return this;
        }

        public Builder setMarkSubjectId(String markSubjectId) {
            this.markSubjectId = markSubjectId;
            return this;
        }

        public Builder setMarkResult(float markResult) {
            this.markResult = markResult;
            return this;
        }

        public Builder copy(Mark mark){
            this.markID = mark.markID;
            this.markDescription = mark.markDescription;
            this.markStudentID = mark.markStudentId;
            this.markSubjectId = mark.markSubjectId;
            this.markResult = mark.markResult;
            return this;
        }

        public Mark build(){
            return new Mark(this);
        }
    }
}