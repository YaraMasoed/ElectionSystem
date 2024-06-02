package election;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.time.LocalDate;

public class DB {

    private final String userName = "root";
    private final String password = "";
    private final String dbName = "election";
    private Connection con;
    private static DB database;

    //constuctor
    private DB() {
        try {
            //Loading the jdbc driver
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            //Get a connection to database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, userName, password);
            System.out.println("Connection done");
        } catch (Exception e) {
            System.err.println("DATABASE CONNECTION ERROR: " + e.toString());
        }
    }

    //connection
    public Connection getCon() {
        return con;
    }

    //get db instance
    public static DB getDatabase() {
        if (database == null) {
            database = new DB();
        }
        return database;
    }

    //login admin, returns object of type admin
    public Admin LoginAdmin(String username, String password) {
        Admin admin = null;
        try {
            Statement stmt = con.createStatement();

            // SQL query to join User and Voter tables based on voterID
            String sql = "SELECT u.name, u.gender, u.email, u.nationalID, u.DOB, u.username, a.adminID "
                    + "FROM User u "
                    + "JOIN Admin a ON u.username = a.username "
                    + "WHERE u.username = '" + username + "' AND u.password = '" + password + "'";

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                // Retrieve data from the result set
                String name = rs.getString("name");
                char gender = rs.getString("gender").charAt(0);
                String email = rs.getString("email");
                String nationalID = rs.getString("nationalID");
                String dateOfBirth = rs.getString("DOB");
                int adminID = rs.getInt("adminID");

                // Create a new Admin object using retrieved data
                admin = new Admin(adminID, name, gender, email, nationalID, dateOfBirth, username, password);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error retrieving admin data: " + e.getMessage());
        }

        return admin; // Return the Admin object (or null if not found)
    }

    //login voter, returns object of type admin
    public Voter LoginVoter(String username, String password) {
        Voter voter = null;
        try {
            Statement stmt = con.createStatement();

            // SQL query to join User and Voter tables based on username and approve status
            String sql = "SELECT u.name, u.gender, u.email, u.nationalID, u.DOB, u.username, v.voterID, v.approved "
                    + "FROM User u "
                    + "JOIN Voter v ON u.username = v.username "
                    + "WHERE u.username = '" + username + "' AND u.password = '" + password + "'";

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                // Check if user is approved (approved = 1)
                int approveStatus = rs.getInt("approved");
                if (approveStatus == 1) {
                    // Retrieve data from the result set
                    String name = rs.getString("name");
                    char gender = rs.getString("gender").charAt(0);
                    String email = rs.getString("email");
                    String nationalID = rs.getString("nationalID");
                    String dateOfBirth = rs.getString("DOB");
                    int voterID = rs.getInt("voterID");
                    boolean approved = rs.getBoolean("approved");

                    // Create a new Voter object using retrieved data
                    voter = new Voter(voterID, approved, name, gender, email, nationalID, dateOfBirth, username, password);
                } else {
                    System.out.println("User not approved for login");
                }
            } else {
                System.out.println("Invalid username or password");
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error retrieving voter data: " + e.getMessage());
        }

        return voter; // Return the Voter object (or null if not found or not approved)
    }

    //login admin, returns object of type candidate
    public Candidate LoginCandidate(String username, String password) {
        Candidate candidate = null;

        try {
            Statement stmt = con.createStatement();

            // SQL query to join User and Candidate tables based on username
            String sql = "SELECT c.candidateID, c.position, c.yearsOfExp, c.electionID, c.approved, u.name, u.gender, u.email, u.nationalID, u.DOB, u.username "
                    + "FROM Candidate c "
                    + "JOIN User u ON c.username = u.username "
                    + "WHERE c.username = '" + username + "' AND u.password = '" + password + "'";

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                int approveStatus = rs.getInt("approved");
                if (approveStatus == 1) {
                    // Retrieve data from the result set
                    int candidateID = rs.getInt("candidateID");
                    String position = rs.getString("position");
                    int yearsOfExp = rs.getInt("yearsOfExp");
                    String name = rs.getString("name");
                    char gender = rs.getString("gender").charAt(0);
                    String email = rs.getString("email");
                    String nationalID = rs.getString("nationalID");
                    String dateOfBirth = rs.getString("DOB");
                    int electionID = rs.getInt("electionID");
                    boolean approved = rs.getBoolean("approved");

                    ElectionCandidateROI e = getElectionByID(electionID);
                    // Create a new Candidate object using retrieved data
                    candidate = new Candidate(candidateID, approved, position, yearsOfExp, e, name, gender, email, nationalID, dateOfBirth, username, password);
                } else {
                    System.out.println("User not approved for login");
                }
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error retrieving candidate data: " + e.getMessage());
        }

        return candidate; // Return the Candidate object (or null if not found)
    }

