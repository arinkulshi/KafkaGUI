package com.arin.kafkamsg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by arin on 1/21/18.
 */
public class KafkaLoginDialog extends JDialog {
    private JTextField userNameTextField;
    private JPasswordField passwordTextField;
    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private JButton LoginButton;
    private JButton CancelButton;
    private boolean succeeded;

    public KafkaLoginDialog() {

        JFrame KafkaLoginDia = new JFrame("KafkaLoginDia");
        KafkaLoginDia.setLayout(new GridLayout(0,1));
        JPanel Namepanel = new JPanel();

        System.out.println("Dialog Box Present");
        userNameLabel = new JLabel("Username: "); //Username label and textfield
        Namepanel.add(userNameLabel);
        userNameTextField = new JTextField(20);
        Namepanel.add(userNameTextField); // Password Label and TextField


        JPanel PassPanel = new JPanel();
        passwordLabel = new JLabel("Password: ");
        PassPanel.add(passwordLabel);
        passwordTextField = new JPasswordField(20);
        PassPanel.add(passwordTextField);


        JPanel LoginButtonsPanel = new JPanel();
        LoginButton = new JButton("Login"); // Login Button
        LoginButtonsPanel.add(LoginButton);

        CancelButton = new JButton("Cancel"); // Login Button
        LoginButtonsPanel.add(CancelButton);



        KafkaLoginDia.add(Namepanel);
        KafkaLoginDia.add(PassPanel);
        KafkaLoginDia.add(LoginButtonsPanel);
//        bp.add(CancelButton);

        LoginButton.addActionListener(new KafkaLogin(userNameTextField, passwordTextField));

        KafkaLoginDia.setSize(new Dimension(500, 400));
        KafkaLoginDia.setVisible(true);

    }

    public static void main(String[] args) {
        KafkaLoginDialog k = new KafkaLoginDialog();


    }

       /* CancelButton = new JButton("Cancel");
        CancelButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }); */

    public String getUsername() {
        return userNameTextField.getText().trim();
    }

    public String getPassword() {
        return new String(passwordTextField.getPassword());
    }

    public boolean isSucceeded() {
        return succeeded;
    }
}
