package model;

import java.util.ArrayList;
import java.util.Date;

public class InvoiceHeader {
    
    private int invoiceNum;
    private Date invoiceDate;
    private String cstName;
    private ArrayList<InvoiceLine> lines;

    public InvoiceHeader(int invoiceNum, Date invoiceDate, String cstName) {
        this.invoiceNum = invoiceNum;
        this.invoiceDate = invoiceDate;
        this.cstName = cstName;
    }

    public String getCstName() {
        return cstName;
    }

    public void setCstName(String cstName) {
        this.cstName = cstName;
    }

    public int getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public ArrayList<InvoiceLine> getLines() {
        return lines;
    }

    public void setLines(ArrayList<InvoiceLine> lines) {
        this.lines = lines;
    }
    
    
    
    
    
}
