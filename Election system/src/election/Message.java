package election;

import java.util.ArrayList;

/**
 *
 * @author Yara
 */
public class Message implements ReadOnlyMessage {

    private int voterID;
    private int candidateID;
    private String messageDescription;

    public Message() {

    }

    // Constructor
    public Message(int voterD, int candidateID, String messageDescription) {
        this.voterID = voterD;
        this.candidateID = candidateID;
        this.messageDescription = messageDescription;
    }

    // Getter and Setter
    public int getVoterID() {
        return voterID;
    }

    public void setVoterID(int voterID) {
        this.voterID = voterID;
    }

    public int getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(int candidateID) {
        this.candidateID = candidateID;
    }

    public String getMessageDescription() {
        return messageDescription;
    }

    public void setMessageDescription(String messageDescription) {
        this.messageDescription = messageDescription;
    }

    // Method to send a message
    public void sendMessage() {
        DB.getDatabase().sendMessage(this);
    }

    @Override
    public ArrayList<Message> viewMessage(int candidateID) {
        return DB.getDatabase().viewMessages(candidateID);
    }

    // Method to reply to a message
    @Override
    public void replyToMessage(int messageID, Message message) {

    }

}
