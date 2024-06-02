package election;

import java.util.ArrayList;

/**
 *
 * @author Yara
 */
public interface ElectionVoterROI {

    public boolean voteForCandidate(int voterID, int candidateID, int electionID);

    public boolean removeVote(int voterID, int electionID);

    public ArrayList<String[]> viewResults();

    public ArrayList<Candidate> viewParticipatingCandidates();

    public ArrayList<Election> viewElections();

}
