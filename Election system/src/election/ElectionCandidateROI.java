package election;

import java.util.ArrayList;

/**
 *
 * @author Yara
 */
public interface ElectionCandidateROI {

    public int viewNoOfVotes(int candidateID);

    public ArrayList<String[]> viewResults();

    public ArrayList<Election> viewElections();

    public int getElectionID();

    public Election getElectionByID(int electionID);
}
