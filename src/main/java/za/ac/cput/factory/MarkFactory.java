package za.ac.cput.factory;
/*
 * Author Lelihle Gazi - (214258041)
 * MarkFactory.java
 * Created object for Mark class
 * 2022
 */


import za.ac.cput.domain.Mark;
import za.ac.cput.util.Helper;

public class MarkFactory {

    public  static Mark createMark(String markID, String markDescription, String MarkStudentId, String MarkSubjectId , float MarkResult){

        if(Helper.isEmpty(markID) || Helper.isEmpty(markDescription) || Helper.isEmpty(MarkStudentId) || Helper.isEmpty(MarkSubjectId))
            return null;

        return new Mark.Builder().setMarkID(markID)
                .setMarkDescription(markDescription)
                .setMarkStudentID(MarkStudentId)
                .setMarkSubjectId(MarkSubjectId)
                .setMarkResult(MarkResult)
                .build();
    }
}
