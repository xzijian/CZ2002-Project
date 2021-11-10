import Entities.Customer;
import Entities.Reservation;
import Entities.Tables;

import java.util.Date;

public class ReservationMgr {

    public void createReservation(Date date, Date time , int pax, int tableNum, Customer customer) {
        Reservation reservation = new Reservation(date, time , pax, tableNum, customer);


    }

}
