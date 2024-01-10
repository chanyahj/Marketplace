package view;


import controller.ShoppingCartController;

import javax.swing.*;

public class ShoppingCartView extends JFrame{

        private ShoppingCartForm form;
        private ShoppingCartController controller;
        public ShoppingCartView(){
            this.form=new ShoppingCartForm();
            JPanel content= form.getMyPanel();
            this.setContentPane(content);
            this.pack();
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        }
        public ShoppingCartForm getForm(){ return form;}
    }

