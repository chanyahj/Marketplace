package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
* @param username, password, firstname, lastname, studentID, email, boolean onCampus
* if onCampus=true allows user to choose from @enum East,West,South,North,EastView,Nittany, White-Course
* method to write model.User data to file
* method to read model.User data from file
 */
public class User {

    private String userName;
    private String password;
    private String firstName;
    private String lastname;
    private int studentID;
    private String email;

    private String location;

    ArrayList<Inventory> itemList=new ArrayList<>();
    List<Inventory> wishList = new ArrayList<>();

    public User(){}
    public User(String userName, String password, String firstName, String lastname, int studentID,
                String email, String location){
       this.userName=userName;
       this.password=password;
       this.firstName=firstName;
       this.lastname=lastname;
       this.studentID=studentID;
       this.email=email;

       this.location=location;
    }
        //Getters
    public String getUserName() {
        return userName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getEmail() {return email;}



    //Setters

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setEmail(String email) {
        this.email = email;
    }




    //Write to File Method
        public void writeFile(){
        try(
            PrintWriter writer= new PrintWriter(new File("users.txt"))){
            writer.println(getUserName()
                    +","+getPassword()+","+getFirstName()+","+getLastname()+
                    ","+getStudentID()+","+getEmail()+ ","+getLocation());
            }catch (FileNotFoundException fne){
            System.out.println("Problem writing to file");
        }
        }

        //data persistance for users.txt
        //called from Login Controller method and adds new user to users.txt
    public void writeToFile(){

        try(FileWriter f = new FileWriter("users.txt", true);
            BufferedWriter b=new BufferedWriter(f);
            PrintWriter p=new PrintWriter(b)){
            p.println(getUserName()
                    +","+getPassword()+","+getFirstName()+","+getLastname()+
                    ","+getStudentID()+","+getEmail()+ ","+getLocation());

        }catch (IOException fne){

        }
    }

        //Read from File Method
        public void readFile() {


            try (Scanner scan = new Scanner(new File("users.txt"))) {
                while (scan.hasNextLine()) {
                    System.out.println(scan.nextLine());
                }
            }
            catch (FileNotFoundException fne){
                System.out.println("Problem reading from file");
            }
        }

        //seller model methods, the seller is always the user

    public ArrayList<Inventory> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<Inventory> itemList) {
        this.itemList = itemList;
    }

    public void addItem(Inventory item){
        itemList.add(item);
    }
    public void deleteItem(Inventory item){
        itemList.remove(item);
    }


    public void writeInventoryFile(){
        try(
                PrintWriter writer= new PrintWriter(new File("inventory.txt"))){
            writer.println( "Inventory:");
            for(Inventory item: itemList){
                writer.println(item);
            }

        }catch (FileNotFoundException fne){
            System.out.println("Problem writing to file");
        }
    }
    //called from AddItemController and adds new item to inventory.txt
    public void writeToInventoryFile(String username, Inventory item){

        try(FileWriter f = new FileWriter("inventory.txt", true);
            BufferedWriter b=new BufferedWriter(f);
            PrintWriter p=new PrintWriter(b)){
            p.println(username+","+item);

        }catch (IOException fne){

        }
    }
    public void readInventoryFile() {

        try (Scanner scan = new Scanner(new File("inventory.txt"))) {
            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }
        }
        catch (FileNotFoundException fne){
            System.out.println("Problem reading from file");
        }
    }
    //Buyer
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
    public void writeToWishlistFile(String userName, Inventory item){

        try(FileWriter f = new FileWriter("wishlist.txt", true);
            BufferedWriter b=new BufferedWriter(f);
            PrintWriter p=new PrintWriter(b)){
            p.println(userName+","+item);

        }catch (IOException fne){

        }
    }


    @Override
    public String toString() {
        return "UserName: "+ userName+", Password: "+password+", FirstName: "+firstName+", Lastname: "+lastname+
                ", Nine Digit Student ID: "+studentID+", Email: "+email;
    }
}
