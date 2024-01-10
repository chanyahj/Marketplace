package view;

import javax.swing.*;
import java.util.concurrent.locks.Condition;

public class ViewInventoryData {
    private JLabel itemLabel;
    private JLabel nameLabel;
    private JLabel nameOfItem;
    private JLabel priceOfItem;
    private JLabel priceLabel;
    private JLabel conditionLabel;
    private JLabel numberInStock;
    private JLabel conditionOfItem;
    private JPanel myPanel;

    public JPanel getMyPanel() {
        return myPanel;
    }
    public ViewInventoryData(){

    }

    public ViewInventoryData(String name, Double price, boolean condition, int stock){
        nameOfItem.setText(name);
        priceOfItem.setText(String.valueOf(price));
        conditionOfItem.setText(String.valueOf(condition));
        numberInStock.setText(String.valueOf(stock));
    }


}
