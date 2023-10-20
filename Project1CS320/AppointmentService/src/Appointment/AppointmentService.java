package Appointment;
import java.util.HashMap;
import java.util.Map;


public class AppointmentService {
	
	private static AppointmentService reference = new AppointmentService();	
	private final Map<String,Appointment> appointmentMap;
	public AppointmentService () {
		
		this.appointmentMap = new HashMap < String, Appointment> ();
		
	}
	
	public  static AppointmentService getService() {
		
		return reference;
		
	}
	
	public Appointment getAppointment(String appointmentID) {
		
		return appointmentMap.get(appointmentID);
		 
	}
	
	public void addAppointment (Appointment appointment) {
		
		if (!appointmentMap.containsKey(appointment.appointmentID)) {
			
			appointmentMap.put(appointment.getAppointmentID(), appointment);
			
		}
		
		else {
			
			throw new IllegalArgumentException("duplicate id found please check and try again");
			
		}
	
	}
	
	public boolean deleteAppointment (String appointmentID) {
		
		return appointmentMap.remove(appointmentID) != null;
			
		}
	
} 
