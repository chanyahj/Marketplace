package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CartDataEngine {
    public ArrayList<Inventory> loadCartData(String fileName){
        ArrayList<Inventory> cart= new ArrayList<>();
        try{
            File data=new File(fileName);
            Scanner input=new Scanner(data);
            input.useDelimiter(",");
            input.nextLine();

            while (input.hasNextLine()){
                Inventory inventory=new Inventory();
                String[] record = input.nextLine().split(",");

                for(int x=0; x< record.length-1;x++){
                    inventory.setName(record[0]);
                    inventory.setPrice(Double.valueOf(record[1]));
                    inventory.setNew(Boolean.valueOf(record[2]));
                    inventory.setHowManyInStock(Integer.valueOf(record[3]));
                }
                cart.add(inventory);
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return cart;
    }
}
