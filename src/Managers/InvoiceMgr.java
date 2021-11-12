package Managers;
import Entities.Restaurant;
import Entities.Invoice;
import Entities.MenuItems;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class InvoiceMgr {
    private static ArrayList<Invoice> invoices = Restaurant.invoices;

    public static void printSalesRevenue(){
        int day1, month1, year1, day2, month2, year2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter date to start (in format DD MM YYYY");
        day1 = sc.nextInt();
        month1 = sc.nextInt();
        year1 = sc.nextInt();
        System.out.println("Enter date till (in format DD MM YYYY");
        day2 = sc.nextInt();
        month2 = sc.nextInt();
        year2 = sc.nextInt();
        double rev = getSalesRevenue(day1,month1,year1,day2,month2,year2);
        System.out.println("Total sales during this period = " + rev);
    }

    public static double getSalesRevenue(int day1, int month1, int year1, int day2, int month2, int year2){
        double total = 0;
        int start = 0,end = 0;
        int j = 0;
        int k = 0;
        for (Invoice i: invoices) {
            if ((i.getDate().get(Calendar.DAY_OF_MONTH) == day1) & (i.getDate().get(Calendar.MONTH) + 1 == month1) && (i.getDate().get(Calendar.YEAR) == year1))
            start = j;
            if ((i.getDate().get(Calendar.DAY_OF_MONTH) == day2) & (i.getDate().get(Calendar.MONTH) + 1 == month2) && (i.getDate().get(Calendar.YEAR) == year2))
                end = k;
            j++;
            k++;
        }

        for (int l = start; l <= end; l++){
            total += invoices.get(l).getTotalPrice();
        }
        double twoDP = Math.round((total*1000.00)/1000.0);
        return twoDP;
    }
}
