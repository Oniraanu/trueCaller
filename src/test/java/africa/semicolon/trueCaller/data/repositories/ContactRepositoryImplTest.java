package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryImplTest {

    private ContactRepository contactRepository;

    @BeforeEach
    public void setUp(){
        contactRepository = new ContactRepositoryImpl();
    }

    @Test
    public void saveContactTest(){
        Contact contact = new Contact();
        contact.setFirstName("Olubunmi");

        Contact saveContact = contactRepository.save(contact);
        assertEquals(1, saveContact.getId());
        assertEquals(1, contactRepository.count());
    }

    @Test
    public void saveContactMultipleTest(){
        Contact contact = new Contact();
        contact.setFirstName("Olubunmi");

        Contact saveContact = contactRepository.save(contact);
        assertEquals(1, saveContact.getId());
        Contact saveContact2 = contactRepository.save(contact);
        assertEquals(2, saveContact2.getId());
        assertEquals(2, contactRepository.count());
    }

    @Test
    public void saveContactsAndFindById(){
        Contact contact = new Contact();
        contact.setFirstName("Olubunmi");
        Contact contact2 = new Contact();
        contact2.setFirstName("Mayowa");

        Contact saveContact = contactRepository.save(contact);
        Contact saveContact2 = contactRepository.save(contact2);

        Contact findFirstContact = contactRepository.findById(1);
        Contact findSecondContact = contactRepository.findById(2);

        assertEquals(1, findFirstContact.getId());
        assertEquals(2, findSecondContact.getId());
        assertEquals("Olubunmi", findFirstContact.getFirstName());
        assertEquals("Mayowa", findSecondContact.getFirstName());
    }

    @Test
    public void canFindByFirstNameTest(){
        Contact contact = new Contact();
        contact.setFirstName("Olubunmi");
        Contact contact2 = new Contact();
        contact2.setFirstName("Mayowa");
        Contact contact3 = new Contact();
        contact.setFirstName("Ayomikun");

        Contact saveContact = contactRepository.save(contact);
        Contact saveContact2 = contactRepository.save(contact2);
        Contact saveContact3 = contactRepository.save(contact3);

        assertEquals("Mayowa", saveContact2.getFirstName());
    }
}