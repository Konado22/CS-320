package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import Contact.Contact;
import Contact.ContactService;

class NewestContactServiceTest {

	@Test
	void addTest() {
		ContactService contactService = new ContactService();
		Contact contact = new Contact("0101010101", "Will", "Smith", "1234321231", "1234 Belair Blvd");
		contactService.addContact(contact);
		assertTrue(contactService.getContact("0101010101").equals(contact));
	}
	@Test
	void addTestFail () {
		ContactService contactService = new ContactService();
		Contact contact = new Contact("0101010101", "Will", "Smith", "1234321231", "1234 Belair Blvd");
		contactService.addContact(contact);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Contact contact1 =new Contact("0101010101", "Will", "Smith", "1234321231", "1234 Belair Blvd");
			contactService.addContact(contact1);
		});
		
	}
	@Test
	void deleteTest () {
		ContactService contactService= new ContactService();
		Contact contact = new Contact("0101010102", "Will", "Smith", "1234321231", "1234 Belair Blvd");
		contactService.addContact(contact);
		contactService.deleteContact("0101010102");
		assertTrue(contactService.getContact("0101010102").equals(null));
	}
	
	 @Test
	 void updateContact () {
		 ContactService contactService= new ContactService();
		Contact contact = new Contact("0101010102", "Will", "Smith", "1234321231", "1234 Belair Blvd");
		contactService.addContact(contact);
		Contact updatedContact = new Contact("0101010102", "Will", "Smith", "1234321231", "I moved");
		contactService.updateContact(updatedContact);
		assertTrue(contactService.getContact("0101010102").getAddress().equals("I moved"));
	 }

}
