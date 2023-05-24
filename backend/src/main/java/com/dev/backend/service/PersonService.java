package com.dev.backend.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Person;
import com.dev.backend.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        return personRepository.findById(id).get();
    }

    public Person insert(Person person) {
        person.setCreationDate(new Date());
        Person newPerson = personRepository.saveAndFlush(person);
        return newPerson;
    }

    public Person update(Person person) {
        person.setUpdateDate(new Date());
        return personRepository.saveAndFlush(person);
    }

    public void delete(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Person not found."));
        personRepository.delete(person);

    }

}
