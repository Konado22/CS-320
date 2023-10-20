package Appointment;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//declare imports

public class Appointment {
	SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
	String appointmentID;
	Date date;
	String description;
	//class variables
	public Appointment(String appointmentID, String appointmentdate, String description) {
		
		Date dateformatter;
		try {
			dateformatter = dateformat.parse(appointmentdate);
		} catch (ParseException e) {
			
			throw new IllegalArgumentException("invalid date format please try: dd/mm/yyyy");
		}
		
		if (appointmentID == null || appointmentID.length() > 10 ) {
			
			throw new IllegalArgumentException("invalid appointmentID submitted");
		}
		
		if (dateformatter.before(new Date())) {
			
			throw new IllegalArgumentException("Invalid date submitted");
		}
	
	
		if (description == null || description.length() > 51) {
			
			throw new IllegalArgumentException("invalid description");
			
		}
		this.appointmentID = appointmentID;
		this.date = dateformatter;
		this.description = description;
		
		
	}
	//constructor with edge cases 
	
	public String getAppointmentID () {
		
		return appointmentID;
		
	}
	
	 public void setAppointmentID(String appointmentID) {
		 
		 this.appointmentID = appointmentID;
		 
	 }
	 
	 public Date getDate() {
		 
		 return date;
	 }
	 
	 public void setDate(Date date) {
		 
		 this.date = date;
		 
	 }
	 
	 public String getDescription () {
		 
		 return description;
		 
	 }
	 
	 public void setDescription (String description) {
		 
		 this.description = description;
		 
	 }
	 //setter getter methods for class
	}