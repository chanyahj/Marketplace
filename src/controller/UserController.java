package controller;

import model.User;
import model.UserDataEngine;
import view.UserLoginView;
import view.UserView;
import view.UserViewform;

import javax.swing.*;
import java.util.ArrayList;

public class UserController {
    private User user;
    private UserView view;


    public UserController(User user, UserView view) {
        this.user = user;
        this.view = view;

        UserViewform form = view.getForm();


        form.getCreateButton().addActionListener(e -> { //when the create account button is clicked

                    //Firstname field

                    String firstName = form.getFirstNameField().getText(); //assigns first name to value of text field
                   if(!isValidField(firstName)){ //if first name field is empty throw an error
                       JOptionPane.showMessageDialog(view, "Field is empty, please enter your first name");
                       return;
                   }
                   else {
                       user.setFirstName(firstName);
                   }
                    //Lastname field
                    String lastName = form.getLastNameField().getText();  //assigns last name to value of text field
                   if( !isValidField(lastName)) //if last name field is empty throw an error
                   {
                       JOptionPane.showMessageDialog(view, "Field is empty, please enter your last name");
                        return;
                   }
                else
                {
                user.setLastname(lastName);
                }
                    //Username Field
                    String username = form.getUserField().getText();
                if( !isValidField(username)) //if username name field is empty throw an error
                {
                JOptionPane.showMessageDialog(view, "Field is empty, please enter a username");
                return;
                }
                 else {
                user.setUserName(username);
                }


                    String password = form.getPwField().getText();
                    if(!isValidField(password)) //if password field is empty throw an error
                    {
                        JOptionPane.showMessageDialog(view, "Field is empty, please enter a password");
                        return;
                    }
                    else {
                        if (!isValidPassword(password)) { //if password field is less than 8 characters throw an error
                            JOptionPane.showMessageDialog(view, "Please enter a password with at least 8 characters");
                            return;
                        }
                            else{
                                user.setPassword(String.valueOf(password));
                            }


                    }

                    //Email Field
                    String email = form.getEmailField().getText();
                     if(!isValidField(email)){ //if email field is empty throw an error
                         JOptionPane.showMessageDialog(view, "Field is empty, please enter a password");
                         return;
                     }
                     else {
                         if (!isValidEmail(email)) { //if email string does not end in @psu.edu  throw an error
                             JOptionPane.showMessageDialog(view, "Please enter your penn state email");
                             return;
                         } else {
                             user.setEmail(email);
                         }
                     }

                    //Student ID Field
                    String studentID = form.getStuIDField().getText();
                    if (!isValidField(studentID)) { //if studentID field is empty throw an error
                        JOptionPane.showMessageDialog(view, "Field is empty, please enter your ID");
                        return;
                    } else {
                    if (!isValidStuID(studentID)) { //if studentID field is not exactly 9 digits empty throw an error
                        JOptionPane.showMessageDialog(view, "Please enter your nine digit Penn State student ID");
                        return;
                    } else {
                        user.setStudentID(Integer.valueOf(studentID));
                    }
                }

           //Campus location
           if(form.getYesRadioButton().isSelected()){ //if user selects yes
               user.setLocation((String) form.getComboBox1().getSelectedItem()); //sets the location to whatever the user selects from combo box
           }
           if(form.getNoRadioButton().isSelected()){ //if user selects no
               user.setLocation("Off-Campus"); //sets user location to off-campus
           }
                user.writeToFile(); //adds new user account to users.txt file


            UserLoginView view1=new UserLoginView(); //sends user back to Login View
            LoginController controller1=new LoginController(view1, user);
            view1.setSize(1000,1000);
            view1.setLocationRelativeTo(null);
            view1.setVisible(true);
            view.dispose();

        });


    }
    //Error handling
    public static boolean isValidField(String field){
        return !field.isBlank();
    }
    public static boolean isValidPassword(String isValid){
        return isValid.length()>=8;
    }
    public static boolean isValidEmail(String isValid){
        return isValid.substring(isValid.length()-8).equals("@psu.edu");
    }
    public static boolean isValidStuID(String studentID){
        return studentID.length()==9;
    }
}
