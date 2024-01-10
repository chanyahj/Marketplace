package model;

import model.Inventory;
import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
  *Wallet function
  * @param card balance, cardNumber, cvcCode, expDate
  * Wishlist List<>
  *remove and add from Wishlist functions
  * file to store buyer Wishlist items
 */
public class Buyer extends User {
    List<Inventory> wishList = new ArrayList<>();
    List<Inventory> cart=new ArrayList<>();
    private double balance;
    private long cardNumber;
    private int cvcCode;
    private int expDate;

    public Buyer() {
    }

    public Buyer(double balance, long cardNumber, int cvcCode, int expDate) {
        this.balance = balance;
        this.cardNumber = cardNumber;
        this.cvcCode = cvcCode;
        this.expDate = expDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvcCode() {
        return cvcCode;
    }

    public void setCvcCode(int cvcCode) {
        this.cvcCode = cvcCode;
    }

    public int getExpDate() {
        return expDate;
    }

    public void setExpDate(int expDate) {
        this.expDate = expDate;
    }

    public List<Inventory> getWishList() {
        return wishList;
    }

    public void addToWishlist(Inventory item) {
        wishList.add(item);
    }

    public void removeFromWishlist(Inventory item) {
        wishList.remove(item);
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
    public double calculateTotal(ArrayList<Inventory> cart){
        //adds up items in cart prices
        double total=0.0;
        for(int i=0;i<cart.size();i++){
            total+=getItemPrice(cart.get(i));
        }
        return total;
    }
    public String isPurchaseSuccesful(double balance, ArrayList<Inventory> cart){
        //determine if purchase is successful
        if(balance<calculateTotal(cart)){
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
            //writer.println(calculateTotal());
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

    public void writeWishlistFile() {
        try (
                PrintWriter writer = new PrintWriter(new File("wishlist.txt"))) {
           writer.println(getFirstName() + "'s Wishlist:");
            for (Inventory item : wishList) {
                writer.println(item);
            }

        } catch (FileNotFoundException fne) {
            System.out.println("Problem writing to file");
        }
    }
    public void writeToWishlistFile(Inventory item){

        try(FileWriter f = new FileWriter("wishlist.txt", true);
            BufferedWriter b=new BufferedWriter(f);
            PrintWriter p=new PrintWriter(b)){
            p.println(item);

        }catch (IOException fne){

        }
    }

    public void readFile() {
        try (Scanner scan = new Scanner(new File("wishlist.txt"))) {
            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }
        } catch (FileNotFoundException fne) {
            System.out.println("Problem reading from file");
        }
    }

    @Override
    public String toString() {
        return wishList.toString();
    }
}



