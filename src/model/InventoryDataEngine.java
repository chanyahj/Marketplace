package model;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InventoryDataEngine {


    //gets data from inventory.txt file and puts it into an arrayList
    public ArrayList<Inventory> loadInventoryData(String fileName) {
        ArrayList<Inventory> inventories = new ArrayList<Inventory>();
        User seller = new User();

        try {
            File data = new File(fileName);
            Scanner input = new Scanner(data);
            input.useDelimiter(",");
            input.nextLine();

            while (input.hasNextLine()) {
                Inventory inventory = new Inventory();
                String[] record = input.nextLine().split(",");

                for (int x = 0; x < record.length - 1; x++) {
                    seller.setUserName(record[0]);
                    inventory.setName(record[1]);
                    inventory.setPrice(Double.valueOf(record[2]));
                    inventory.setNew(Boolean.valueOf(record[3]));
                    inventory.setHowManyInStock(Integer.valueOf(record[4]));
                }
                inventories.add(inventory);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return inventories;
    }
    //called in buyer view to load the inventory for each user when selected
    //inventory.txt and userName of selected user is passed in through parameter
    public ArrayList<Inventory> loadUserInventoryData(String fileName, String name) {
        ArrayList<Inventory> inventoryArrayList = new ArrayList<>();
        try {
            File data = new File(fileName);
            Scanner input = new Scanner(data);
            input.useDelimiter(",");
            input.nextLine();

            while (input.hasNextLine()) {
                Inventory inventory = new Inventory();
                String[] record = input.nextLine().split(",");
                    if(record[0].equals(name)){

                        inventory.setName(record[1]);
                        inventory.setPrice(Double.valueOf(record[2]));
                        inventory.setNew(Boolean.valueOf(record[3]));
                        inventory.setHowManyInStock(Integer.valueOf(record[4]));
                        inventoryArrayList.add(inventory);


                }

            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return inventoryArrayList;
    }
}


