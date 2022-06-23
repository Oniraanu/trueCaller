package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImpl implements ContactRepository{

    ArrayList <Contact> contacts = new ArrayList<>();

    @Override
    public Contact save(Contact contact) {
        contact.setId(contacts.size() + 1);
        contacts.add(contact);
        return contact;
    }

    @Override
    public int count() {
        return contacts.size();
    }

    @Override
    public Contact findById(int id) {
        for (Contact contact : contacts){
            if (contact.getId() == id)
                return contact;
        }
        return null;
    }

    @Override
    public  List <Contact> findContact(String searchValue) {
        List listOfContacts = new ArrayList<>();
        for (Contact contact : contacts){
            if (contact.getFirstName().equalsIgnoreCase(searchValue) ||
            contact.getLastName().equalsIgnoreCase(searchValue) ||
            contact.getPhoneNumber().equalsIgnoreCase(searchValue))
                listOfContacts.add(contact);
        }
        return listOfContacts;
    }

    @Override
    public Contact deleteById(int id) {
        for (Contact contact : contacts){
            if (contact.getId() == id)
                contacts.remove(contact);
        }
        return null;
    }

    @Override
    public Contact deleteContact(Contact contact) {
        for (Contact myContact : contacts){
            if (myContact.equals(contact))
                contacts.remove(contact);
            return myContact;
        }
        return null;
    }

    private Contact updateContact(int id, Contact newContact){
        for (Contact contact : contacts){
            if (contact.getId() == id)
                contacts.set(id, newContact);
        }
        return newContact;
    }
}
