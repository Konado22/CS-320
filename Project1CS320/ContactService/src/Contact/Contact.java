//declare class and variables in package for utilizing in other files
package Contact;

public class Contact {
	String contactID;
	String fName;
	String lName;
	String phone;
	String address;
	
	//constructor
	public Contact(String contactID, String fName, String lName, String phone, String address) {
		if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("contact id error");
		}
		
		if (fName == null || fName.length() > 10) {
			throw new IllegalArgumentException("first name error");
		}
		
		if (lName == null || lName.length() > 10) {
			throw new IllegalArgumentException("last name error");
		}
		
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("phone number error");
		}
		
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("address error");
		}
		this.contactID = contactID;
		this.fName = fName;
		this.lName = lName;
		this.phone = phone;
		this.address = address;
	}
	//setter and getter methods
	public String getContactID () {
		return contactID;
	}
	
//no setter for contact id as it cannot be updated per requirements
	public String getFName() {
		return fName;
	}
	
	public void setFName (String fName) {
		this.fName = fName;
	}
	
	public String getLName () {
		return lName;
	}
	
	public void setLName (String lName) {
		this.lName = lName;
	}
	
	public String getPhone () {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAddress () {
		return address;
	}
	
	public void setAddress (String address) {
		this.address = address;
	}

}
