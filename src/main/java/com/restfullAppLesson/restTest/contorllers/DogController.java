package com.restfullAppLesson.restTest.contorllers;

import com.restfullAppLesson.restTest.entities.Dog;
import com.restfullAppLesson.restTest.repositories.DogRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/dogs")
@AllArgsConstructor
public class DogController {
    private final DogRepo dogRepo;

    @GetMapping("/all")
    public List<Dog> getAllDogs() {
        return dogRepo.findAll();
    }

    @GetMapping("/{name}")
    public ResponseEntity<Dog> getDog(@PathVariable String name) {
        var dog = dogRepo.findByName(name);
        if (dog == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(dog, HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public Dog addDog(@RequestBody Dog dog) {
        dog.setId(UUID.randomUUID());
        dogRepo.save(dog);

        return dog;
    }
}
