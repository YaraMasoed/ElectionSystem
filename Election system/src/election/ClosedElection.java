package election;

import javax.swing.JOptionPane;

/**
 *
 * @author Yara
 */
public class ClosedElection implements ElectionState {

    @Override
    public boolean voteForCandidate(int voterID, int candidateID, int electionID) {
        System.out.println("Election is closed");
        JOptionPane.showMessageDialog(null, "Election is closed");
        return true;
    }

    @Override
    public boolean removeVote(int voterID, int electionID) {
        System.out.println("Election is closed");
        JOptionPane.showMessageDialog(null, "Election is closed");
        return true;
    }

}
