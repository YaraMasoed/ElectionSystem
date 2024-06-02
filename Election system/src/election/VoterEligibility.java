package election;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Yara
 */
public class VoterEligibility implements EligibilityBehaviour {

    @Override
    public boolean checkElegibility(User u) {
        Voter v = (Voter) u;
        String first2Char = v.getNationalID().substring(0, 2);
        LocalDate birthDate = LocalDate.parse(v.getDateOfBirth());

        // Get the current date (date formate year-month-day)
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);
        int years = period.getYears();

        //conditions to be a vote 1-correct national id (14 char and starts by 30), 2- above age of 18
        if (v.getNationalID().length() == 14 && first2Char.equals("30") && years >= 18) {
            DB.getDatabase().updatVotereApproval(v.getVoterID());
            return true;
        } else {
            return false;
        }
    }
}
