package view;

import controller.AddItemController;
import controller.ShopController;
import model.Inventory;
import model.InventoryDataEngine;
//import model.Seller;
import model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;

public class SellerView extends JFrame{ //contains both the seller and buyer view
    private JButton addItemButton;
    private JButton updateItemButton;
    private JButton deleteButton;
    private JTable tblInventory;
    private JPanel myPanel, myPanel2;
    private JButton viewButton;
    private JTabbedPane tabbedPane1;
    private JComboBox comboBox1;
    private JTable userTable;
    private JButton viewInventoryButton;
    private JTabbedPane tabbedPane2;
    private JTable wishlistTbl;
    private JButton moveToCartButton;
    private JButton proceedToCheckoutButton;
    private JTable cartTbl;
    private JPanel panel3;
    Inventory item;

    public SellerView(){
        tabbedPane1.addTab("Buyer", myPanel2);

    }

    public JButton getViewInventoryButton() {
        return viewInventoryButton;
    }

    public JButton getMoveToCartButton() {
        return moveToCartButton;
    }

    public JButton getProceedToCheckoutButton() {
        return proceedToCheckoutButton;
    }

    public JPanel getMyPanel() {
        return myPanel;
    }

    public JButton getAddItemButton() {
        return addItemButton;
    }

    public JButton getUpdateItemButton() {
        return updateItemButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JTable getTblInventory() {
        return tblInventory;
    }

    public JButton getViewButton() {
        return viewButton;
    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }

    //Seller view
    public void loadTable(ArrayList<Inventory> inventoryList) //loads the table for the user's inventory in the seller
    {
        String headers[] = {"Name", "Price", "Condition is New", "Stock"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(headers);

        for(Inventory items : inventoryList)
        {
            model.addRow(new Object[] {items.getName(), items.getPrice(), items.isNew(), items.getHowManyInStock()});
        }
        tblInventory.setModel(model);

    }
    public void editRecord(User seller, String username, SellerView view){ //edit method for seller view
        int selectedRow=tblInventory.getSelectedRow();

        String name;
        Double price;
        Boolean condition;
        int stock;

        name=(String) tblInventory.getValueAt(selectedRow,0);
        price= (Double) tblInventory.getValueAt(selectedRow,1);
        condition= (Boolean) tblInventory.getValueAt(selectedRow,2);
        stock= (Integer) tblInventory.getValueAt(selectedRow,3);

        AddItem item=new AddItem(name, price, condition, stock);
       AddItemView newView=new AddItemView(item);

        AddItemController controller=new AddItemController(seller, newView, username,view );
       newView.setVisible(true);
    }
    public void deleteRecord(){ //delete record method for seller view
        DefaultTableModel model = (DefaultTableModel) tblInventory.getModel();
        int selectedRow=tblInventory.getSelectedRow();
       if(selectedRow != -1){
           model.removeRow(selectedRow);
       }
    }
    public void viewData(){ //view data method for seller view
        int selectedRow=tblInventory.getSelectedRow();
        String name;
        Double price;
        Boolean condition;
        int stock;
        name=(String) tblInventory.getValueAt(selectedRow,0);
        price= (Double) tblInventory.getValueAt(selectedRow,1);
        condition= (Boolean) tblInventory.getValueAt(selectedRow,2);
        stock= (Integer) tblInventory.getValueAt(selectedRow,3);

        ViewInventoryData data=new ViewInventoryData(name, price, condition, stock);
        ViewItemDataView newView=new ViewItemDataView(data);
        newView.setSize(250,500);
        newView.setVisible(true);
    }
    public void addItemToTable(Inventory item){
        DefaultTableModel model = (DefaultTableModel) tblInventory.getModel();
        model.addRow(new Object[]{item.getName(), item.getPrice(), item.isNew(), item.getHowManyInStock()});
    }
    //Buyer View
    public void loadUserTable(ArrayList<User> usersList) //user Table
    {
        String headers[] = {"UserName", "First Name", "Email", "Location"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(headers);

        for(User user : usersList)
        {
            model.addRow(new Object[] {user.getUserName(), user.getFirstName(),
                    user.getEmail(), user.getLocation()});
        }
        userTable.setModel(model);

    }

    public void viewUserInventory(SellerView view, String userName){
        int selectedRow=userTable.getSelectedRow();
        String username;
        username=(String) userTable.getValueAt(selectedRow, 0);
       //gets inventory list of the user who username is == to username in selected row
       //   sends list to inventory load inventory table
        ArrayList<Inventory> inventoryArrayList=new ArrayList<>();
        InventoryDataEngine dataEngine=new InventoryDataEngine();
        inventoryArrayList=dataEngine.loadUserInventoryData("inventory.txt",username );
        ShopFormView view1=new ShopFormView();
        ShopController controller=new ShopController(view1, inventoryArrayList, userName,view );

        view1.setVisible(true);


    }



    //wishlist table


public void loadWishlistTable(ArrayList<Inventory> wishlist){ //loads the wishlist table
    String headers[] = {"Name", "Price", "Condition is New", "Stock"};
    DefaultTableModel model = new DefaultTableModel();
    model.setColumnIdentifiers(headers);

    for(Inventory items : wishlist)
    {
        model.addRow(new Object[] {items.getName(), items.getPrice(), items.isNew(), items.getHowManyInStock()});
    }
    wishlistTbl.setModel(model);
}
public Inventory moveToCart(String username){
    int selectedRow=wishlistTbl.getSelectedRow();
    String name;
    Double price;
    Boolean condition;
    int stock;
    name=(String) wishlistTbl.getValueAt(selectedRow,0);
    price= (Double) wishlistTbl.getValueAt(selectedRow,1);
    condition= (Boolean) wishlistTbl.getValueAt(selectedRow,2);
    stock= (Integer) wishlistTbl.getValueAt(selectedRow,3);
    Inventory item=new Inventory(name, price, condition, stock);
    addToCartTable(item);
    return  item;


}

    //shopping cart table
    public void loadCartTable(ArrayList<Inventory> cart){
        String headers[] = {"Name", "Price", "Condition is New"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(headers);

        for(Inventory items : cart)
        {
            model.addRow(new Object[] {items.getName(), items.getPrice(), items.isNew()});
        }
        cartTbl.setModel(model);
    }
    public void addToCartTable(Inventory inventory){
        DefaultTableModel model = (DefaultTableModel) cartTbl.getModel();
        model.addRow(new Object[]{inventory.getName(), inventory.getPrice(), inventory.isNew()});

    }

    public void addToWishlistTable(Inventory item){
        DefaultTableModel model = (DefaultTableModel) wishlistTbl.getModel();
        model.addRow(new Object[]{item.getName(), item.getPrice(), item.isNew(), item.getHowManyInStock()});
    }
    }

