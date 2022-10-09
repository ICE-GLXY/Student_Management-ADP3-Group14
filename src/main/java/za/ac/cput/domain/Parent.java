package za.ac.cput.domain;
import java.io.Serializable;

public class Parent implements Serializable {
    private String parentId;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String address;
    private String username;
    private String password;

    public Parent() {
    }

    private Parent(Builder builder){
        this.parentId = builder.parentId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.mobileNumber = builder.mobileNumber;
        this.address = builder.address;
        this.username = builder.username;
        this.password = builder.password;
    }

    public String getParentId() {
        return parentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "parentId='" + parentId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", address='" + address + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder{
        private String parentId;
        private String firstName;
        private String lastName;
        private String email;
        private String mobileNumber;
        private String address;
        private String username;
        private String password;

        public Builder ParentId(String parentId){
            this.parentId = parentId;
            return this;
        }

        public Builder FirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder LastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder Email(String email){
            this.email = email;
            return this;
        }

        public Builder MobileNumber(String mobileNumber){
            this.mobileNumber = mobileNumber;
            return this;
        }

        public Builder Address(String address){
            this.address = address;
            return this;
        }

        public Builder Username(String username){
            this.username = username;
            return this;
        }

        public Builder Password(String password){
            this.password = password;
            return this;
        }

        public Builder copy (Parent parent){
            this.parentId = parent.parentId;
            this.firstName = parent.firstName;
            this.lastName = parent.lastName;
            this.email = parent.email;
            this.mobileNumber = parent.mobileNumber;
            this.address = parent.address;
            this.username = parent.username;
            this.password = parent.password;
            return this;
        }

        public Parent build(){
            return new Parent(this);
        }
    }

}
