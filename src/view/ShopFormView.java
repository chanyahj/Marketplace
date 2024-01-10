package view;

import controller.SellerController;
import controller.ShopController;

import javax.swing.*;

public class ShopFormView extends JFrame{

        private ShopForm form;
        private ShopController controller;
        public ShopFormView(){
            this.form=new ShopForm();
            JPanel content= form.getMyPanel();
            this.setContentPane(content);
            this.pack();
            //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        }
        public ShopForm getForm(){ return form;}
    }

