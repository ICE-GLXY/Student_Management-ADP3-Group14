package za.ac.cput.factory;

import za.ac.cput.domain.school;
import za.ac.cput.util.Helper;

public class schoolFactory {
    public static school createSchool(String id, String name){
        if (Helper.isEmpty(id) || Helper.isEmpty(name)){
            return null;
        }
        return new school.Builder().schoolId(id).schoolName(name).build();
    }
}
