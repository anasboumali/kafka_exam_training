package exam.kafka.confluent.developer.example.controller;

import exam.kafka.confluent.developer.example.data.Person;
import exam.kafka.confluent.developer.example.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
public class PersonController {

    @Autowired
    private Producer producer;

    @PostMapping
    public ResponseEntity createPerson(@RequestBody Person person) {
        producer.sendMessage(person);

        return ResponseEntity.accepted().build();
    }
}
