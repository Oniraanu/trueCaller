package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import africa.semicolon.trueCaller.data.repositories.ContactRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServicesImplTest {

    private ContactServices contactServices;
    private ContactRepository contactRepository;

    @BeforeEach
    public void setUp(){
        contactRepository = new ContactRepositoryImpl();
        contactServices = new ContactServicesImpl(contactRepository);
    }

    @Test
    public void saveContract_findAndReturnContact(){
        contactServices.addContact("Bakre", "Olubunmi", "08109739734");

        Contact contact = contactServices.findById(1);
        assertEquals("Bakre", contact.getFirstName());
        assertEquals("Olubunmi", contact.getLastName());
        assertEquals("08109739734", contact.getPhoneNumber());
        assertEquals(1, contactRepository.count());
    }
}