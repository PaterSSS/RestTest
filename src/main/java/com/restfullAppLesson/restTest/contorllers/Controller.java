package com.restfullAppLesson.restTest.contorllers;

import com.restfullAppLesson.restTest.KafkaProducer;
import com.restfullAppLesson.restTest.repositories.CatRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class Controller {
    private final KafkaProducer kafkaProducer;
    private final CatRepo catRepo;

    @GetMapping("/kafka/send/{id}")
    public String sendMessage(@PathVariable Long id) {
        var cat = catRepo.findById(id);
        kafkaProducer.sendMessage(cat.toString());

        return "success";
    }
}
