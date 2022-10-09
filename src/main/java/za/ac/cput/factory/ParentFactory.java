package za.ac.cput.factory;

import za.ac.cput.domain.Parent;
import za.ac.cput.util.Helper;

public class ParentFactory {
    public static Parent build(String parentId, String firstName, String lastName, String email, String mobileNumber, String address
            , String username, String password){

        if(parentId.isEmpty()){
            return null;
        }

        if(firstName == null){
            throw new IllegalArgumentException("First name is null");
        }
        return new Parent.Builder().ParentId(parentId).FirstName(firstName).LastName(lastName).Email(email).MobileNumber(mobileNumber)
                .Address(address).Username(username).Password(password).build();
    }
}

