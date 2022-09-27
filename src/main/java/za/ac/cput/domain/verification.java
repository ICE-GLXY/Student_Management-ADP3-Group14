package za.ac.cput.domain;

/*
 * Mogamad Taariq Phillips - 220166153
 * Verification.java
 * Creation of attributes for the Verification entity
 *
 */

import javax.persistence.Embeddable;


@Embeddable
public class verification  {
    private String username;
    private String emailField;
    private String passwordField;

    protected verification(){

    }

    //private builder constructor
    private verification(Builder builder) {
        this.username = builder.username;
        this.emailField = builder.emailField;
        this.passwordField = builder.passwordField;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailField() {
        return emailField;
    }

    public void setEmailField(String emailField) {
        this.emailField = emailField;
    }


    public String getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(String passwordField) {
        this.passwordField = passwordField;
    }



    @Override
    public String toString() {
        return "verification{" +
                "username='" + username + '\'' +
                ", emailField='" + emailField + '\'' +
                ", passwordField='" + passwordField + '\'' +
                '}';
    }

    public static class Builder {
        private String username;
        private String emailField;
        private String passwordField;

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setEmailField(String emailField) {
            this.emailField = emailField;
            return this;
        }

        public Builder setPasswordField(String passwordField) {
            this.passwordField = passwordField;
            return this;
        }

        public Builder copy(verification verification) {
            this.username = verification.username;
            this.emailField = verification.emailField;
            this.passwordField = verification.passwordField;

            return this;
        }

        public verification build() {
            return new verification(this);
        }

    }
}