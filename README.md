# KafkaGUI in Java
Builds a Kafka Producer and Consumer using GUI in Java

# Purpose
   Kafka has become one of the most prominent publish-subscribe messaging services.
The purpose of this project is to build a Kafka producer and consumer in java. Users would log in
and messages would be pushed by selected topic. These messages would then be read by the consumer and displayed. 

# Why Apache Kafka

      Lets say you have one website and one database. Your database is your source and your website becomes your target. 
It will be trivial for messages to be recieived and stored in the database and read for the database to be displayed on the 
website. However, this configuration gets complicated very quickly if you have multiple sources and multiple targets.
It becomes difficult to integrate every source with every database. 
   
   Kafka solves this problem. It will manage the data streams from multiple sources and distributes them to each respective source and target.
Kafka has many applications including but not limited to messaging systems, handling metric and logs. Kafka also follows the 
popular DFS(distrubted file system) architecure seen in many NoSQL and big data solutions such as Hadoop and Spark. This makes it 
very easy to integrate Kafka with other commonly used big data architecture that might already be implemented.

# Classes

### Textbox 
- Will build the GUI for the producer. 
- The producer will send messages. 
- To confirm the correct message has been sent and recieived we will include two new scroll boxes for message sent and recieved.

### MyKafkaProducer
 - Reads the messages from the enter message and adds them under the topic 'medical'.
### KafkaLoginDialog 
 - Registers the GUI for the login box. 
 - This loginbox will autheticate the user who is writing the message before the message can be produced. 
### KafkaLogin 
  - Once the login button is registerd this class will produce the Login Box
### SimpleHLConsumer
  - The consumer will read messages from the 'medical' topic and print those messages. 
  - The records will continue to be read until the topic is closed
  - Once a message is read the offset will be updated to reflect the messages. 

# Getting Started

### Things you will need to download
In order to run kafka you will need to downlod the Kafka APK
Link: https://www.apache.org/dyn/closer.cgi?path=/kafka/1.0.0/kafka_2.11-1.0.0.tgz

Once you download the KafkaAPK you need to install and IDE. I used intellji
https://www.jetbrains.com/idea/download/#section=linux

You will be setting up a maven project so you need to download the .pom file that will go with the maven project. 
https://github.com/dibbhatt/kafka-spark-consumer/blob/master/pom.xml 
You can download this .pom file just keep in mind to update the versions

###Configuring Kafka 

Unpack the Kafka APK and go to config. You will notice a file called server properties. 
This file will have a host number. Choose the appropriate host number for your cofiguration. 
You can also add another server if you would like to send messages from two distinct servers. 
Make sure to make the second server's host number different to your first server.

You need to start the zookeeper. This command will do it.
bin/zookeeper-server-start.sh config/zookeeper.properties

Next you need to start the servers you just configured
bin/kafka-server-start.sh config/server.properties

Use this command to start a new topic. In the case of this program the topic is 'medical'
Use the number of partitions and replication you deem appropriate
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic medical

###Running the Java Program

Open intellji and open a new Maven Project using default config.
Replace the dependicies in the .pom file from Maven with the .pom file you downloaded earlier. Keep the rest of the file the same. Only copy the dependecies.
If your server is running try entering some text and you will see the message recieved on the consumer end.









    


