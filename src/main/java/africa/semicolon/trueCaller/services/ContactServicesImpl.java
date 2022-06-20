package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import africa.semicolon.trueCaller.data.repositories.ContactRepositoryImpl;

public class ContactServicesImpl implements ContactServices{

    private ContactRepository contactRepository;

    public ContactServicesImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public void addContact(String firstName, String lastName, String phoneNumber) {
        Contact contact = new Contact(firstName, lastName, phoneNumber);
        contactRepository.save(contact);
    }

    @Override
    public Contact findById(int i) {
        return contactRepository.findById(i);
    }

    @Override
    public Contact findByFirstName(String firstName) {
        return contactRepository.findByFirstName(firstName);
    }

    @Override
    public void deleteById(int id) {
        contactRepository.deleteById(id);
    }

    @Override
    public void deleteByFirstName(String firstName) {
        contactRepository.deleteByFirstname(firstName);
    }
}
