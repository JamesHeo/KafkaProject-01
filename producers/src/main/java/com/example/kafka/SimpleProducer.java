package com.example.kafka;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class SimpleProducer {
  public static void main(String[] args) {

    String topicName = "simple-topic";

    //KafkaProducer config
    Properties props = new Properties();

    //bootstrap.servers, key.serializser.class, value.serializer.class
    props.setProperty("bootstrap.servers", "***.***.***.***:****");
    props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "***.***.***.***:****");
    props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

    //KafkaProducer object creation
    KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(props);

    //ProducerRecord object creation
    ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topicName,"hello world2");

    //KafkaProducer message send
    kafkaProducer.send(producerRecord);

    kafkaProducer.close();

  }
}
