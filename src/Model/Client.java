package Model;

import java.io.Serializable;

/**
 * Created by Gennady on 06.12.2016.
 */
public class Client implements Serializable {
    private String firstName,lastName;

    public Client(String fname,String lastname) {
        this.firstName=fname;
        this.lastName=lastname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
