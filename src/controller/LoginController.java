package controller;

//import model.Seller;
import model.User;
import model.UserDataEngine;
import view.LoginView;
import view.SellerFormView;
import view.UserLoginView;
import view.UserView;

import javax.swing.*;
import java.util.ArrayList;

public class LoginController {
    private UserLoginView view;
    private User user;
    private ArrayList<User> users;

    public LoginController(UserLoginView view, User user) {
        LoginView form = view.getForm(); //gets LoginView form
        UserDataEngine userDataEngine = new UserDataEngine(); //initializes UserDataEngine
        users = userDataEngine.loadUserData("users.txt"); //returns a User array from user.txt

        form.getSignInButton().addActionListener(e -> { //when the Sign In button is clicked

            String username=form.getUserNameLogin().getText(); //gets text from Username field
            String password=form.getPasswordLoginField().getText(); //gets Password from Password field

                //validate login credentials
                for (User userList : users) { //goes through ever user in the users Arraylist
                    if (userList.getUserName().equals(username) && // checks to see if the userName in the array list and the username field matches
                            userList.getPassword().equals(password)) { //checks if password in arrayList and password field matches

                        SellerFormView view1 = new SellerFormView(); //initliazes SellerFormView
                        User seller = new User(); //initialize a new User
                        SellerController controller = new SellerController(view1, seller, username); //passes in view, user, and username into the SellerController
                        view1.setSize(1000, 1000);
                        view1.setLocationRelativeTo(null);
                        view.dispose(); //closes the LoginView

                        view1.setVisible(true);
                        break; //stops loop if username && password matches
                    } else {
//                        JOptionPane.showMessageDialog(view, "Invalid login credentials");
//                        break;
                    }
                }
 //

        });
        form.getCreateAccountButton().addActionListener(e -> { //loads the UserView and UserController screen
            UserView view2=new UserView();
            UserController controller=new UserController(user, view2);
            view2.setSize(1000,1000);
            view2.setLocationRelativeTo(null);
            view2.setVisible(true);
            view.dispose();

        });
    }
//Error handling
public static boolean isValidField(String field){
    return !field.isBlank();
}

}