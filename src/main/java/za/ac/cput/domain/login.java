/*
* Moegammad Tasreeq Adams
* Student NUmber:216173027
 */
package za.ac.cput.domain;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class login implements Serializable {

    @Id @NotNull private String loginNumber;
    private String email;@NotNull
    private String password;

    protected login() {
    }


    private login(Builder builder) {
        this.loginNumber = builder.loginNumber;
        this.email = builder.email;
        this.password = builder.password;

    }

    //setter
    public void setLoginNumber(String loginNumber) {
        this.loginNumber = loginNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //getters
    public String getloginNumber() {
        return loginNumber;
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
                "loginNumber='" + loginNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    /////////////////////////////////////////////////////////
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        login login = (za.ac.cput.domain.login) o;
//        return loginNumber.equals(login.loginNumber) && email.equals(login.email) && password.equals(login.password);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(loginNumber, email, password);
//    }
 /////////////////////////////////////////////////////////
    public static class Builder {
        private String loginNumber;
        private String email;
        private String password;

        public Builder setloginNumber(String loginNumber) {
            this.loginNumber = loginNumber;
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

        public Builder copy(login login) {
            this.loginNumber = login.loginNumber;
            this.email = login.email;
            this.password = login.password;
            return this;
        }

        public login build() {
            return new login(this);
        }
    }

}
