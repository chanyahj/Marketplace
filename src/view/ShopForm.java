package view;

import model.Inventory;
import model.ShoppingCart;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ShopForm {
    private JTable userInventoryTbl;
    private JButton addToWishlistButton;
    private JButton addToCartButton1;
    private JPanel myPanel;


    public JPanel getMyPanel() {
        return myPanel;
    }

    public JButton getAddToWishlistButton() {
        return addToWishlistButton;
    }

    public JButton getAddToCartButton1() {
        return addToCartButton1;
    }

    public void viewUserInventory(ArrayList<Inventory> userInventoryList){
        int selectedRow=userInventoryTbl.getSelectedRow();
        String headers[] = {"Name", "Price", "Condition is New", "Stock"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(headers);

        for(Inventory items : userInventoryList)
        {
            model.addRow(new Object[] {items.getName(), items.getPrice(), items.isNew(), items.getHowManyInStock()});
        }
        userInventoryTbl.setModel(model);

    }
    public Inventory moveToWishlist(String username, SellerView view){
        int selectedRow=userInventoryTbl.getSelectedRow();
        String name;
        Double price;
        Boolean condition;
        int stock;
        name=(String) userInventoryTbl.getValueAt(selectedRow,0);
        price= (Double) userInventoryTbl.getValueAt(selectedRow,1);
        condition= (Boolean) userInventoryTbl.getValueAt(selectedRow,2);
        stock= (Integer) userInventoryTbl.getValueAt(selectedRow,3);
        Inventory item=new Inventory(name, price, condition, stock);
        view.addToWishlistTable(item);
        return item;

    }
    public Inventory moveToCart(String username, SellerView view){
        int selectedRow=userInventoryTbl.getSelectedRow();
        String name;
        Double price;
        Boolean condition;
        int stock;
        name=(String) userInventoryTbl.getValueAt(selectedRow,0);
        price= (Double) userInventoryTbl.getValueAt(selectedRow,1);
        condition= (Boolean) userInventoryTbl.getValueAt(selectedRow,2);
        stock= (Integer) userInventoryTbl.getValueAt(selectedRow,3);
        Inventory item=new Inventory(name, price, condition, stock);
       view.addToCartTable(item);
        return  item;
    }
    }

