package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;

import java.util.List;

public interface ContactRepository {
    Contact save(Contact contact);
    int count();
    Contact findById(int id);
    List <Contact> findContact(String searchValue);
    Contact deleteById(int id);
    Contact deleteContact(Contact contact);
}
