package exam.kafka.confluent.developer.example.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Person {
    Long id;
    String name;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    LocalDateTime birthDate;
}
