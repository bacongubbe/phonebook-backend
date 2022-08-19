package com.project.phonebook.controller;

import com.project.phonebook.contact.Contact;
import com.project.phonebook.repository.ContactRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactRepository repository;

    public ContactController(ContactRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Contact> findAll(){return repository.findAll();}

    @GetMapping("/{id}")
    public Contact findById(@PathVariable String id){
        return repository.findById(id);
    }

    @ResponseStatus (HttpStatus.CREATED)
    @PostMapping
    public Contact create(@Valid @RequestBody Contact contact) {return repository.create(contact);}

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping ("/{id}")
    public void delete(@PathVariable String id){
        repository.delete(id);
    }

}
