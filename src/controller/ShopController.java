package controller;

import model.*;
import view.*;

import java.util.ArrayList;

public class ShopController {
   private ShopFormView view;
   private ArrayList<Inventory> usersInventoryList;
   ShoppingCart cart=new ShoppingCart();
    Inventory item;
    ArrayList<Inventory> items;



   public ShopController(ShopFormView view, ArrayList<Inventory> usersInventoryList, String userName, SellerView view2){
       ShopForm form= view.getForm();
       InventoryDataEngine inventoryDataEngine=new InventoryDataEngine();
       form.viewUserInventory(usersInventoryList); //calls viewUserInventory to view the inventory of selected user

       form.getAddToWishlistButton().addActionListener(e -> {

         item= form.moveToWishlist(userName, view2); //calls moveToWishlist method to move selected item in selected user inventory to wishlist
           item.writeToWishlistFile(userName, item);
       });
       form.getAddToCartButton1().addActionListener(e -> {
       item =form.moveToCart(userName,view2); //calls moveToCart method to get selected item in selected user inventory
        cart.writeToReceiptFile(userName, item);

       });


       }
        public  Inventory addNewItem(){
            return item;

   }

}
