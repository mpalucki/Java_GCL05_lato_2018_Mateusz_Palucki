package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App extends JFrame {
    private JButton loginButton;
    private JPanel panelMain;
    private JLabel errorLabel;
    private JLabel passwordLabel;
    private JLabel loginLabel;
    private JTextField usernameText;
    private JTextField JPasswordField;
    private JLabel passwordLoginLabel;
    private JLabel passwordErrorLabel;
    private JButton resetButton;
    private JPasswordField passwordText;
    private JComboBox comboBox1;
    //private JPanel secPanel;
    private JFrame frame;


    public App() {
        comboBox1.addItem("Program");
        comboBox1.addItem("Zamknij");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //errorLabel.setText("");
                passwordErrorLabel.setText("");
                passwordErrorLabel.setForeground(Color.RED);
                passwordLoginLabel.setText("");


                String uname = usernameText.getText();
                String psd = String.valueOf(passwordText.getPassword());
                if (uname == null && psd == null) {
                    JOptionPane.showMessageDialog(null, "Error");
                } else if (uname.length() < 3) {
                    //passwordLoginLabel.setText("nazwa jest za krotka!");
                    JOptionPane.showMessageDialog(null, "nazwa jest za krotka!");
                    //errorLabel.setText("Podano nie poprawne dane!");
                } else if (uname.length() > 20) {
                    //passwordLoginLabel.setText("nazwa jest za dluga!");
                    JOptionPane.showMessageDialog(null, "nazwa jest za dluga!");
                    //errorLabel.setText("Podano nie poprawne dane!");
                } else if (psd.length() < 3) {
                    //passwordErrorLabel.setText("haslo jest za krotkie!");
                    JOptionPane.showMessageDialog(null, "haslo jest za krotkie!");
                    //errorLabel.setText("Podano nie poprawne dane!");
                } else if (psd.length() > 20) {
                    //passwordErrorLabel.setText("haslo jest za dlugie!");
                    JOptionPane.showMessageDialog(null, "haslo jest za dlugie!");
                    //errorLabel.setText("Podano nie poprawne dane!");
                } else {
                    passwordErrorLabel.setText("poprawne dane!");
                    JFrame secFrame = new JFrame();
                    secFrame.setContentPane(new secPanel().getMainPanel());
                    secFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    secFrame.pack();
                    secFrame.setVisible(true);


                }
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordErrorLabel.setText("");
                passwordLoginLabel.setText("");
                //errorLabel.setText("");
                usernameText.setText("");
                passwordText.setText("");
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox1.getSelectedItem().toString() == "Zamknij")
                    System.exit(0);
            }
        });
        usernameText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                passwordLoginLabel.setText("");
                passwordLoginLabel.setForeground(Color.RED);
                String uname = usernameText.getText();
                if (uname.length() < 3 || uname.length() > 20) {
                    passwordLoginLabel.setText("rozmiar loginu 3-20");
                }
            }
        });
        passwordText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                passwordErrorLabel.setText("");
                passwordErrorLabel.setForeground(Color.RED);
                String psd = String.valueOf(passwordText.getPassword());
                if (psd.length() < 3 || psd.length() > 20) {
                    passwordErrorLabel.setText("rozmiar hasla 3-20");
                }
            }
        });
    }

    public static void main(String[] args) {
        App frame = new App();
        frame.setContentPane(new App().panelMain);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panelMain = new JPanel();
        panelMain.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(6, 4, new Insets(0, 0, 0, 0), -1, -1));
        passwordText = new JPasswordField();
        panelMain.add(passwordText, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, -1), null, 0, false));
        usernameText = new JTextField();
        panelMain.add(usernameText, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, -1), null, 0, false));
        passwordLabel = new JLabel();
        passwordLabel.setText("Password");
        panelMain.add(passwordLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        loginLabel = new JLabel();
        loginLabel.setText("Username");
        panelMain.add(loginLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        loginButton = new JButton();
        loginButton.setText("login");
        panelMain.add(loginButton, new com.intellij.uiDesigner.core.GridConstraints(5, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        resetButton = new JButton();
        resetButton.setText("reset");
        panelMain.add(resetButton, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        passwordLoginLabel = new JLabel();
        passwordLoginLabel.setText("");
        panelMain.add(passwordLoginLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        passwordErrorLabel = new JLabel();
        passwordErrorLabel.setText("");
        panelMain.add(passwordErrorLabel, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox1 = new JComboBox();
        panelMain.add(comboBox1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelMain;
    }
}

