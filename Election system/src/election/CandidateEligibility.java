package election;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Yara
 */
public class CandidateEligibility implements EligibilityBehaviour {

    @Override
    public boolean checkElegibility(User u) {
        Candidate c = (Candidate) u;
        String first2Char = c.getNationalID().substring(0, 2);
        LocalDate birthDate = LocalDate.parse(c.getDateOfBirth());

        // Get the current date (date formate year-month-day)
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);
        int years = period.getYears();

        //conditions to be a vote 1-correct national id (14 char and starts by 30), 2- above age of 30, 3- years of experience must be above 5
        if (c.getNationalID().length() == 14 && first2Char.equals("30") && years >= 30 && c.getYearsOfexp() >= 5) {
            DB.getDatabase().updateApprovalCandidate(c.getCandidateID());
            return true;
        } else {
            return false;
        }
    }
}
