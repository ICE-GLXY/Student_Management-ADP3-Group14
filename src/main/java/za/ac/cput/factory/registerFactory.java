/*
 * Moegammad Tasreeq Adams
 * Student NUmber:216173027
 */

package za.ac.cput.factory;

import za.ac.cput.domain.register;

public class registerFactory {
    public static register createRegister(String registerNumber, String email, String password, String school, String parent, String student) {
        //String registerId = Helper.generateSmallerId();
        if (registerNumber.isEmpty()) {
            return null;
        }

        register register = new register.Builder()
                .setRegisterNumber(registerNumber)
                .setEmail(email)
                .setPassword(password)
                .setSchool(school)
                .setParent(parent)
                .setStudent(student)
                .build();
        return register;

    }
}
