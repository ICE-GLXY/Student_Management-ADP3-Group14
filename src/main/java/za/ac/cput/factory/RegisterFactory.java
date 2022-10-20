package za.ac.cput.factory;

import za.ac.cput.domain.Register;
import za.ac.cput.util.Helper;

public class RegisterFactory {
    public static Register createRegister(String registerNumber, String email, String password, String school, String parent, String student) {
        String registerId = Helper.generateSmallerId();
        if (registerNumber.isEmpty()) {
            return null;
        }

        Register register = new Register.Builder()
                .setRegisterNumber(registerId)
                .setEmail(email)
                .setPassword(password)
                .setSchool(school)
                .setParent(parent)
                .setStudent(student)
                .build();
        return register;

    }
}
