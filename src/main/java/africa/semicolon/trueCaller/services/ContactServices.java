package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;

import java.util.List;

public interface ContactServices {

    void addContact(String firstName, String lastName, String phoneNumber);
    List <Contact> findContact(String searchValue);
    Contact findId(int id);
    Contact deleteContact(Contact contact);
}
