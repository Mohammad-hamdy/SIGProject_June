package model;

public class InvoiceLine {
    
    private InvoiceHeader invoice;
    private String itemName;
    private double price;
    private int count;

    public InvoiceLine(InvoiceHeader invoice, String itemName, double price, int count) {
        this.invoice = invoice;
        this.itemName = itemName;
        this.price = price;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public InvoiceHeader getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceHeader invoice) {
        this.invoice = invoice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
     
    
    
}
