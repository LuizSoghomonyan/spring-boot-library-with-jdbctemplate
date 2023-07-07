package com.example.springbootlibrary.dao;

import com.example.springbootlibrary.dao.mappers.PersonMapper;
import com.example.springbootlibrary.model.Person;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Person> getAllPeople() {
        return this.jdbcTemplate.query("select* from person", new PersonMapper());
    }

    public Person getPersonById(int id) {
        return this.jdbcTemplate.query("select* from person where id = ?",
                                            new Object[]{id},
                                            new PersonMapper()).stream().findAny().orElse(null);
    }

    public void createPerson(Person person) {
        this.jdbcTemplate.update(
                "insert into person (firstname, lastname, email, age, birthYear) values (?,?,?,?,?)",
                    person.getFirstname(),person.getLastname(), person.getEmail(), person.getAge(), person.getBirthYear()
                );
    }
}
