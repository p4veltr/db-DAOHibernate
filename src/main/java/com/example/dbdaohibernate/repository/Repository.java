package com.example.dbdaohibernate.repository;

import com.example.dbdaohibernate.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Person, Integer> {
}
