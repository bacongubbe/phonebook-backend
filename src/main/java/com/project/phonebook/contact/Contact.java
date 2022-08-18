package com.project.phonebook.contact;

import javax.validation.constraints.NotEmpty;

public record Contact(String id, @NotEmpty String name, String address, String phoneNumber) {
}
