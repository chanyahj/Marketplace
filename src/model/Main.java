package model;

import controller.*;
import view.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        //Starting screen, login view
        UserLoginView view1=new UserLoginView();
        User user=new User();
        LoginController controller1=new LoginController(view1, user);
        view1.setSize(1000,1000);
        view1.setLocationRelativeTo(null);
        view1.setVisible(true);

        //for quick access use:
        //username: nyahj14 password: Cdj021404$


//




    }
}