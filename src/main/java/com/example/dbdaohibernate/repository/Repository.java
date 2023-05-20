package com.example.dbdaohibernate.repository;

import com.example.dbdaohibernate.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {

    @PersistenceContext
    EntityManager entityManager;

    Person person = new Person();

    @Transactional
    public void run(Person person) {
        entityManager.persist(person);
    }

    @Transactional
    public List getPersonsByCity(String city) {
        Query query = entityManager.createQuery("select name from Person where cityOfLiving = :city order by name, surname");
        query.setParameter("city", city);
        return query.getResultList();
    }
}
