package com.project.phonebook.contact;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

public record Contact(String id, @NotEmpty String name, String address, String phoneNumber) {
    public Contact(String id, @NotEmpty String name, String address, String phoneNumber) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
