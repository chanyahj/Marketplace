package view;

import javax.swing.*;

public class UserViewform {
    private JTextField userField;
    private JTextField pwField;
    private JTextField emailField;
    private JTextField stuIDField;
    private JButton createButton;
    private JPanel myPanel;
    private JRadioButton yesRadioButton;
    private JRadioButton noRadioButton;
    private JComboBox comboBox1;
    private JTextField firstNameField;
    private JTextField lastNameField;

    public JTextField getFirstNameField() {
        return firstNameField;
    }

    public JTextField getLastNameField() {
        return lastNameField;
    }

    public JRadioButton getYesRadioButton() {
        return yesRadioButton;
    }

    public JRadioButton getNoRadioButton() {
        return noRadioButton;
    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }

    public JPanel getMyPanel() {
        return myPanel;
    }

    public JTextField getUserField() {
        return userField;
    }

    public JTextField getPwField() {
        return pwField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JTextField getStuIDField() {
        return stuIDField;
    }

    public JButton getCreateButton() {
        return createButton;
    }
}
