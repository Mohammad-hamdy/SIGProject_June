package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class InvoiceHeaderTableModel extends AbstractTableModel{

    private ArrayList<InvoiceHeader> invoiceHeaderData;
    private String[] cols = {"Id", "Customer Name", "Invoice Date"};
    
    //Contructor 
    public InvoiceHeaderTableModel(ArrayList<InvoiceHeader> data) {
        
        this.invoiceHeaderData= data;
    }
    
    @Override
    //Get the number of row method
    public int getRowCount() {
        return invoiceHeaderData.size();
    }
    //Get the number of row method
    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        InvoiceHeader header = invoiceHeaderData.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return header.getInvoiceNum();
                
            case 1:
                return header.getInvoiceDate();
            case 2:
                return header.getCstName();  
           
        }
        return "";
        
    }
    
    @Override
    public String getColumnName(int column) {
        return cols[column];
    }

    
}
