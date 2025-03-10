package com.restfullAppLesson.restTest.repositories;

import com.restfullAppLesson.restTest.entities.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepo extends JpaRepository<Cat, Long>  {

}
