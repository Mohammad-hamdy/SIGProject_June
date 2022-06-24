package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class InvoiceLineTableModel extends AbstractTableModel{
    
    private ArrayList<InvoiceLine> invoiceLineData;
    private String[] invoiceItemsCols = {"Item Name", "Unit Price", "Count"};

    public InvoiceLineTableModel(ArrayList<InvoiceLine> invoiceLineData) {
        this.invoiceLineData = invoiceLineData;
    }
    
    
    @Override
    public int getRowCount() {
        return invoiceLineData.size();
    }

    @Override
    public int getColumnCount() {
        return invoiceItemsCols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceLine line = invoiceLineData.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return line.getItemName();
            case 1:
                return line.getCount(); 
            case 2:
                return line.getPrice();    
        }
        return "";
    }
    
    @Override
    public String getColumnName(int column) {
        return invoiceItemsCols[column];
    }
    
    
}
