package ro.bestem.doamneajuta.util;

/**
 * Created by Andrei-Daniel Ene on 4/14/2018.
 */
public class UserRegister extends User {
    private String fullName;
    private String phone;
    private String town;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
