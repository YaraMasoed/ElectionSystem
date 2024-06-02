package election;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Yara
 */
public class VoterLogin implements LoginBehaviour {

    private DB database = DB.getDatabase();

    @Override
    public User Login(String username, String password) {
        return DB.getDatabase().LoginVoter(username, password);
    }
}
