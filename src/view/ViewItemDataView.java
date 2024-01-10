package view;

import javax.swing.*;

public class ViewItemDataView extends JFrame{
    private ViewInventoryData form;
    public ViewItemDataView(){
        this.form=new ViewInventoryData();
        JPanel content= form.getMyPanel();
        this.setContentPane(content);
        this.pack();
    //    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public ViewItemDataView(ViewInventoryData form){
        this.form=new ViewInventoryData();
        JPanel content= form.getMyPanel();
        this.setContentPane(content);
        this.pack();
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public ViewInventoryData getForm(){return form;}
}
