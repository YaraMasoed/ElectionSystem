package election;

import java.util.ArrayList;
import java.time.LocalDate;

/**
 *
 * @author Yara
 */
public class Election implements Subject, ElectionVoterROI, ElectionCandidateROI {

    private int electionID;
    private String electionTitle;
    private String electionStartDate;
    private String electionEndDate;
    private ArrayList<Observer> observers;
    private ElectionState electionState;

    //constructors
    public Election() {

    }

    public Election(int electionID, String electionTitle, String electionStartDate, String electionEndDate) {
        this.electionID = electionID;
        this.electionTitle = electionTitle;
        this.electionStartDate = electionStartDate;
        this.electionEndDate = electionEndDate;
        this.observers = new ArrayList<Observer>();
        checkElectionState();//setting the state of the election automatically
    }

    //setters and getters
    @Override
    public int getElectionID() {
        return electionID;
    }

    public void setElectionID(int electionID) {
        this.electionID = electionID;
    }

    public String getElectionTitle() {
        return electionTitle;
    }

    public void setElectionTitle(String electionTitel) {
        this.electionTitle = electionTitel;
    }

    public String getElectionStartDate() {
        return electionStartDate;
    }

    public void setElectionStartDate(String electionStartDate) {
        this.electionStartDate = electionStartDate;
    }

    public String getElectionEndDate() {
        return electionEndDate;
    }

    public void setElectionEndDate(String electionEndDate) {
        this.electionEndDate = electionEndDate;
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }

    public ElectionState getElectionState() {
        return electionState;
    }

    public void setElectionState(ElectionState electionState) {
        this.electionState = electionState;
    }

    //ckecks the state of the election based on the current date
    public boolean checkElectionState() {
        LocalDate currentDate = LocalDate.now();
        LocalDate startDateParsed = LocalDate.parse(electionStartDate);
        LocalDate endDateParsed = LocalDate.parse(electionEndDate);

        if (currentDate.isAfter(startDateParsed) && currentDate.isBefore(endDateParsed)) {
            this.electionState = new OpenElection();
            return true;
        } else {
            this.electionState = new ClosedElection();
            return false;
        }
    }

    //functions
    public void createElection() {
        DB.getDatabase().createElection(this);
    }

    public void removeElection(int electionID) {
        DB.getDatabase().deleteElection(electionID);
    }

    //functions from interface subject
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }

    //methodes from the ROIs
    @Override
    public ArrayList<String[]> viewResults() {
        return DB.getDatabase().getResults();
    }

    @Override
    public int viewNoOfVotes(int candidateID) {
        return DB.getDatabase().ViewNoOfVotes(candidateID);
    }

    @Override
    public ArrayList<Election> viewElections() {
        return DB.getDatabase().viewElections();
    }

    @Override
    public Election getElectionByID(int electionID) {
        return DB.getDatabase().getElectionByID(electionID);
    }

    public Election getElectionByName(String electionName) {
        return DB.getDatabase().getElectionByName(electionName);
    }

    @Override
    public ArrayList<Candidate> viewParticipatingCandidates() {
        return DB.getDatabase().viewParticipatingCandidates(electionID);
    }

    //VOTE
    @Override
    public boolean voteForCandidate(int voterID, int candidateID, int electionID) {
        return electionState.voteForCandidate(voterID, candidateID, electionID);
    }

    //REMOVE VOTE
    @Override
    public boolean removeVote(int voterID, int electionID) {
        return electionState.removeVote(voterID, electionID);
    }

    public boolean postResults() {
        if (DB.getDatabase().postResults(electionID)) {
            observers = DB.getDatabase().getObservers(electionID);
            notifyObservers();
        }
        return DB.getDatabase().postResults(electionID);
    }

}
