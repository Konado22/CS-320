package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Contact.Contact;

class TestContact {
	
	@Test
	void testContact() {
		Contact contact = new Contact("0101010101", "Will", "Smith", "1234321231", "1234 Belair Blvd");
		assertTrue(contact.getFName().equals("Will"));
		assertTrue(contact.getLName().equals("Smith"));
		assertTrue(contact.getContactID().equals("0101010101"));
		assertTrue(contact.getPhone().equals("1234321231"));
		assertTrue(contact.getAddress().equals("1234 Belair Blvd"));
	}
	
	@Test
	void illegalFname() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0011001100","THISISMORETHANTENCHARACTERS" ,"Smith" ,"1234567890" ,"1234 West Plaza" );
		});
	}
	@Test
	void testIllegalLName () {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0011001104","Bob" ,"Smithinsonfromwisconsin" ,"1234567890" ,"1234 West Plaza" );
		});
		}
	
	void testIllegalPhone() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0011001101","Forest" ,"Gump" ,"1234" ,"Somewhere in Alabama" );
		});
	}
	
	void testIllegalAddress() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("0011001102","Wild" ,"Child" ,"1234567890" ,"1234 West Plaza" );
		});
	}

}
