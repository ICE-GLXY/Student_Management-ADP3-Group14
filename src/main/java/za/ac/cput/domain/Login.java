/*
* Moegammad Tasreeq Adams
* Student NUmber:216173027
 */
package za.ac.cput.domain;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Login implements Serializable {

    @Id
    @NotNull
    private String loginID;
    @NotNull
    private String email;
    @NotNull
    private String password;

    protected Login() {
    }

    private Login(Builder builder) {
        this.loginID = builder.loginID;
        this.email = builder.email;
        this.password = builder.password;

    }

    public String getLoginID() {
        return loginID;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "loginID='" + loginID + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder {
        private String loginID;
        private String email;
        private String password;

        public Builder setLoginID(String loginID) {
            this.loginID = loginID;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder copy(Login login) {
            this.loginID = login.loginID;
            this.email = login.email;
            this.password = login.password;
            return this;
        }

        public Login build() {
            return new Login(this);
        }
    }

}
