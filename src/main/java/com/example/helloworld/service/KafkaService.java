package com.example.helloworld.service;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaService {

//	@Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;
//	@KafkaListener(topics = { "test01" })
//	public void listen(ConsumerRecord<?, ?> record) throws Exception{
//
//		System.out.printf("listen:topic = %s, partition = %d, offset = %d, value = %s \n", record.topic(), record.partition(), record.offset(), record.value());
//	}
//	
//	public String send(String msg){
//        kafkaTemplate.send("test", new Integer(4), "test01", msg);
//        return "success";
//    }
}
