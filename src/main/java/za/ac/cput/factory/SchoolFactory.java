package za.ac.cput.factory;

import za.ac.cput.domain.School;
import za.ac.cput.util.Helper;

public class SchoolFactory {
    public static School build(String schoolId, String schoolName){

        if(schoolId.isEmpty()){
            return null;
        }

        if(schoolName == null){
            throw new IllegalArgumentException("School name is null");
        }
        return new School.Builder().SchoolId(schoolId).SchoolName(schoolName).build();
    }
}