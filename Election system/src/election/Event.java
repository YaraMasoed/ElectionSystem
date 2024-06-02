package election;

import java.util.ArrayList;

/**
 *
 * @author Yara
 */
public class Event implements ReadOnlyEvent {

    private int eventID;

    private String eventTitle;

    private String eventDate;

    private String eventStartTime;

    private String eventEndTime;

    private float eventPrice;

    //how many people can attend the event
    private int eventCapacity;

    //how many seats are left
    private int noOfSeatsAvailable;

    private String eventInfo;

    public Event() {
    }

    // Constructor
    public Event(int eventID, String eventTitle, String eventDate,
            String eventStartTime, String eventEndTime, float eventPrice, int eventCapacity, int noOfSeatsAvailable, String eventInfo) {
        this.eventID = eventID;
        this.eventTitle = eventTitle;
        this.eventDate = eventDate;
        this.eventStartTime = eventStartTime;
        this.eventEndTime = eventEndTime;
        this.eventPrice = eventPrice;
        this.eventCapacity = eventCapacity;
        this.noOfSeatsAvailable = noOfSeatsAvailable;
        this.eventInfo = eventInfo;
    }

    //Setters and Getters
    @Override
    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(String eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public String getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(String eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public float getEventPrice() {
        return eventPrice;
    }

    public void setEventPrice(float eventPrice) {
        this.eventPrice = eventPrice;
    }

    public int getEventCapacity() {
        return eventCapacity;
    }

    public void setEventCapacity(int eventCapacity) {
        this.eventCapacity = eventCapacity;
    }

    public int getNoOfSeatsAvailable() {
        return noOfSeatsAvailable;
    }

    public void setNoOfSeatsAvailable(int noOfSeatsAvailable) {
        this.noOfSeatsAvailable = noOfSeatsAvailable;
    }

    public String getEventInfo() {
        return eventInfo;
    }

    public void setEventInfo(String eventInfo) {
        this.eventInfo = eventInfo;
    }

    //Create Events method
    public void createEvent(Event event, int candidateID) {
        DB.getDatabase().createEvent(event, candidateID);
    }

    // delete event details
    public void deleteEvent(int eventID) {
        DB.getDatabase().deleteEvent(eventID);
    }

    //modify Events method
    public void modifyEvent(Event event, int CandidateID) {
        DB.getDatabase().modifyEvent(event, CandidateID);
    }

    @Override
    public boolean checkAvailability(int noOfSeats) {
        if (noOfSeatsAvailable <= noOfSeats) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void bookSeats(int eventID, int noOfSeats) {
        DB.getDatabase().updateNoOfSeats(eventID, noOfSeats);
        noOfSeatsAvailable -= noOfSeats;
    }

    @Override
    public void cancelBook(int noOfSeats) {
        noOfSeatsAvailable += noOfSeats;
    }

    //get the specific candidate's events
    @Override
    public ArrayList<Event> viewMyEvents(int CandidateID) {
        return DB.getDatabase().viewEvents(CandidateID);
    }

}
