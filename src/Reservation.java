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
        // add customer object
        // generate random reservation id
    }

}
