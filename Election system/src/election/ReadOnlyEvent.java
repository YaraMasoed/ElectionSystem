package election;

import java.util.ArrayList;

/**
 *
 * @author Yara
 */
public interface ReadOnlyEvent {

    public boolean checkAvailability(int noOfSeats);

    public void bookSeats(int eventID, int noOfSeats);

    public void cancelBook(int noOfSeats);

    public int getEventID();

    public ArrayList<Event> viewMyEvents(int CandidateID);

}
