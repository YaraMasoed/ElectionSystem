package election;

import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Yara
 */
public class OpenElection implements ElectionState {

    @Override
    public boolean voteForCandidate(int voterID, int candidateID, int electionID) {
        //canVote is ture if they did not alread vote before and false otherwise
        boolean canVote = DB.getDatabase().castVote(voterID, candidateID, electionID);
        if (canVote) {
            JOptionPane.showMessageDialog(null, "Thank you for voting");
        }
        return canVote;
    }

    @Override
    public boolean removeVote(int voterID, int electionID) {

        //canRemoveVote is ture if they did not alread vote before and false otherwise
        boolean canRemoveVote = DB.getDatabase().removeVote(voterID, electionID);
        if (canRemoveVote) {
            JOptionPane.showMessageDialog(null, "Vote Removed Successfully");
        }
        return canRemoveVote;
    }
}
