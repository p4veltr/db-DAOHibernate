package com.example.dbdaohibernate.repository;

import com.example.dbdaohibernate.model.Person;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Person, Integer> {

    @Transactional
    List<Person> findByCityOfLivingContaining(String city);

    @Transactional
    List<Person> findByAgeLessThanOrderByAgeAsc(Integer age);

    Optional<Person> findByNameAndSurname(String name, String surname);
}
