package election;

import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Yara
 */
public class Candidate extends User implements Observer {

    //attributes
    private int candidateID;

    private boolean approved;

    private String position;

    private int yearsOfexp;

    private Event campaignEvents;

    private ReadOnlyMessage ROImessage;

    private ElectionCandidateROI ROIelection;

    //constructor
    public Candidate() {
        this.ROIelection = new Election();
        this.campaignEvents = new Event();
    }

    public Candidate(int candidateID, boolean approved, String position, int yearsOfexp, ElectionCandidateROI ROIelection,
            String name, char gender, String email, String nationalID, String dateOfBirth, String username, String password) {
        super(name, gender, email, nationalID, dateOfBirth, username, password);
        this.candidateID = candidateID;
        this.approved = approved;
        this.position = position;
        this.yearsOfexp = yearsOfexp;
        this.ROIelection = ROIelection;
        this.campaignEvents = new Event();
        this.ROImessage = new Message();
    }

    //setter and getter
    public int getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(int candidateID) {
        this.candidateID = candidateID;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getYearsOfexp() {
        return yearsOfexp;
    }

    public void setYearsOfexp(int yearsOfexp) {
        this.yearsOfexp = yearsOfexp;
    }

    public Event getCampaignEvents() {
        return campaignEvents;
    }

    public void setCampaignEvents(Event campaignEvents) {
        this.campaignEvents = campaignEvents;
    }

    public ReadOnlyMessage getROImessage() {
        return ROImessage;
    }

    public void setROImessage(ReadOnlyMessage ROImessage) {
        this.ROImessage = ROImessage;
    }

    public ElectionCandidateROI getROIelection() {
        return ROIelection;
    }

    public void setROIelection(ElectionCandidateROI ROIelection) {
        this.ROIelection = ROIelection;
    }

    //methods
    @Override
    public void update() {
        System.out.println("Results posted");
    }

    public void applyToBeCandidate(int electionID) {
        DB.getDatabase().applyCandidate(this, electionID);
    }

    public ArrayList<Candidate> viewAllCandidates() {
        return DB.getDatabase().getAllCandidates();
    }

    public void updateProfile() {
        DB.getDatabase().updateProfile(this);
    }

    //methodes from object of election ROI
    public ArrayList<Election> viewElections() {
        return ROIelection.viewElections();
    }

    public ArrayList<String[]> viewResults() {
        return ROIelection.viewResults();
    }

    //methodes form object event
    public void createEvent(Event e) {
        campaignEvents.createEvent(e, candidateID);
    }

    public ArrayList<Event> viewMyEvents() {
        return campaignEvents.viewMyEvents(candidateID);
    }

    public void modifyEvent(Event e) {
        campaignEvents.modifyEvent(e, candidateID);
    }

    public void deleteEvent(int eventID) {
        campaignEvents.deleteEvent(eventID);
    }

    //methodes form object message
    public ArrayList<Message> viewMsg() {
        return ROImessage.viewMessage(candidateID);
    }
}
