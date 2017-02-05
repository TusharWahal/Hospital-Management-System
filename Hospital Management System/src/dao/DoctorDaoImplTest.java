package dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bean.Doctor;

public class DoctorDaoImplTest {
	
	private DoctorDaoImpl dd;

	@Before
	public void setUp() throws Exception {
		dd=new DoctorDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		dd=null;
	}

	@Test
	public void testInsertDoctor() {
		Doctor doctor=new Doctor();
		doctor.setDoctorId(1);
		doctor.setDoctorAddress("Gurgaon");
		doctor.setDoctorName("Dr Batra");
		doctor.setDoctorPhoneNo(1234567890);
		doctor.setSpecialization("Hair Specialist");
		doctor.setTiming("5-6");
		dd.insertDoctor(doctor);
		
		assertEquals(doctor, dd.displayDoctor(1));
	}
	

	@Test
	public void testDeleteDoctor() {
		Doctor doctor=new Doctor();
		doctor.setDoctorId(1);
		doctor.setDoctorAddress("Gurgaon");
		doctor.setDoctorName("Dr Batra");
		doctor.setDoctorPhoneNo(1234567890);
		doctor.setSpecialization("Hair Specialist");
		doctor.setTiming("5-6");
		dd.insertDoctor(doctor);
		assertEquals(doctor,dd.deleteDoctor(1));
	}

	@Test
	public void testUpdateDoctor() {
		Doctor doctor=new Doctor();
		doctor.setDoctorId(1);
		doctor.setDoctorAddress("Gurgaon");
		doctor.setDoctorName("Dr Batra");
		doctor.setDoctorPhoneNo(1234567890);
		doctor.setSpecialization("Hair Specialist");
		doctor.setTiming("5-6");
		dd.insertDoctor(doctor);
		Doctor newdoctor=new Doctor();
		newdoctor.setDoctorId(1);
		newdoctor.setDoctorAddress("Mumbai");
		newdoctor.setDoctorName("Dr Batra");
		newdoctor.setDoctorPhoneNo(1876543210);
		newdoctor.setSpecialization("Hair Specialist");
		newdoctor.setTiming("5-6");
		dd.updateDoctor(1,newdoctor);
		
		assertEquals(newdoctor, dd.displayDoctor(1));
		
	}

	@Test
	public void testDisplayDoctor() {
		
		Doctor doctor=new Doctor();
		doctor.setDoctorId(1);
		doctor.setDoctorAddress("Gurgaon");
		doctor.setDoctorName("Dr Batra");
		doctor.setDoctorPhoneNo(1234567890);
		doctor.setSpecialization("Hair Specialist");
		doctor.setTiming("5-6");
		dd.insertDoctor(doctor);
		
		assertEquals(doctor, dd.displayDoctor(1));
		
	}

	@Test
	public void testDisplayAllDoctors() {
		
		assertNotEquals(null, dd.displayAllDoctors());
	}

}
