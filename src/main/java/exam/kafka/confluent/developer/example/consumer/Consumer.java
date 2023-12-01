package exam.kafka.confluent.developer.example.consumer;

import exam.kafka.confluent.developer.example.data.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    @KafkaListener(topics = "person")
    public void handle(Person message) {
        log.info("Received Message in group foo: " + message);
    }

}
