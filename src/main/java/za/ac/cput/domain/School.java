package za.ac.cput.domain;

import java.io.Serializable;

public class School implements Serializable {
    private String schoolId;
    private String schoolName;

    public School() {
    }

    private School(School.Builder builder){
        this.schoolId = builder.schoolId;
        this.schoolName = builder.schoolName;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    @Override
    public String toString() {
        return "School{" +
                "schoolId='" + schoolId + '\'' +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }

    public static class Builder{
        private String schoolId;
        private String schoolName;

        public School.Builder SchoolId(String schoolId){
            this.schoolId = schoolId;
            return this;
        }

        public School.Builder SchoolName(String schoolName){
            this.schoolName = schoolName;
            return this;
        }

        public School.Builder copy (School school){
            this.schoolId = school.schoolId;
            this.schoolName = school.schoolName;
            return this;
        }
        public School build(){
            return new School(this);
        }
    }
}
