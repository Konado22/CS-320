package Test;
import Appointment.Appointment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Appointment.AppointmentService;
class AppointmentServiceTest {

	@Test
	void appointmentServiceAdd() {
		
		AppointmentService testService = new AppointmentService();
		Appointment testAppointment = new Appointment("0000000001","01/01/2024", "This is my first Appointment");
		testService.addAppointment(testAppointment);
		Assertions.assertTrue(testService.getAppointment("0000000001").equals(testAppointment));
	}
	
	@Test
	void appointmentServiceAddFail() {
		AppointmentService testService = new AppointmentService();
		Appointment testAppointment = new Appointment("0000000001","01/01/2024", "This is my first Appointment");
		Assertions.assertTrue(testService.getAppointment(testAppointment.getAppointmentID()) == null );
	}
	
	@Test
	void appointmentServiceDelete() {
		
		AppointmentService testService = new AppointmentService();
		Appointment testAppointment = new Appointment("0000000001","01/01/2024", "This is my first Appointment");
		testService.addAppointment(testAppointment);
		testService.deleteAppointment("0000000001");
		Assertions.assertTrue(testService.getAppointment(testAppointment.getAppointmentID()) == null);
	}
	
	@Test
	void appointmentServiceDeleteFail() {

		AppointmentService testService = new AppointmentService();
		Appointment testAppointment = new Appointment("0000000001","01/01/2024", "This is my first Appointment");
		Appointment testAppointment2 = new Appointment("0000000002","01/02/2024", "This is my second Appointment");
		testService.addAppointment(testAppointment);
		Assertions.assertFalse(testService.deleteAppointment(testAppointment2.getAppointmentID()));
	}

}
