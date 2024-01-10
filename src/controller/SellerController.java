package controller;

import model.*;
import view.*;

import java.util.ArrayList;

public class SellerController {
private SellerFormView view;
private User seller;
private ArrayList<Inventory> items;
private Inventory item;
private ArrayList<User> users;
ShoppingCart cart=new ShoppingCart();

public SellerController(SellerFormView view, User seller, String username){

    SellerView form=  view.getForm();

    //load inventory table in seller view
    InventoryDataEngine inventoryDataEngine=new InventoryDataEngine(); //initializes inventoryDataEngine
    items=inventoryDataEngine.loadUserInventoryData("inventory.txt", username); //loads the inventory for the specific username passed through
    form.loadTable(items); //loads table for the seller inventory

    //???
    UserDataEngine userDataEngine = new UserDataEngine();
    users = userDataEngine.loadUserData("users.txt");
    form.loadUserTable(users);

    //User table in buyer view
    UserDataEngine userDataEngine2 = new UserDataEngine(); //initializes buyer engine
    users = userDataEngine2.loadUserData("users.txt"); //loads the user.txt data into a User arrayList
    form.loadUserTable(users); //loads User table

    //load wishlist table in buyer view
    InventoryDataEngine wishlistData=new InventoryDataEngine();
    items=wishlistData.loadUserInventoryData("wishlist.txt", username); //loads wishlist data for specific arrayList into Inventory arrayList
    form.loadWishlistTable(items); //loads Wishlist table

    //load cart table in buyer view
    InventoryDataEngine cartData=new InventoryDataEngine();
    items=cartData.loadUserInventoryData("receipt.txt", username); //loads receipt data for specific arrayList into Inventory arrayList
    form.loadCartTable(items); //loads Cart Table

    //Seller view buttons
        form.getAddItemButton().addActionListener(e -> { //when the Add Item in button view is clicked
            Inventory item=new Inventory(); //initializes new Item
        AddItemView newView=new AddItemView(); //creates new AddItemView
        AddItemController controller=new AddItemController( seller, newView, username, form);//passes in the User, the AddItemView, and the username

            newView.setSize(500,500);
            newView.setLocationRelativeTo(null);
            newView.setVisible(true);
        newView.setVisible(true);
          //  view.dispose(); //closes SellerView ----Might change



        });

        form.getUpdateItemButton().addActionListener(e -> { //when Update Item button is clicked
            form.editRecord(seller, username, form); //calls the editRecord method to load the Edit view


        });

        form.getDeleteButton().addActionListener(e -> { //when Delete Item button is clicked
            form.deleteRecord(); //calls the deleteRecord method to delete the selected row
        });
        form.getViewButton().addActionListener(e -> { //when View button is clicked
           form.viewData(); //calls the viewData method to view the data of the selected item
        });

        //Buyer view buttons
        form.getViewInventoryButton().addActionListener(e -> { //when ViewInventory button is clicked
            form.viewUserInventory(view.getForm(), username); //calls the viewUserInventory and loads the inventory for selected user
            ArrayList<Inventory> newItems=new ArrayList<>();

            InventoryDataEngine cartData2=new InventoryDataEngine();
            newItems=cartData2.loadUserInventoryData("receipt.txt", username); //loads receipt data for specific arrayList into Inventory arrayList
            form.loadCartTable(newItems); //loads Cart Table



        });
        form.getMoveToCartButton().addActionListener(e -> { //when the moveToCart button is clicked
            Inventory item=form.moveToCart(username); //intilizes a new item to to the item selected to move to the cart
            cart.writeToReceiptFile(username, item); //writes the item to the receipt of the specific user and adds it to the cart

        });

        form.getProceedToCheckoutButton().addActionListener(e -> { //when the Proceed to checkout button is clicked
            ShoppingCartView view1=new ShoppingCartView(); //initializes a new ShoppingCartView
            Buyer buyer=new Buyer(); //initializes a new Buyer
            ShoppingCartController cartController=new ShoppingCartController(buyer, view1, username); //loads controller for the shopping cart
            view1.setSize(1000,1000);
            view1.setLocationRelativeTo(null);
            view1.setVisible(true);
        });




}

}
