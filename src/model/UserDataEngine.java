package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserDataEngine {
    public ArrayList<User> loadUserData(String filename){
        ArrayList<User> users=new ArrayList<>();

        try{
            File data=new File(filename);
            Scanner input=new Scanner(data);
            input.useDelimiter(",");
            input.nextLine();
            while (input.hasNextLine()){
                User user=new User();
                String[] record = input.nextLine().split(",");

                for(int x=0;x<record.length-1;x++){
                    user.setUserName(record[0]);
                    user.setPassword(record[1]);
                    user.setFirstName(record[3]);
                    user.setLastname(record[2]);
                    user.setStudentID(Integer.valueOf(record[4]));
                    user.setEmail(record[5]);
                    user.setLocation(record[6]);
                }
                users.add(user);
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return users;
    }
}
