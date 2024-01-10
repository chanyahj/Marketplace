package view;

import javax.swing.*;

public class LoginView {
    private JTextField userNameLogin;
    private JPasswordField passwordLoginField;
    private JButton signInButton;
    private JButton createAccountButton;
    private JPanel myPanel;

    public JTextField getUserNameLogin() {
        return userNameLogin;
    }

    public JPasswordField getPasswordLoginField() {
        return passwordLoginField;
    }

    public JButton getSignInButton() {
        return signInButton;
    }

    public JButton getCreateAccountButton() {
        return createAccountButton;
    }

    public JPanel getMyPanel() {
        return myPanel;
    }
}
