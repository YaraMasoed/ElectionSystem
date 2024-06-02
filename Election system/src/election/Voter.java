package election;

import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Yara
 */
public class Voter extends User implements Observer {

    private int voterID;
    private boolean approved;
    private ElectionVoterROI vote;
    private Message messages;
    private Reservation reservations;

    public Voter() {
        this.vote = new Election();
        this.messages = new Message();
        this.reservations = new Reservation();
    }

    public Voter(int voterID, boolean approved, String name, char gender, String email, String nationalID, String dateOfBirth, String username, String password) {
        super(name, gender, email, nationalID, dateOfBirth, username, password);
        this.voterID = voterID;
        this.approved = approved;
        this.vote = new Election();
        this.messages = new Message();
        this.reservations = new Reservation();
    }

    public int getVoterID() {
        return voterID;
    }

    public void setVoterID(int voterID) {
        this.voterID = voterID;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public ElectionVoterROI getVote() {
        return vote;
    }

    public void setVote(ElectionVoterROI vote) {
        this.vote = vote;
    }

    public Message getMessages() {
        return messages;
    }

    public void setMessages(Message messages) {
        this.messages = messages;
    }

    public Reservation getReservations() {
        return reservations;
    }

    public void setReservations(Reservation reservations) {
        this.reservations = reservations;
    }

    @Override
    public void update() {
        DB.getDatabase().update();
    }

    public void applyToBeVoter() {
        DB.getDatabase().applyToBeVoter(this);
    }

    public ArrayList<Voter> getAllVoter() {
        return DB.getDatabase().getAllVoters();
    }

    //methodes from object vote
    public ArrayList<Candidate> viewParticipatingCandidates() {
        return vote.viewParticipatingCandidates();
    }

    public ArrayList<Election> viewElections() {
        return vote.viewElections();
    }

    //VOTE
    public boolean voteForCandidate(int candidateID, int electionID) {
        return vote.voteForCandidate(voterID, candidateID, electionID);
    }

    //REMOVE VOTE
    public boolean removeVote(int candidateID, int electionID) {
        return vote.removeVote(voterID, electionID);
    }

    public ArrayList<String[]> viewResults() {
        return vote.viewResults();
    }

    //methodes from object reservation
    public ArrayList<Event> viewCandidateEvents(int CandidateID) {
        return reservations.getEvent().viewMyEvents(CandidateID);
    }

    public boolean makeReservation() {
        return reservations.makeReservation(this);
    }

    //methods from object message
    public void sendMsg() {
        messages.sendMessage();
    }

    public boolean checkNotification() {
        return DB.getDatabase().checkAndUpdateNotify(voterID);
    }

}
