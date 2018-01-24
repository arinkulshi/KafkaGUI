package com.arin.kafkamsg;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import javax.swing.*;
import java.util.*;

public class SimpleHLConsumer implements  Runnable {

    private static String groupId = "medicalGroup";
    private String zookeeper = "localhost:2181";
 //   private final ConsumerConnector consumer;
 KafkaConsumer<String, String> consumer;

    private final String topic = "medical";

    List<KafkaStream<byte[], byte[]>> streams;

    public SimpleHLConsumer(JTextArea j) {
        Properties props = new Properties();
        props.put("zookeeper.connect", zookeeper);
        props.put("bootstrap.servers", "localhost:9091,localhost:9092");
        props.put("group.id", groupId);
        props.put("key.deserializer",  "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",  "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("zookeeper.session.timeout.ms", "500");
        props.put("zookeeper.sync.time.ms", "250");
        props.put("auto.commit.interval.ms", "1000");
 //       props.put("auto.offset.reset","none"); // Need to understand this

//        consumer = Consumer.createJavaConsumerConnector(new ConsumerConfig(props));
        consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Collections.singletonList(topic));
  //      Map<String, Integer> topicMap = new HashMap<>();
  //      topicMap.put(topic, 1);

 //       Map<String, List<KafkaStream<byte[], byte[]>>> consumerStreams = consumer.createMessageStreams(topicMap);

 //       List<KafkaStream<byte[], byte[]>> streams;
 //       streams = consumerStreams.get(topic);

    }
    public void run() {

        try {
            while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            if (null!= records) {
                for (ConsumerRecord<String, String> record : records) {
                    //               log.debug("topic = %s, partition = %s, offset = %d, customer = %s, country = %s\n",
                    System.out.println(record.topic() + "  :" + record.partition() + "  : " + record.offset() + "  : " + record.key() + "  : " + record.value());
                    int updatedCount = 1;
                /*
                if (custCountryMap.countainsValue(record.value())) {
                    updatedCount = custCountryMap.get(record.value()) + 1;
                }
                custCountryMap.put(record.value(), updatedCount);
                JSONObject json = new JSONObject(custCountryMap);
                System.out.println(json.toString(4));
                */
                }
            }
        }
        } finally {
            consumer.close();
        }

    }



/*
    public void run() {

        for (final KafkaStream stream : streams) {
            ConsumerIterator<byte[], byte[]> it = stream.iterator();
            while (it.hasNext()) {
                System.out.println("Message from Single Topic: " + new String(it.next().message()));
            }
        }
        if (consumer != null) {
            consumer.shutdown();
        }
    }


*/

}