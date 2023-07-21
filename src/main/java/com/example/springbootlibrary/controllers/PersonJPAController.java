package com.example.springbootlibrary.controllers;


import com.example.springbootlibrary.model.Person;
import com.example.springbootlibrary.services.PeopleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jpa/people")
public class PersonJPAController {


    private final PeopleService peopleService;

    @Autowired
    public PersonJPAController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping()
    public String getPeople(Model model){
        model.addAttribute("people", this.peopleService.getAllPeople());
        return "person/all-people";
    }

    @GetMapping("/{id}")
    public String getPersonById(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.peopleService.getPersonById(id));
        return "person/person-by-id";
    }

    @GetMapping("/new")
    public String getCreateNewPerson(@ModelAttribute("person") Person person){
        return "person/person-create-new";
    }


    @GetMapping("/{id}/edit")
    public String getPersonEditById(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.peopleService.getPersonById(id));
        return "person/person-edit";
    }
    @PostMapping("")
    public String createPerson( @ModelAttribute("person") @Valid Person person,
                                BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "person/person-create-new";

        this.peopleService.createPerson(person);
        return "redirect:/people";
    }

    @PutMapping("/{id}/edit")
    public String updatePersonById(@ModelAttribute("person") @Valid Person person,
                                   BindingResult bindingResult,
                                   Model model) {
        if (bindingResult.hasErrors()) {
//            log.warn(String.valueOf(bindingResult));
            return "person/person-edit";
        }

        this.peopleService.updatePersonById(person);
        model.addAttribute("person", person);
        return "redirect:/people/" + person.getId();
    }
}
