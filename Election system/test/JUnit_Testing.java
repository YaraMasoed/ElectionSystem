
import election.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class JUnit_Testing {

    Admin a;

    public static void setUpClass() {
        System.out.println("Testing is Running for the class");
    }

    @Before
    public void setup() {
        a = new Admin();
    }

    @Test
    public void VoterLogInTest() {
        System.out.println("Test login Method to ensure voter exists on the system");
        String username = "Manar";
        String password = "Manar";
        //onject that reurns the voter if it exists on the system
        Voter v = DB.getDatabase().LoginVoter(username, password);
        //supposed to be null if Voter doesn't exist
        Assert.assertNotNull(v);
    }

    @Test
    public void getElectionByIDTest() {
        System.out.println("Testing if a specific election exists");
        Election e = DB.getDatabase().getElectionByID(10);
        Assert.assertNull(e);
    }

    @Test
    public void elegibilityTest() {
        System.out.println("checking elegibility");
        //public Voter(int voterID, boolean approved, String name, char gender, String email, String nationalID, String dateOfBirth, String username, String password) {
        Voter v = new Voter(6, false, "Fatma", 'F', "Fatma@gmail.com", "30123456789012", "2002-04-15", "Fatma", "Pass");
        a.setEligibility(new VoterEligibility());
        boolean elegible = a.checkElegibility(v);
        Assert.assertTrue(elegible);
    }
}
