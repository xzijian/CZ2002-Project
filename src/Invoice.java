import java.util.Calendar;

public class Invoice {
    private Order order;
    private double price;
    private double gst;
    private double totalPrice;
    private Calendar date;
    private int invoiceNumber;

    public Invoice(Order order){
        this.order = order;
        this.invoiceNumber = Calendar.getInstance().hashCode();
    }

    public void printInvoice(){
        System.out.println("Date & Time: " + this.order.getDateTime());
        System.out.println("Invoice Number: " + this.invoiceNumber);
        System.out.println("Items ordered: " + this.order);
        System.out.println("Subtotal: " + price);
        System.out.println("GST: " + gst);
        System.out.println("Total: " + totalPrice);
    }
}

