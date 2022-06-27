package controller;

import model.InvoiceLineTableModel;
import model.InvoiceHeader;
import model.InvoiceLine;
import view.InvHeaderDialog;
import view.InvLineDialog;
import view.SIGFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MyController implements ActionListener, ListSelectionListener {

    private SIGFrame frame;
    private SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    private FileOperations fileOperations;

    public MyController(SIGFrame frame) {
        this.frame = frame;
        this.fileOperations = new FileOperations(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("L")) {
            try {
                fileOperations.loadFiles();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getActionCommand().equals("S")) {
            fileOperations.saveData();
        } else if (e.getActionCommand().equals("CreateInv")) {
            newInv();
        } else if (e.getActionCommand().equals("DeleteInv")) {
            deleteInv();
        } else if (e.getActionCommand().equals("InsertItem")) {
            insertItemBtn();
        } else if (e.getActionCommand().equals("DeleteChanges")) {
            deleteChanges();
        } else if (e.getActionCommand().equals("creatInvOK")) {
            creatInvOK();
        } else if (e.getActionCommand().equals("creatInvCancel")) {
            creatInvCancel();
        } else if (e.getActionCommand().equals("creatLineOK")) {
            creatLineOK();
        } else if (e.getActionCommand().equals("creatLineCancel")) {
            creatLineCancel();
        }

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        headerTableRowSelected();
    }

    private void newInv() {
        frame.setHeaderDialog(new InvHeaderDialog(frame));
        frame.getHeaderDialog().setVisible(true);

    }


    private void deleteInv() {
        int invIndex = frame.getHeaderTable().getSelectedRow();
        InvoiceHeader header = frame.getHeaderTableModel().getData().get(invIndex);
        frame.getHeaderTableModel().getData().remove(invIndex);
        frame.getHeaderTableModel().fireTableDataChanged();
        frame.setInvLineModel(new InvoiceLineTableModel(new ArrayList<InvoiceLine>()));
        frame.getLineTable().setModel(frame.getLineTableModel());
        frame.getLineTableModel().fireTableDataChanged();
        frame.getCustNameTF().setText("");
        frame.getInvDateTF().setText("");
        frame.getInvNumLbl().setText("");
        frame.getInvTotalLbl().setText("");
        displayInvoices();
    }

    private void insertItemBtn() {
        frame.setLineDialog(new InvLineDialog(frame));
        frame.getLineDialog().setVisible(true);
    }
    
        public void deleteChanges() {
        int indexrow = frame.getLineTable().getSelectedRow();
        if (indexrow >= 0) {
            frame.getLineTableModel().removeRow(indexrow);
            frame.getLineTableModel().fireTableDataChanged();
        }
    }
    
    private void headerTableRowSelected() {
        int selectedRowIndex = frame.getHeaderTable().getSelectedRow();
        if (selectedRowIndex >= 0) {

            InvoiceHeader row = frame.getHeaderTableModel().getData().get(selectedRowIndex);
            frame.getCustNameTF().setText(row.getCusName());
            //frame.getInvDateTF().setText(row.getInvDate().toString());
            frame.getInvDateTF().setText(df.format(row.getInvDate()));
            frame.getInvNumLbl().setText("" + row.getInvNum());
            frame.getInvTotalLbl().setText("" + row.getInvTotal());
            ArrayList<InvoiceLine> lines = row.getLines();
            frame.setInvLineModel(new InvoiceLineTableModel(lines));
            frame.getLineTable().setModel(frame.getLineTableModel());
            frame.getLineTableModel().fireTableDataChanged();
        }
    }

    private void creatInvOK() {
        String cusName = frame.getHeaderDialog().getCusNameField().getText();
        String invDateStr = frame.getHeaderDialog().getInvDateField().getText();
        Date invDate = new Date();
        try {
            invDate = df.parse(invDateStr);
        } catch (ParseException ex) {

        }
        frame.getHeaderDialog().setVisible(false);
        int num = getMaxInvNum() + 1;
        InvoiceHeader newInvHeader = new InvoiceHeader(num, cusName, invDate);
        frame.getFilesData().add(newInvHeader);
        frame.getHeaderTableModel().fireTableDataChanged();
        System.out.println("check");
    }

    private int getMaxInvNum() {
        int num = 0;
        for (InvoiceHeader header : frame.getFilesData()) {
            if (header.getInvNum() > num) {
                num = header.getInvNum();
            }
        }
        return num;
    }

    private void creatInvCancel() {
        frame.getHeaderDialog().setVisible(false);
        frame.getHeaderDialog().dispose();
        frame.setHeaderDialog(null);
    }

    private void creatLineOK() {
        String itemName = frame.getLineDialog().getItemNameField().getText();
        String itemCountStr = frame.getLineDialog().getItemCountField().getText();
        String itemPriceStr = frame.getLineDialog().getItemPriceField().getText();

        int itemCount = Integer.parseInt(itemCountStr);
        double itemPrice = Double.parseDouble(itemPriceStr);
        frame.getLineDialog().setVisible(false);
        InvoiceHeader header = frame.getFilesData().get(frame.getHeaderTable().getSelectedRow());
        InvoiceLine line = new InvoiceLine(itemName, itemPrice, itemCount, header);
        header.addLine(line);

        frame.getLineTableModel().fireTableDataChanged();

    }

    private void creatLineCancel() {
        frame.getLineDialog().setVisible(false);
        frame.getLineDialog().dispose();
        frame.setLineDialog(null);
    }

    
        private void displayInvoices() {
        System.out.println("_____________________________________________");
        for (InvoiceHeader header : frame.getFilesData()) {
            System.out.println(header);
        }
        System.out.println("ـــــــــــــــــــــــــــــــــــــــــــــ");
    }
}
