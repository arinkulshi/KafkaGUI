package com.arin.kafkamsg;

import kafka.Kafka;
import sun.java2d.pipe.SpanShapeRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by arin on 12/21/17.
 */
public class TextBox {

    public TextBox(String Username) {

        JFrame Kafkabox = new JFrame("My Kafka"); // Sets the layout.
        Kafkabox.setLayout(new GridLayout(0, 1));

        JTextArea messSend = new JTextArea(10, 20); //Sets the textfield
        JTextArea messReciTA = new JTextArea(10, 20);
        JTextArea messEnter = new JTextArea(10, 20);

        JPanel panelMess = new JPanel(new GridLayout(8, 0)); //Sets the panel layout and adds to frame


        panelMess.add(new JLabel("MessageReceived"));
        //   panelMess.add(messReci);
        JScrollPane scrollReci = new JScrollPane(messReciTA, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panelMess.add(scrollReci);


        panelMess.add(new JLabel("MessageSent: "));
        //   panelMess.add(messSend);
        JScrollPane scrollSent = new JScrollPane(messSend, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panelMess.add(scrollSent);

        panelMess.add(new JLabel("Enter Message"));
        //   panelMess.add(messReci);
        JScrollPane scrollEnter = new JScrollPane(messEnter, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panelMess.add(scrollEnter);


        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new myKafkaProducer(messEnter, messSend));
        panelMess.add(sendButton);


        Kafkabox.add(panelMess);
        Kafkabox.setSize(new Dimension(500, 400));
        Kafkabox.setVisible(true);

        Runnable consumer = new SimpleHLConsumer(messReciTA);
        System.out.println("Consumer Recieived");
     //   Runnable r = new (consumer);
        Thread t = new Thread(consumer);
       t.start();


    }


}
