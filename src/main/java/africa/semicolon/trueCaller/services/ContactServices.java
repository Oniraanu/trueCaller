package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;

public interface ContactServices {

    public void addContact(String firstName, String lastName, String phoneNumber);
    Contact findById(int i);
    Contact findByFirstName(String firstName);
    void deleteById(int id);
    void deleteByFirstName(String firstName);
}
