package view;

import controller.SellerController;

import javax.swing.*;



    public class SellerFormView extends JFrame{
        private SellerView form;
        private SellerController controller;
        public SellerFormView(){
            this.form=new SellerView();
            JPanel content= form.getMyPanel();
            this.setContentPane(content);
            this.pack();
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        }
        public SellerView getForm(){ return form;}
    }

