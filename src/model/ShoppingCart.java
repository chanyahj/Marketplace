package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * method to allow buyer to take item from wishlist and add it to cart then remove item from wishlist
 * method to calculate total
 * boolean method to determine if transaction cleared
 * takes money from model.Buyer balance
 * decreases stock for item if purchase is successful
 * writes purchase history to file
 *
 */

public  class ShoppingCart extends User {

    List<Inventory> cart=new ArrayList<>();

    public ShoppingCart(){}

    public ShoppingCart(List<Inventory> cart){
        this.cart=cart;
    }

    public List<Inventory> getCart() {
        return cart;
    }

    public void setCart(List<Inventory> cart) {
        this.cart = cart;
    }

    public void addToCart(Inventory item){
        cart.add(item);
    }

    public void addItemToCartFromWishlist(Inventory item){
        //Gets item from wishlist and adds it to shopping cart and removes it from wishlist
        cart.add(item);
        wishList.remove(item);
    }
    public double getItemPrice(Inventory item){
        return item.getPrice();
    }
    public double calculateTotal(){
        //adds up items in cart prices
        double total=0.0;
        for(int i=0;i<cart.size();i++){
            total+=getItemPrice(cart.get(i));
        }
        return total;
    }



    public String isPurchaseSuccesful(double balance){
        //determine if purchase is successful
        if(balance<calculateTotal()){
            return "Transaction declined";
        }
        else{
            return "Transaction is a success!";
        }
    }
    public void writeReceiptFile(){
        try(
                PrintWriter writer= new PrintWriter(new File("receipt.txt"))){
            writer.println(getFirstName()+"'s Receipt:");
            for(Inventory item: cart) {
                writer.println(item);
            }
            writer.println(calculateTotal());
        }catch (FileNotFoundException fne){
            System.out.println("Problem writing to file");
        }
    }
    public void readReceiptFile() {


        try (Scanner scan = new Scanner(new File("receipt.txt"))) {
            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }
        }
        catch (FileNotFoundException fne){
            System.out.println("Problem reading from file");
        }
    }
    public void writeToReceiptFile(String userName, Inventory item){

        try(FileWriter f = new FileWriter("receipt.txt", true);
            BufferedWriter b=new BufferedWriter(f);
            PrintWriter p=new PrintWriter(b)){
            p.println(userName+","+item);

        }catch (IOException fne){

        }
    }
    @Override
    public String toString() {
        return "The total is "+calculateTotal();
    }
}


