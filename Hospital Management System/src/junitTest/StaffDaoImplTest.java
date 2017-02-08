package junitTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bean.Staff;
import dao.StaffDaoImpl;

public class StaffDaoImplTest {

	private StaffDaoImpl sd;
	@Before
	public void setUp() throws Exception {
		sd=new StaffDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		sd=null;
	}

	@Test
	public void testInsertStaff() throws ClassNotFoundException, SQLException {
		sd.deleteStaff(1);
		Staff staff = new Staff();
		staff.setStaffId(1);
		staff.setStaffName("abc");
		staff.setSpecialization("def");
		staff.setTiming("123");
		staff.setStaffAddress("ghi");
		staff.setStaffPhoneNo(12345);
		staff.setStaffPassword("jkl");
		staff.setDepartmentId(1234);
		assertTrue(sd.insertStaff(staff));
	}
	
	@Test(expected=SQLException.class)
	public void tesInsertStaffNegative() throws ClassNotFoundException, SQLException{
		
		
		Staff staff = new Staff();
		staff.setStaffId(0);
		staff.setStaffName("abc");
		staff.setSpecialization("def");
		staff.setTiming("123");
		staff.setStaffAddress("ghi");
		staff.setStaffPhoneNo(12345);
		staff.setStaffPassword("jkl");
		staff.setDepartmentId(1234);
		assertFalse(sd.insertStaff(staff));
		
	}
	
	@Test
	public void testDeleteStaffNegative() throws ClassNotFoundException, SQLException
	{
		assertFalse(sd.deleteStaff(2423424));
	}

	@Test
	public void testDeleteStaff() throws ClassNotFoundException, SQLException {
		sd.deleteStaff(1);
		Staff staff = new Staff();
		staff.setStaffId(1);
		staff.setStaffName("abc");
		staff.setSpecialization("def");
		staff.setTiming("123");
		staff.setStaffAddress("ghi");
		staff.setStaffPhoneNo(12345);
		staff.setStaffPassword("jkl");
		staff.setDepartmentId(1234);
		sd.insertStaff(staff);
		assertTrue(sd.deleteStaff(1));
	}
	
	@Test
	public void testUpdateStaffNegative() throws ClassNotFoundException, SQLException
	{
		Staff newstaff = new Staff();

		newstaff.setStaffName("abc");
		newstaff.setSpecialization("def");
		newstaff.setTiming("123");
		newstaff.setStaffAddress("ghi");
		newstaff.setStaffPhoneNo(12345);
		newstaff.setStaffPassword("jkl");
		newstaff.setDepartmentId(1234);
		assertTrue(sd.updateStaff(23423,newstaff));
		
	}

	@Test
	public void testUpdateStaff() throws ClassNotFoundException, SQLException {
		sd.deleteStaff(1);
		Staff staff = new Staff();
		staff.setStaffId(1);
		staff.setStaffName("abc");
		staff.setSpecialization("def");
		staff.setTiming("123");
		staff.setStaffAddress("ghi");
		staff.setStaffPhoneNo(12345);
		staff.setStaffPassword("jkl");
		staff.setDepartmentId(1234);
		sd.insertStaff(staff);
		Staff newstaff = new Staff();
		newstaff.setStaffId(1);
		newstaff.setStaffName("abc");
		newstaff.setSpecialization("def");
		newstaff.setTiming("123");
		newstaff.setStaffAddress("ghi");
		newstaff.setStaffPhoneNo(12345);
		newstaff.setStaffPassword("jkl");
		newstaff.setDepartmentId(1234);
		assertTrue(sd.updateStaff(1,newstaff));
	}

	@Test
	public void testDisplayStaffNegative() throws ClassNotFoundException, SQLException
	{
		assertEquals(0, sd.displayStaff(324).getStaffId());
	}
	@Test
	public void testDisplayStaff() throws ClassNotFoundException, SQLException {
		sd.deleteStaff(1);
		Staff staff = new Staff();
		staff.setStaffId(1);
		staff.setStaffName("abc");
		staff.setSpecialization("def");
		staff.setTiming("123");
		staff.setStaffAddress("ghi");
		staff.setStaffPhoneNo(12345);
		staff.setStaffPassword("jkl");
		staff.setDepartmentId(1234);
		sd.insertStaff(staff);
		
		assertEquals(staff, sd.displayStaff(1));
	}

	@Test
	public void testDisplayAllStaffs() throws ClassNotFoundException, SQLException {
		assertNotEquals(null, sd.displayAllStaffs());
	}

}
