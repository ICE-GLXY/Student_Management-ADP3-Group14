package za.ac.cput.factory;

import za.ac.cput.domain.verification;
import za.ac.cput.util.Helper;

public class verificationFactory {
    public static verification createVerification(String username, String emailField, String passwordField) {
        if (Helper.isEmpty(username) || Helper.isEmpty(emailField) || Helper.isEmpty(passwordField)) {
            return null;

        }

        if(!Helper.isValidEmail(emailField)){
            return null;
        }

        return new verification
                .Builder()
                .setEmailField(emailField)
                .setPasswordField(passwordField)
                .build();


    }
}
