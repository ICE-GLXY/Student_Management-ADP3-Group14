package za.ac.cput.factory;

/* SubjectFactory.java
Author: Chante Lewis: 216118395
Date: 30 September 2022
 */

import za.ac.cput.domain.Subject;
import za.ac.cput.util.Helper;

public class SubjectFactory {

    //creating subject objects
    public static Subject build(int subjectID, String subjectName){

        Helper.isEmpty("subjectID");
        Helper.isEmpty("subjectName");

        return new Subject.SubjectBuilder().setSubjectID(subjectID)
                .setSubjectName(subjectName)
                .build();
    }

}