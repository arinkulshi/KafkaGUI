package com.arin.kafkamsg;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;

/**
 * Created by arin on 1/21/18.
 */
public class KafkaLogin implements ActionListener
{
    private JTextField username;
    private JPasswordField password;

    private String usernameString;
    private String passwordString;

    public KafkaLogin(JTextField username,JPasswordField password)
    {
          this.username = username;
          this.password = password;
    }

    public static boolean authenticate(String username, String password) {
        // hardcoded username and password
        if (username.equals("Jason") && password.equals("1234")) {
            System.out.println("Password Accept");
            return true;

        }
        return false;
    }


  public void actionPerformed(ActionEvent e) {
      this.usernameString = username.getText();
      this.passwordString = new String(password.getPassword());

      System.out.println(usernameString);
      System.out.println(passwordString);
        if (KafkaLogin.authenticate(usernameString, passwordString))
        {
            //JOptionPane.showMessageDialog("Hi " + username + "! You have successfully logged in.",
                  //  "Login");
            System.out.println("Password Accepted");
            TextBox t = new TextBox(usernameString);
        }
        else
            {

          System.out.println("Incorrect Password Entered ");
      }
         //   JOptionPane.showMessageDialog("Invalid username or password",
                 //   "Login");
            // reset username and password
            //user.setText("");
           // passwordTextField.setText("");



    }



}
