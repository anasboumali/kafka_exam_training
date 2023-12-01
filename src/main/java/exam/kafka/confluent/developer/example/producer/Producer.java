package exam.kafka.confluent.developer.example.producer;

import exam.kafka.confluent.developer.example.data.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class Producer {

    @Value(value = "${kafka.producer.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, Person> kafkaTemplate;

    public void sendMessage(Person person) {
        CompletableFuture<SendResult<String, Person>> future = kafkaTemplate.send(topic, String.valueOf(person.getId()), person);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Success with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message due to : " + ex.getMessage());
            }
        });
    }
}
