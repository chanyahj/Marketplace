package view;

import javax.swing.*;

public class AddItemView extends JFrame {
    private AddItem form;
    public AddItemView(){
        this.form=new AddItem();
        JPanel content= form.getMyPanel();
        this.setContentPane(content);
        this.pack();
       // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public AddItemView(AddItem form){
        this.form=form;
        JPanel content= form.getMyPanel();
        this.setContentPane(content);
        this.pack();
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public AddItem getForm(){ return form;}
}
