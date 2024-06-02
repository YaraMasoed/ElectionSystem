package election;

import java.util.ArrayList;

/**
 *
 * @author Yara
 */
public interface ReadOnlyMessage {

    public ArrayList<Message> viewMessage(int candidateID);

    public void replyToMessage(int messageID, Message message);

}
