package controller;

import model.Inventory;
//import model.Seller;
import model.User;
import view.AddItem;
import view.AddItemView;
import view.SellerFormView;
import view.SellerView;

import javax.swing.*;
import java.util.List;

public class AddItemController {
    private Inventory item;

    private User seller;
    private AddItemView view;
    public AddItemController(User seller, AddItemView view, String username, SellerView view2){
        Inventory item=new Inventory();
        this.seller=seller;
        this.view=view;

        AddItem form=view.getForm();

        form.getAddItemButton().addActionListener(e -> { //when the Add Item button is clicked in AddItem view
            //Name of Item
            String nameOfItem=form.getNameOfItemField().getText(); //assigns value of the text field to the name variable
            if(isValidField(nameOfItem)) {
                item.setName(nameOfItem); //sets item name to nameOfItem
            }
            else {
                JOptionPane.showMessageDialog(view, "Please enter the name of item");
                return;
            }

            //Price of Item
            String priceOfItem=form.getPriceOfItemField().getText(); //assigns value of text field to price variable
              if(isValidField(priceOfItem)){
                item.setPrice(Double.valueOf(priceOfItem)); //sets price of item to the text field input
            }else{
                JOptionPane.showMessageDialog(view, "Please enter the price of the item");
                return;
            }

            //Stock
            String numberOfItems=form.getStockNumberField().getText(); //assigns value of text field to numItems variable
            if(isValidField(numberOfItems)) {
                item.setHowManyInStock(Integer.valueOf(numberOfItems)); //sets stock of item to text field input
            }
            else {
                JOptionPane.showMessageDialog(view, "Please enter how many items is in stock");
                return;
            }
            //Condition
            if(form.getNewRadioButton().isSelected()){ //if new is selected

                item.setNew(true); //sets boolean of if the condition is new to true
            }
            if(form.getUsedRadioButton().isSelected()){ //is used is selected

                item.setNew(false); //sets boolean of it the condition is used to false

            }
            view2.addItemToTable(item);
            seller.addItem(item); //adds the item to seller
            seller.writeToInventoryFile(username,item); //adds the item to the inventory.txt file


//            SellerFormView view1=new SellerFormView(); //initliazes SellerFormView
//            User seller2=new User(); //initialize a new User
//            SellerController controller=new SellerController(view1, seller2,username); //passes in view, user, and username into the SellerController
//            view1.setSize(1000,1000);
//            view1.setLocationRelativeTo(null);
//            view1.setVisible(true);
//            view.dispose();
        });



    }
    public static boolean isValidField(String field){
        return !field.isBlank();
    }
}
