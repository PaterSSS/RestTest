package com.restfullAppLesson.restTest.contorllers;

import com.restfullAppLesson.restTest.entities.Cat;
import com.restfullAppLesson.restTest.entities.dtos.CatDTO;
import com.restfullAppLesson.restTest.repositories.CatRepo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "mainController")
@RestController
@RequestMapping("/api/cats")
@Slf4j
public class MainController {
    private CatRepo catRepo;

    @Autowired
    public MainController(CatRepo catRepo) {
        this.catRepo = catRepo;
    }

    @Operation(
            summary = "Create new cat in db",
            description = "Creates DTO of cat and puts it in the database"
    )
    @PostMapping("/add")
    public void addCat(@RequestBody CatDTO cat) {
        Cat catEntity = Cat.builder()
                .name(cat.getName())
                .age(cat.getAge())
                .weight(cat.getWeight())
                .gender(cat.getGender())
                .build();
        catRepo.save(catEntity);
        log.info("Saved cat: {}", catEntity);
    }

    @GetMapping("/all")
    public List<Cat> getAllCats() {
        return catRepo.findAll();
    }

    @GetMapping("/get/{catId}")
    public Cat getCat(@PathVariable Long catId) {
        log.info("Get cat: {}", catId);
        return catRepo.findById(catId).orElse(new Cat());
    }

    @DeleteMapping("/delete/{catId}")
    public void deleteCat(@PathVariable Long catId) {
        log.info("Delete cat: {}", catId);
        catRepo.deleteById(catId);
    }

    @PutMapping("/update")
    public String updateCat(@RequestBody Cat cat) {
        log.info("Update cat: {}", cat);

        if (!catRepo.existsById(cat.getId())) {
            return "No such cat";
        }

        catRepo.save(cat);
        return "Updated cat";
    }
}
