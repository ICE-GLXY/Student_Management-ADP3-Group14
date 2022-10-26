package za.ac.cput.factory;
/*
 * Moegammad Tasreeq Adams
 * Student NUmber:216173027
 */
import za.ac.cput.domain.login;
import za.ac.cput.util.Helper;

public class loginFactory {
    public static login createLogin(String loginNumber, String email, String password) {

        if (loginNumber.isEmpty()) {
            return null;
        }

        if (email == null || !Helper.isValidEmail(email)) {
            //throw new IllegalArgumentException("email incorrect");
            return null;
        }

        if (password == null) {
            //throw new IllegalArgumentException("password incorrect");
            return null;
        }

            return new login.Builder()
                    .setloginNumber(loginNumber)
                    .setEmail(email)
                    .setPassword(password)
                    .build();

    }

}
