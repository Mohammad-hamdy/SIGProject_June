package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch (e.getActionCommand()) {
            case "Create New Invoice":
                System.out.println("Create New Invoice");
                createNewInv();
                break;
            case "Delete Invoice":
                System.out.println("Delete Invoice");
                deleteInv();
                break;
            case "Create New Item":
                System.out.println("Create New Item");
                createNewItem();
                break;
            case "Delete Item":
                System.out.println("Delete Item");
                deleteItem();
                break;
            case "Load File":
                System.out.println("Load File");
                loadFile();
                break;
            case "Save File":
                System.out.println("Save File");
                saveFile();
                break;    
            
        }
    }

    private void createNewInv() {
    }

    private void deleteInv() {
    }

    private void createNewItem() {
    }

    private void deleteItem() {
    }

    private void loadFile() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void saveFile() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
}
