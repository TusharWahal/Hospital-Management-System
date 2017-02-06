package junitTest;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bean.Doctor;
import dao.DoctorDaoImpl;

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
	public void testInsertDoctor() throws ClassNotFoundException, SQLException {
		dd.deleteDoctor(1);
		Doctor doctor=new Doctor();
		doctor.setDoctorId(1);
		doctor.setDoctorAddress("Gurgaon");
		doctor.setDoctorName("Dr Batra");
		doctor.setDoctorPhoneNo(1234567890);
		doctor.setSpecialization("Hair Specialist");
		doctor.setTiming("5-6");
		doctor.setDepartmentId(0);
		assertTrue(dd.insertDoctor(doctor));
		
		
	}
	

	@Test
	public void testDeleteDoctor() throws ClassNotFoundException, SQLException {
		
		dd.deleteDoctor(1);
		Doctor doctor=new Doctor();
		doctor.setDoctorId(1);
		doctor.setDoctorAddress("Gurgaon");
		doctor.setDoctorName("Dr Batra");
		doctor.setDoctorPhoneNo(1234567890);
		doctor.setSpecialization("Hair Specialist");
		doctor.setTiming("5-6");
		doctor.setDepartmentId(0);
		dd.insertDoctor(doctor);
		assertTrue(dd.deleteDoctor(1));
	}

	@Test
	public void testUpdateDoctor() throws ClassNotFoundException, SQLException {
		
		dd.deleteDoctor(1);
		Doctor doctor=new Doctor();
		doctor.setDoctorId(1);
		doctor.setDoctorAddress("Gurgaon");
		doctor.setDoctorName("Dr Batra");
		doctor.setDoctorPhoneNo(1234567890);
		doctor.setSpecialization("Hair Specialist");
		doctor.setTiming("5-6");
		doctor.setDepartmentId(0);
		dd.insertDoctor(doctor);
		Doctor newdoctor=new Doctor();
		newdoctor.setDoctorId(1);
		newdoctor.setDoctorAddress("Mumbai");
		newdoctor.setDoctorName("Dr Batra");
		newdoctor.setDoctorPhoneNo(1876543210);
		newdoctor.setSpecialization("Hair Specialist");
		newdoctor.setTiming("5-6");
		newdoctor.setDepartmentId(0);
		assertTrue(dd.updateDoctor(1,newdoctor));
		
		//assertEquals(newdoctor.getDoctorAddress(), dd.displayDoctor(1).getDoctorAddress());
		
		
	}

	@Test
	public void testDisplayDoctor() throws ClassNotFoundException, SQLException {
		
		dd.deleteDoctor(1);
		Doctor doctor=new Doctor();
		doctor.setDoctorId(1);
		doctor.setDoctorAddress("Gurgaon");
		doctor.setDoctorName("Dr Batra");
		doctor.setDoctorPhoneNo(1234567890);
		doctor.setSpecialization("Hair Specialist");
		doctor.setTiming("5-6");
		doctor.setDepartmentId(0);
		dd.insertDoctor(doctor);
		
		assertEquals(doctor, dd.displayDoctor(1));
		
		
	}

	@Test
	public void testDisplayAllDoctors() throws ClassNotFoundException, SQLException {
		
		assertNotEquals(null, dd.displayAllDoctors());
		
	}

}
