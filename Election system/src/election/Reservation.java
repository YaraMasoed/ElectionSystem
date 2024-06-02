package election;

/**
 *
 * @author Yara
 */
public class Reservation {

    private int reservationID;
    private ReadOnlyEvent event;
    private int noOfReservedSeats;
    private Payment pay;

    public Reservation() {
        event = new Event();
    }

    public Reservation(int reservationID, int noOfReservedSeats, ReadOnlyEvent event) {
        this.reservationID = reservationID;
        this.event = event;
        this.noOfReservedSeats = noOfReservedSeats;
        this.pay = new Payment();
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public ReadOnlyEvent getEvent() {
        return event;
    }

    public void setEvent(ReadOnlyEvent event) {
        this.event = event;
    }

    public int getNoOfReservedSeats() {
        return noOfReservedSeats;
    }

    public void setNoOfReservedSeats(int noOfReservedSeats) {
        this.noOfReservedSeats = noOfReservedSeats;
    }

    public Payment getPay() {
        return pay;
    }

    public void setPay(Payment pay) {
        this.pay = pay;
    }

    public boolean makeReservation(Voter v) {
        if (event.checkAvailability(noOfReservedSeats)) {
            DB.getDatabase().reserveEvent(this, v);//saving in the database
            event.bookSeats(event.getEventID(), noOfReservedSeats);
            return true;
        } else {
            return false;
        }
    }

}
