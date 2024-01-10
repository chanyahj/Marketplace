package controller;

import model.Buyer;
import model.Inventory;
import model.InventoryDataEngine;
import view.ShoppingCartForm;
import view.ShoppingCartView;

import javax.swing.*;
import java.util.ArrayList;

public class ShoppingCartController {
        private Buyer buyer;
        private ShoppingCartView view;
        ArrayList<Inventory> cart;

        public ShoppingCartController(Buyer buyer, ShoppingCartView view, String username){
            ShoppingCartForm form= view.getForm();
            InventoryDataEngine cartData=new InventoryDataEngine();
            cart=cartData.loadUserInventoryData("receipt.txt", username); //returns an arraylist of items in receipt.txt file
                                                                    // and adds them to the cart
            form.loadCheckout(cart); //calls method to load checkout table
            form.setTotalPriceLabel(String.valueOf(buyer.calculateTotal(cart))); //calculates total of items and sets the price label to the total
            form.getConfirmPurchaseButton().addActionListener(e -> { //if confirmed purchase button is selected
                JOptionPane.showMessageDialog(view, "Purchase Complete"); //sends message that the purchase is complete
            });
        }
}
