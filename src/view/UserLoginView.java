package view;

import javax.swing.*;

public class UserLoginView extends JFrame {
    private LoginView form;
    public UserLoginView(){
        this.form=new LoginView();
        JPanel content=form.getMyPanel();
        this.setContentPane(content);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public LoginView getForm(){return  form;}

}
