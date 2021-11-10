import java.util.Calendar;

public class Reservation {
    private String datetime;
    private int numOfPax;
    private int tableNum;
    private Customer cust;
    private int reservationID;

    public Reservation(String datetime, int numOfPax, int tableNum, Customer cust) {
        this.datetime = datetime;
        this.cust = cust;
        this.numOfPax = numOfPax;
        this.tableNum = tableNum;
        this.reservationID = Calendar.getInstance().hashCode();
    }

    public int getreservationID(){ return this.reservationID; };
    public int gettableNum(){ return this.tableNum; };

}