    //returns all voters in the system
    //used to check thier eligibility
    public ArrayList<Voter> getAllVoters() {
        ArrayList<Voter> voters = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM User u JOIN Voter v ON u.username = v.username";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int voterID = rs.getInt("voterID");
                String name = rs.getString("name");
                char gender = rs.getString("gender").charAt(0);
                String email = rs.getString("email");
                String nationalID = rs.getString("nationalID");
                String dateOfBirth = rs.getString("DOB");
                String username = rs.getString("username");
                String password = rs.getString("password");
                boolean approved = rs.getBoolean("approved");

                Voter voter = new Voter(voterID, approved, name, gender, email, nationalID, dateOfBirth, username, password);
                voters.add(voter);
            }

            rs.close();
        } catch (SQLException e) {
            System.out.println("Error retrieving voters: " + e.getMessage());
        }

        return voters;
    }

    //returns all candidates in the system
    //used to check thier eligibility
    public ArrayList<Candidate> getAllCandidates() {
        ArrayList<Candidate> candidates = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM User u JOIN Candidate c ON u.username = c.username";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int candidateID = rs.getInt("candidateID");
                String name = rs.getString("name");
                char gender = rs.getString("gender").charAt(0);
                String email = rs.getString("email");
                String nationalID = rs.getString("nationalID");
                String dateOfBirth = rs.getString("DOB");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String Position = rs.getString("Position");
                int YOE = rs.getInt("yearsOfEXP");
                int electionID = rs.getInt("electionID");
                boolean approved = rs.getBoolean("approved");
                ElectionCandidateROI e = getElectionByID(electionID);

                Candidate c = new Candidate(candidateID, approved, Position, YOE, e, name, gender, email, nationalID, dateOfBirth, username, password);
                candidates.add(c);
            }

            rs.close();
        } catch (SQLException e) {
            System.out.println("Error retrieving candidates: " + e.getMessage());
        }

        return candidates;
    }

    //returns all the Elections in the system
    //used so the voter can chose which election they want to vote in
    //also used to show the candidate what elections are available to apply in the system
    //also used by the admin to view all the election so he can delete them if needed
    public ArrayList<Election> viewElections() {
        ArrayList<Election> election = new ArrayList<Election>();

        try {
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM election";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int electionID = rs.getInt("electionID");
                String electionTitle = rs.getString("electionTitle");
                String startDate = rs.getString("electionStartDate");
                String endDate = rs.getString("electionEndDate");

                //when it takes the election startDate and endDate it will set its stat automaticlly in the constructor
                Election e = new Election(electionID, electionTitle, startDate, endDate);
                election.add(e);
            }

            rs.close();
        } catch (SQLException e) {
            System.out.println("Error retrieving elections: " + e.getMessage());
        }

        return election;
    }

    //updateing the state of the election in the database
    public void updateElectionState(int electionID, boolean open) {
        try {

            Statement stmt = con.createStatement();
            String sql;
            if (open) {
                sql = "UPDATE election SET state = 1 WHERE electionID = '" + electionID + "'";
            } else {
                sql = "UPDATE election SET state = 1 WHERE electionID = '" + electionID + "'";
            }

            stmt.executeUpdate(sql);

            System.out.println("Election state updated successfully.");

        } catch (SQLException ex) {
            System.err.println("DATABASE UPDATE ERROR: " + ex.toString());
        }
    }

    public void addUser(User u) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("insert into user values('" + u.getName() + "', '" + u.getGender() + "', '" + u.getEmail() + "', '" + u.getNationalID() + "', '" + u.getDateOfBirth() + "', '" + u.getUsername() + "', '" + u.getPassword() + "')");
            System.out.println("User added");
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
    }

    //apply to be voter
    public void applyToBeVoter(Voter v) {
        try {
            Statement stmt = con.createStatement();
            v.addUser(v);
            stmt.executeUpdate("insert into voter values('" + v.getVoterID() + "', '" + v.getUsername() + "', '" + 0 + "', '" + 0 + "')");//since they are still applying the approve value is 0
            System.out.println("Voter added");
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
    }

    //apply to be candidate
    public void applyCandidate(Candidate c, int electionID) {
        try {
            Statement stmt = con.createStatement();
            c.addUser(c);
            stmt.executeUpdate("insert into candidate values('" + c.getCandidateID() + "', '" + c.getPosition() + "', '" + c.getYearsOfexp() + "', '" + c.getUsername() + "', '" + electionID + "', '" + 0 + "')");
            System.out.println("Candidate added");
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
    }

    //update profile
    public void updateProfile(Candidate c) {
        try {
            Statement stmt = con.createStatement();

            String query = "UPDATE user SET name = '" + c.getName()
                    + "', gender = '" + c.getGender()
                    + "', email = '" + c.getEmail()
                    + "', DOB = '" + c.getDateOfBirth()
                    + "', username = '" + c.getUsername()
                    + "', password = '" + c.getPassword()
                    + "' WHERE username = '" + c.getUsername() + "'";

            String updateQuery = "UPDATE candidate SET Position = '" + c.getPosition()
                    + "', yearsOfExp = '" + c.getYearsOfexp()
                    + "' WHERE candidateID = '" + c.getCandidateID() + "'";

            stmt.executeUpdate(updateQuery);
            stmt.executeUpdate(query);
            System.out.println("Candidate information updated");
        } catch (Exception e) {
            System.err.println("DATABASE UPDATE ERROR: " + e.toString());
        }
    }

    //approve the voter's eligbibility (called after checkEligibility is true)
    public void updatVotereApproval(int voterID) {
        try {
            Statement stmt = con.createStatement();
            String sql = "UPDATE voter SET approved = 1 WHERE voterID = '" + voterID + "'";
            stmt.executeUpdate(sql);
            System.out.println("Voter is now approved");
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
    }

    //approve the candidate's eligbibility (called after checkEligibility is true)
    public void updateApprovalCandidate(int candidateID) {
        try {
            Statement stmt = con.createStatement();
            String sql = "UPDATE candidate SET approved = 1 WHERE candidateID = '" + candidateID + "'";
            stmt.executeUpdate(sql);
            System.out.println("Candidate is now approved");
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());

        }
    }

    //create election
    public void createElection(Election e) {
        try {
            Statement stmt = con.createStatement();
            int state;
            //check the election's state
            if (e.getElectionState() instanceof OpenElection) {
                state = 1;
            } else {
                state = 0;
            }
            stmt.executeUpdate("insert into election values('" + e.getElectionID() + "', '" + e.getElectionTitle() + "', '" + e.getElectionStartDate() + "', '" + e.getElectionEndDate() + "', '" + state + "')");
            System.out.println("Election created");
        } catch (Exception ex) {
            System.err.println("DATABASE INSERTION ERROR: " + ex.toString());
        }
    }

    //removing the election
    public void deleteElection(int electionID) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM election WHERE electionID = '" + electionID + "'");
            System.out.println("Election deleted");
        } catch (SQLException ex) {
            System.err.println("DATABASE DELETION ERROR: " + ex.toString());
        }
    }

    //getting the arraylist of participating candidates in a specific election
    //returns olny the approved candidates
    public ArrayList<Candidate> viewParticipatingCandidates(int electionID) {
        ArrayList<Candidate> candidates = new ArrayList<>();

        try {
            String sql = "SELECT DISTINCT c.candidateID, u.name, u.gender, u.email, u.nationalID, u.DOB, u.username, u.password, c.Position, c.yearsOfEXP, c.electionID, c.approved "
                    + "FROM User u "
                    + "JOIN Candidate c ON u.username = c.username "
                    + "WHERE c.approved = 1 AND c.electionID = " + electionID;

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int candidateID = rs.getInt("candidateID");
                String name = rs.getString("name");
                char gender = rs.getString("gender").charAt(0);
                String email = rs.getString("email");
                String nationalID = rs.getString("nationalID");
                String dateOfBirth = rs.getString("DOB");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String position = rs.getString("Position");
                int yearsOfExp = rs.getInt("yearsOfEXP");
                int electionId = rs.getInt("electionID");
                boolean approved = rs.getBoolean("approved");

                // Create Candidate object and add to the list
                ElectionCandidateROI election = getElectionByID(electionId);
                Candidate candidate = new Candidate(candidateID, approved, position, yearsOfExp, election, name, gender, email, nationalID, dateOfBirth, username, password);
                candidates.add(candidate);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error retrieving candidates: " + e.getMessage());
        }

        return candidates;
    }

    //retrive a specific election by its ID
    public Election getElectionByID(int electionID) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from election where electionID = '" + electionID + "'");
            if (rs.first()) {
                Election elc = new Election(rs.getInt("electionID"), rs.getString("electionTitle"), rs.getString("electionStartDate"), rs.getString("electionEndDate"));
                return elc;
            }
        } catch (Exception e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
        }
        return null;
    }

    //get election by name
    public Election getElectionByName(String electionName) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from election where electionTitle = '" + electionName + "'");
            if (rs.first()) {
                Election elc = new Election(rs.getInt("electionID"), rs.getString("electionTitle"), rs.getString("electionStartDate"), rs.getString("electionEndDate"));
                return elc;
            }
        } catch (Exception e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
        }
        return null;
    }

    //voting
    public boolean castVote(int voterID, int candidateID, int electionID) {
        try {
            // Check if the vote already exists
            if (!voteExists(voterID, electionID)) {
                Statement stmt = con.createStatement();
                String insertQuery = "INSERT INTO vote VALUES ('" + voterID + "', '" + candidateID + "', '" + electionID + "', '" + LocalDate.now() + "')";
                stmt.executeUpdate(insertQuery);
                System.out.println("Vote successfully casted.");
                return true;
            } else {
                System.out.println("Vote already exists");
            }
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
        return false;
    }

    //checking that they did not already vote in that election
    private boolean voteExists(int voterID, int electionID) throws Exception {
        Statement stmt = con.createStatement();
        String selectQuery = "SELECT * FROM vote WHERE voterID = '" + voterID + "' AND electionID = '" + electionID + "'";
        ResultSet rs = stmt.executeQuery(selectQuery);
        return rs.next(); // Returns true if a record exists, false otherwise
    }

    //remove Vote
    public boolean removeVote(int voterID, int electionID) {
        try {
            // Check if the vote already exists
            if (voteExists(voterID, electionID)) {
                Statement stmt = con.createStatement();
                String selectQuery = "DELETE FROM vote WHERE voterID = '" + voterID + "' AND electionID = '" + electionID + "'";
                stmt.executeUpdate(selectQuery);
                System.out.println("Vote successfully remove.");
                return true;
            } else {
                System.out.println("You have not voted in this election yet.");
            }
        } catch (Exception e) {
            System.err.println("DATABASE INSERTION ERROR: " + e.toString());
        }
        return false;
    }

    //create event
    public void createEvent(Event event, int candidateID) {
        try {
            Statement stmt = con.createStatement();
            String insertQuery = "INSERT INTO event VALUES ('"
                    + event.getEventID() + "', '"
                    + event.getEventTitle() + "', '"
                    + event.getEventDate() + "', '"
                    + event.getEventStartTime() + "', '"
                    + event.getEventEndTime() + "', '"
                    + event.getEventPrice() + "', '"
                    + event.getEventCapacity() + "', '"
                    + event.getNoOfSeatsAvailable() + "', '"
                    + event.getEventInfo() + "', '"
                    + candidateID + "')";

            stmt.executeUpdate(insertQuery);
            System.out.println("Event created successfully");
        } catch (Exception ex) {
            System.err.println("DATABASE INSERTION ERROR: " + ex.toString());
        }
    }

    //modify event details
    public void modifyEvent(Event event, int candidateID) {
        try {
            Statement stmt = con.createStatement();
            String updateQuery = "UPDATE event SET "
                    + "eventTitle = '" + event.getEventTitle() + "', "
                    + "eventDate = '" + event.getEventDate() + "', "
                    + "startTime = '" + event.getEventStartTime() + "', "
                    + "endTime = '" + event.getEventEndTime() + "', "
                    + "Price = " + event.getEventPrice() + ", "
                    + "totalCapacity = " + event.getEventCapacity() + ", "
                    + "noOfAvailableSeats = " + event.getNoOfSeatsAvailable() + ", "
                    + "description = '" + event.getEventInfo() + "', "
                    + "CandidateID = " + candidateID + " "
                    + "WHERE eventID = " + event.getEventID();

            stmt.executeUpdate(updateQuery);
            System.out.println("Event updated successfully");
        } catch (SQLException ex) {
            System.err.println("DATABASE UPDATE ERROR: " + ex.toString());
        }
    }

    //delete event
    public void deleteEvent(int eventID) {
        try {
            Statement stmt = con.createStatement();
            String deleteQuery = "DELETE FROM event WHERE eventID = " + eventID;

            int rowsAffected = stmt.executeUpdate(deleteQuery);

            if (rowsAffected > 0) {
                System.out.println("Event with ID " + eventID + " deleted successfully");
            } else {
                System.out.println("No event found with ID " + eventID);
            }
        } catch (SQLException ex) {
            System.err.println("DATABASE DELETE ERROR: " + ex.toString());
        }
    }

    //allowing the candidate to view all of thier events
    public ArrayList<Event> viewEvents(int candidateID) {
        ArrayList<Event> events = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM event WHERE CandidateID =" + candidateID);

            while (rs.next()) {
                int eventID = rs.getInt("eventID");
                String eventTitle = rs.getString("eventTitle");
                String eventDate = rs.getString("eventDate");
                String eventStartTime = rs.getString("startTime");
                String eventEndTime = rs.getString("endTime");
                float eventPrice = rs.getFloat("Price");
                int eventCapacity = rs.getInt("totalCapacity");
                int noOfSeatsAvailable = rs.getInt("noOfAvailableSeats");
                String eventInfo = rs.getString("description");

                // Create Event object and add to ArrayList
                Event event = new Event(eventID, eventTitle, eventDate, eventStartTime, eventEndTime, eventPrice, eventCapacity, noOfSeatsAvailable, eventInfo);
                events.add(event);
            }

            rs.close();
        } catch (SQLException ex) {
            System.err.println("DATABASE ERROR: " + ex.toString());
        }

        return events;
    }

    //reserve event
    public void reserveEvent(Reservation r, Voter v) {
        try {
            Statement stmt = con.createStatement();
            String insertQuery = "INSERT INTO reservation VALUES ('"
                    + r.getReservationID() + "', '"
                    + r.getNoOfReservedSeats() + "', '"
                    + r.getEvent().getEventID() + "', '"
                    + v.getVoterID() + "')";

            stmt.executeUpdate(insertQuery);
            System.out.println("Reservation done");
        } catch (Exception ex) {
            System.err.println("DATABASE INSERTION ERROR: " + ex.toString());
        }
    }

    //update noOfSeatsAvailable
    public void updateNoOfSeats(int eventID, int noOfSeats) {
        try {
            Statement stmt = con.createStatement();
            String updateQuery = "UPDATE event SET "
                    + "noOfAvailableSeats = noOfAvailableSeats - " + noOfSeats + " "
                    + "WHERE eventID = " + eventID;

            stmt.executeUpdate(updateQuery);
            System.out.println("Event updated successfully");
        } catch (SQLException ex) {
            System.err.println("DATABASE UPDATE ERROR: " + ex.toString());
        }
    }

    //send message
    public void sendMessage(Message m) {
        try {
            Statement stmt = con.createStatement();
            String insertQuery = "INSERT INTO message VALUES ('"
                    + m.getVoterID() + "', '"
                    + m.getCandidateID() + "', '"
                    + m.getMessageDescription() + "')";

            stmt.executeUpdate(insertQuery);
            System.out.println("Message added successfully");
        } catch (Exception ex) {
            System.err.println("DATABASE INSERTION ERROR: " + ex.toString());
        }
    }

    //function to retrieve messages
    public ArrayList<Message> viewMessages(int candidateID) {
        ArrayList<Message> messages = new ArrayList<Message>();

        try {
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM message where candidateID=" + candidateID;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int vID = rs.getInt("voterID");
                int cID = rs.getInt("candidateID");
                String msgdesc = rs.getString("messagedesc");

                //add message to messages arraylist
                Message m = new Message(vID, cID, msgdesc);
                messages.add(m);
            }

            rs.close();
        } catch (SQLException e) {
            System.out.println("Error retrieving elections: " + e.getMessage());
        }

        return messages;
    }

    //getting the observers
    public ArrayList<Observer> getObservers(int electionID) {
        ArrayList<Observer> observers = new ArrayList<>();
        ArrayList<Voter> voters = getAllVoters();
        ArrayList<Candidate> candidate = viewParticipatingCandidates(electionID);
        observers.addAll(voters);
        observers.addAll(candidate);
        return observers;
    }

    // Retrieve winning candidate and their candidateID
    public String[] getWinningCandidate(int electionID) {
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT u.name, c.candidateID "
                    + "FROM user u "
                    + "JOIN candidate c ON u.username = c.username "
                    + "JOIN vote v ON c.candidateID = v.candidateID "
                    + "WHERE v.electionID = '" + electionID + "' "
                    + "GROUP BY c.candidateID "
                    + "ORDER BY COUNT(*) DESC "
                    + "LIMIT 1";

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                String name = rs.getString("name");
                int candidateID = rs.getInt("candidateID");
                return new String[]{name, Integer.toString(candidateID)};
            }
        } catch (SQLException e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
        }
        return null;
    }

