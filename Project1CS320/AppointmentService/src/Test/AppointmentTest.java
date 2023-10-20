package Test;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Appointment.Appointment;

class AppointmentTest {
//test class
	@SuppressWarnings("unlikely-arg-type") //supressing formatting warning to test date
	@Test
	void appointmentTest() {
		SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
		String dateformatter;
		Appointment testAppointment = new Appointment("0000000001", "01/02/2024", "This is my first appointment");
		dateformatter = formatter.format(testAppointment.getDate());
		Assertions.assertTrue(testAppointment.getAppointmentID().equals("0000000001"));
		System.out.print(dateformatter);
		Assertions.assertTrue(formatter.format(testAppointment.getDate()).equals("01/02/2024"));
		
		
		Assertions.assertTrue(testAppointment.getDescription().equals("This is my first appointment"));
		
	}

	@Test
	void appointmentIDFail() {
//test id fail
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		Appointment testAppointment = new Appointment("000000000123423232", "01/02/2024", "This is my first appointment");
		});
		
	}
	//test id null
	@Test
	void appointmentIDnull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment testAppointment = new Appointment( null , "1/2/2024", "This is my first appointment");
			});
	}
	//test date fail
	@Test
	void appointmentDateFail() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment testAppointment = new Appointment("0000000001", "0221/02/2024", "This is my first appointment");
			});
	}
	//test date before
	@Test
	void appointmentDateBefore() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment testAppointment = new Appointment("0000000001", "01/02/1900", "This is my first appointment");
			});
	}
	//test date null
	@Test
	void appointmentDatenull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			Appointment testAppointment = new Appointment("0000000001", null , "This is my first appointment");
			});
	}
	//test description fail
	@Test
	void appointmentDescriptionFail() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment testAppointment = new Appointment("0000000001", "1/2/2024", "222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222This is my first appointment");
			});
	}
	//test description null
	@Test
	void appointmentDescriptionnull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment testAppointment = new Appointment("0000000001", "1/2/2024", null);
			});
	}
}
