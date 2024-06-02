package election;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Yara
 */
public class User {

    private String name;
    private char gender;
    private String email;
    private String nationalID;
    private String dateOfBirth;
    private String username;
    private String password;
    private LoginBehaviour loginType;

    // Constructor
    public User() {
    }

    public User(String name, char gender, String email, String nationalID, String dateOfBirth, String username, String password) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.nationalID = nationalID;
        this.dateOfBirth = dateOfBirth;
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginBehaviour getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginBehaviour loginType) {
        this.loginType = loginType;
    }

    public User login(String Username, String Password) {
        return loginType.Login(Username, Password);
    }

    public void addUser(User u) {
        DB.getDatabase().addUser(u);
    }
}
