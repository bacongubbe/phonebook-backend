package com.project.phonebook.repository;

import com.project.phonebook.contact.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ContactRepository {

    List<Contact> contacts = new ArrayList<>();

    public ContactRepository (){
        contacts.add(new Contact(
                UUID.randomUUID().toString(),
                "Felix Berg",
                "Solbergsvägen 57, 16866 Bromma",
                "+46708926313"
        ));
    }

    public List<Contact> findAll(){ return contacts;}

    public Contact findById(String id){
        return contacts.stream().filter(contact -> contact.id().equals(id)).findFirst().orElseThrow();
    }

    public Contact create(Contact contact){
        contacts.add(contact);
        return contact;
    }

    public void delete(String id){ contacts.removeIf(contact -> contact.id().equals(id));}

    public void update (Contact contact, String id){
        Contact existing = contacts.stream().filter(c -> c.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Contact not found"));
        int i = contacts.indexOf(existing);
        contacts.set(i, contact);
    }
}
