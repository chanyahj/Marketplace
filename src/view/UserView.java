package view;

import javax.swing.*;

public class UserView extends JFrame{
    private UserViewform form;

    public UserView(){
        this.form=new UserViewform();
        JPanel content=form.getMyPanel();
        this.setContentPane(content);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public UserViewform getForm(){return form;}
}
