package com.example.springbootlibrary.services;

import com.example.springbootlibrary.model.Person;
import com.example.springbootlibrary.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> getAllPeople() {
        return this.peopleRepository.findAll();
    }

    public Person getPersonById(int id) {
        Optional<Person> person = this.peopleRepository.findById(id);
        return person.orElse(null);
    }

    @Transactional
    public void createPerson(Person person) {
        this.peopleRepository.save(person);
    }

    @Transactional
    public void updatePersonById(Person person) {
        this.peopleRepository.save(person);
    }
}
