package election;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Yara
 */
public class CandidateLogin implements LoginBehaviour {

    @Override
    public User Login(String username, String password) {
        return DB.getDatabase().LoginCandidate(username, password);
    }
}
