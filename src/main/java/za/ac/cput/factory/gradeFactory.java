package za.ac.cput.factory;

import za.ac.cput.domain.grade;
import za.ac.cput.util.Helper;

public class gradeFactory {
    public static grade build (String gradeId,String gradeStudentId){
        if(gradeId.isEmpty() || !gradeStudentId.isEmpty())
            throw new IllegalArgumentException("Invalid email");
        return new grade.Builder()
                .gradeId(gradeId)
                .gradeStudentId(gradeStudentId)
                .build();
    }
}