// Save election results into the 'results' table
    public boolean postResults(int electionID) {
        String[] winningCandidateInfo = getWinningCandidate(electionID);
        if (winningCandidateInfo == null) {
            System.out.println("No winning candidate found for electionID: " + electionID);
            return false;
        }

        String name = winningCandidateInfo[0];
        int candidateID = Integer.parseInt(winningCandidateInfo[1]);

        int numVotes = ViewNoOfVotes(candidateID);

        try {
            Statement stmt = con.createStatement();
            // Check if electionID already exists in results table
            String sql1 = "SELECT electionID FROM results WHERE electionID =" + electionID;
            ResultSet existingResults = stmt.executeQuery(sql1);

            if (existingResults.next()) {
                // Election results already exist in the table
                System.out.println("Results for electionID " + electionID + " are already posted.");
                return false;
            }

            String sql = "INSERT INTO results (electionID, candidateName, noOfVotes) VALUES ('" + electionID + "', '" + name + "', " + numVotes + ")";
            stmt.executeUpdate(sql);
            System.out.println("reults posted");
            return true;
        } catch (SQLException e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
            return false;
        }
    }

    //getting the num of votes of a specific candidate
    public int ViewNoOfVotes(int candidateID) {
        try {
            Statement stmt = con.createStatement();
            // SQL query to count the number of votes for a specific candidateID
            String sql = "SELECT candidateID, COUNT(*) AS num_votes "
                    + "FROM vote "
                    + "WHERE candidateID = '" + candidateID + "' "
                    + "GROUP BY candidateID "
                    + "ORDER BY num_votes DESC";

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                int numVotes = rs.getInt("num_votes");
                return numVotes;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
            return 0;
        }
    }

    public ArrayList<String[]> getResults() {
        ArrayList<String[]> resultsList = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT electionID, candidateName, noOfVotes FROM results";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int electionID = rs.getInt("electionID");
                String candidateName = rs.getString("candidateName");
                int noOfVotes = rs.getInt("noOfVotes");

                // Create a string array representing each election result
                String[] resultArray = {String.valueOf(electionID), candidateName, String.valueOf(noOfVotes)};
                resultsList.add(resultArray);
            }
        } catch (SQLException e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
        }

        return resultsList;
    }

    public void update() {
        try {
            Statement stmt = con.createStatement();
            String sql = "UPDATE voter SET notify = 1";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
        }
    }

    public boolean checkAndUpdateNotify(int voterID) {
        boolean isNotifySetToOne = false;

        try {
            Statement stmt = con.createStatement();
            String checkSql = "SELECT COUNT(*) AS count FROM voter WHERE notify = 1 and voterID=" + voterID;
            ResultSet checkRs = stmt.executeQuery(checkSql);

            if (checkRs.next()) {
                int count = checkRs.getInt("count");
                if (count > 0) {
                    isNotifySetToOne = true;

                    // Update all rows to set notify = 0
                    Statement updateStmt = con.createStatement();
                    String updateSql = "UPDATE voter SET notify = 0 where voterID= " + voterID;
                    updateStmt.executeUpdate(updateSql);

                    System.out.println("Notify values updated to 0.");
                }
            }
        } catch (SQLException e) {
            System.err.println("DATABASE QUERY ERROR: " + e.toString());
        }

        return isNotifySetToOne;
    }

}
