package election;

import java.util.ArrayList;

/**
 *
 * @author Yara
 */
public class Admin extends User {

    private int adminID;

    private Election election;

    private EligibilityBehaviour eligibility;

    public Admin(int adminID, String name, char gender, String email, String nationalID, String dateOfBirth, String username, String password) {
        super(name, gender, email, nationalID, dateOfBirth, username, password);
        this.adminID = adminID;
        this.election = new Election();
    }

    public Admin() {
        election = new Election();
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public Election getElections() {
        return election;
    }

    public void setElections(Election election) {
        this.election = election;
    }

    public EligibilityBehaviour getEligibility() {
        return eligibility;
    }

    public void setEligibility(EligibilityBehaviour eligibility) {
        this.eligibility = eligibility;
    }

    public boolean checkElegibility(User u) {
        return eligibility.checkElegibility(u);
    }

    //function from object election
    public ArrayList<Election> viewElections() {
        return election.viewElections();
    }

    public void removeElection(int electionID) {
        election.removeElection(electionID);
    }

    public boolean postResults() {
        return election.postResults();
    }

}
