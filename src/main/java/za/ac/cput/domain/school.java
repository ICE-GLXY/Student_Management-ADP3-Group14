package za.ac.cput.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class school implements Serializable {
    @Id
    @Column(name = "schoolId")
    private String schoolId;
    private String schoolName;
    
    protected school() {
    
    }
    
    private school(Builder builder) {
        this.schoolId = builder.schoolId;
        this.schoolName = builder.schoolName;
    }
    
    public String getSchoolId() {
        return schoolId;
    }
    
    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }
    
    public String getSchoolName() {
        return schoolName;
    }
    
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
    
    @Override
    public String toString() {
        return "school{" +
                "schoolId='" + schoolId + '\'' +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }
    
    public static class Builder {
        private String schoolId;
        private String schoolName;
    
    
        public Builder schoolId(String schoolId) {
            this.schoolId = schoolId;
            return this;
        }
    
        public Builder schoolName(String schoolName) {
            this.schoolName = schoolName;
            return this;
        }
    
        public Builder copy(school s) {
            this.schoolId = s.schoolId;
            this.schoolName = s.schoolName;
            return this;
        }
    
        public school build() {
            return new school(this);
        }
    }
}