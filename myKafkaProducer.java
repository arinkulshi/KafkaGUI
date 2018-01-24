package com.arin.kafkamsg;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import javax.swing.*;


public class myKafkaProducer implements ActionListener {
    String topic = "medical";
    JTextArea textAreaEnter;
    JTextArea textAreaSent;
    String sync;
    //  private KafkaProducer kp;
    KafkaProducer pr;
    private final static String BOOTSTRAP_SERVERS =
            ("localhost:9091");
                    //"localhost:9093,localhost:9094";

    public myKafkaProducer(JTextArea messageEntered,JTextArea messageSend) {

       textAreaEnter = messageEntered; //Entered message is set with class var
     //   messageSend  = textAreaEnter; // Entered messaged is put in message recieived
        textAreaSent =  messageSend; // messaged Recieived is set with class var
        final Producer<Long, String> producer;
        Properties kafkaProps = new Properties();
        kafkaProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                BOOTSTRAP_SERVERS);
        kafkaProps.put(ProducerConfig.CLIENT_ID_CONFIG, "KafkaExampleProducer");
        kafkaProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                LongSerializer.class.getName());
        kafkaProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());

        pr = new KafkaProducer<String, String>(kafkaProps);

    }


    /* Produce a record and wait for server to reply. Throw an exception if something goes wrong */
    private void produceSync(String value) throws ExecutionException, InterruptedException {
        ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, value);
        pr.send(record).get();

    }


    public void actionPerformed(ActionEvent e) {







       String textMessage = textAreaEnter.getText();
        System.out.println("your message is here" + textMessage);
        textAreaSent.append("\n"+textMessage);
        // textAreaSent.setText(textAreaSent.getText()+ "\n"+textMessage);
        System.out.println("something was sent");
        textAreaEnter.setText("");
       ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, textMessage);
       pr.send(record);


    }
}