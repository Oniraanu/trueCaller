package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import africa.semicolon.trueCaller.data.repositories.ContactRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class ContactServicesImpl implements ContactServices{

    private ContactRepository contactRepository = new ContactRepositoryImpl();

    @Override
    public void addContact(String firstName, String lastName, String phoneNumber) {
        Contact contact = new Contact(firstName, lastName, phoneNumber);
        contactRepository.save(contact);
    }

    @Override
    public List<Contact> findContact(String searchValue) {
        return contactRepository.findContact(searchValue);
    }

    @Override
    public Contact findId(int id) {
        return contactRepository.findById(id);
    }

    @Override
    public Contact deleteContact(Contact contact) {
        return contactRepository.deleteContact(contact);
    }
}
