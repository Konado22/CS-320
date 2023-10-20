package Contact;
import java.util.HashMap;
import java.util.Map;



//import packages required for arrays
public class ContactService {
	private static ContactService reference = new ContactService();
	 private final Map<String, Contact> contacts;
	public ContactService() {
       this.contacts = new HashMap<String,Contact>();
   }
	
	//add contact
	  public static ContactService getService() {
	        return reference;
	    }
	    
	    public boolean addContact(Contact contact) {
	        boolean isSuccess = false;
	        
	        if(!contacts.containsKey(contact.getContactID())) {
	        	contacts.put(contact.getContactID(), contact);
	            isSuccess = true;
	        }
	        return isSuccess;
	    }
	    
	    public boolean deleteContact(String contactID) {
	        return contacts.remove(contactID) != null;
	    }
	    
	    public Contact getContact(String taskId) {
	        return contacts.get(taskId);
	    }
		public void updateContact(Contact contact) {
				if (contacts.containsKey(contact.contactID) ) {
					contacts.put(contact.getContactID(), contact);
		}}
}