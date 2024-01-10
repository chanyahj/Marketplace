package view;

import model.Inventory;

import javax.swing.*;

public class AddItem {
    private JTextField nameOfItemField;
    private JTextField priceOfItemField;
    private JTextField stockNumberField;
    private JRadioButton newRadioButton;
    private JRadioButton usedRadioButton;
    private JButton addItemButton;
    private JPanel myPanel;

      public AddItem(){

      }

    public JTextField getNameOfItemField() {
        return nameOfItemField;
    }

    public JTextField getPriceOfItemField() {
        return priceOfItemField;
    }

    public JTextField getStockNumberField() {
        return stockNumberField;
    }

    public JRadioButton getNewRadioButton() {
        return newRadioButton;
    }

    public JRadioButton getUsedRadioButton() {
        return usedRadioButton;
    }

    public JButton getAddItemButton() {
        return addItemButton;
    }

    public JPanel getMyPanel() {
        return myPanel;
    }


    public AddItem(String name, Double price, boolean condition, int stock){
            nameOfItemField.setText(name);
            priceOfItemField.setText(String.valueOf(price));
            stockNumberField.setText(String.valueOf(stock));

    }
    public void addtoTable(Inventory item, SellerView view){
          view.addItemToTable(item);
    }

}


