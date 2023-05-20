package com.example.dbdaohibernate.service;

import com.example.dbdaohibernate.model.Person;
import com.example.dbdaohibernate.repository.Repository;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }
    public List getPersonsByCity(String city) {
        return repository.getPersonsByCity(city);
    }
    public void get() {
        List<Person> persons = List.of(
                Person.builder()
                        .name("Иван")
                        .surname("Иванов")
                        .age(26)
                        .phoneNumber(799878947)
                        .cityOfLiving("Moscow")
                        .build(),
                Person.builder()
                        .name("Петр")
                        .surname("Петров")
                        .age(36)
                        .phoneNumber(987456292)
                        .cityOfLiving("Moscow")
                        .build(),
                Person.builder()
                        .name("Олег")
                        .surname("Ефремов")
                        .age(40)
                        .phoneNumber(759863256)
                        .cityOfLiving("Kazan")
                        .build()
        );

        persons.forEach(x -> repository.run(x));
    }
}
