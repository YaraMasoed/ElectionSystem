package election;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Yara
 */
public class AdminLogin implements LoginBehaviour {

    @Override
    public User Login(String username, String password) {
        return DB.getDatabase().LoginAdmin(username, password);
    }
}
