package view;

import model.Inventory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ShoppingCartForm {
    private JButton confirmPurchaseButton;
    private JTable checkoutTable;
    private JLabel totalPriceLabel;
    private JPanel myPanel;
    private JLabel totalofItemsLabel;

    public JButton getConfirmPurchaseButton() {
        return confirmPurchaseButton;
    }

    public JPanel getMyPanel() {
        return myPanel;
    }

    public void setTotalPriceLabel(String label) {
        totalofItemsLabel.setText(label);
    }

    public void loadCheckout(ArrayList <Inventory> cart){
            String headers[] = {"Name", "Price", "Condition is New"};
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(headers);

            for(Inventory items : cart)
            {
                model.addRow(new Object[] {items.getName(), items.getPrice(), items.isNew()});
            }

            checkoutTable.setModel(model);
        }

    }


