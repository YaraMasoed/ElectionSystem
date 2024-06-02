package election;

/**
 *
 * @author Yara
 */
public interface ElectionState {

    public boolean voteForCandidate(int voterID, int candidateID, int electionID);

    public boolean removeVote(int voterID, int electionID);
}
