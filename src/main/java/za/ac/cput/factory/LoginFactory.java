package za.ac.cput.factory;

import org.hibernate.boot.model.source.internal.hbm.Helper;
import za.ac.cput.domain.Login;

public class LoginFactory {
    public static Login createLogin(String loginID, String email, String password) {
        if (loginID.isEmpty()) {
            return null;
        } else if (email == null) {
            throw new IllegalArgumentException("email incorrect");
        } else if (password == null) {
            throw new IllegalArgumentException("password incorrect");
        } else {
            return new Login.Builder()
                    .setLoginID(loginID)
                    .setEmail(email)
                    .setPassword(password)
                    .build();
        }
    }

}
