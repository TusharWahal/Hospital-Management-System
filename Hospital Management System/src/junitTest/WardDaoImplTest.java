package junitTest;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bean.Ward;
import dao.WardDaoImpl;

public class WardDaoImplTest {

	private WardDaoImpl wd;
	@Before
	public void setUp() throws Exception {
		wd=new WardDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		wd=null;
	}

	@Test
	public void testInsertWard() throws ClassNotFoundException, SQLException {
		wd.deleteWard(1);
		Ward ward = new Ward();
		ward.setBedNo(1);
		ward.setType("abc");
		ward.setLocation("def");
		String str="2015-03-31";  
	    Date dateAdmitted=Date.valueOf(str);
		ward.setDateAdmitted(dateAdmitted);
		str="2015-03-31";  
	    Date dateDischarged=Date.valueOf(str);
	    ward.setDateAdmitted(dateDischarged);
	    ward.setStaffId(123);
	    ward.setPatientId(456);
		assertTrue(wd.insertWard(ward));
	}

	@Test
	public void testDeleteWard() throws ClassNotFoundException, SQLException {
		wd.deleteWard(1);
		Ward ward = new Ward();
		ward.setBedNo(1);
		ward.setType("abc");
		ward.setLocation("def");
		String str="2015-03-31";  
	    Date dateAdmitted=Date.valueOf(str);
		ward.setDateAdmitted(dateAdmitted);
		str="2015-03-31";  
	    Date dateDischarged=Date.valueOf(str);
	    ward.setDateAdmitted(dateDischarged);
	    ward.setStaffId(123);
	    ward.setPatientId(456);
		wd.insertWard(ward);
	}

	@Test
	public void testUpdateWard() throws ClassNotFoundException, SQLException {
		wd.deleteWard(1);
		Ward ward = new Ward();
		ward.setBedNo(1);
		ward.setType("abc");
		ward.setLocation("def");
		String str="2015-03-31";  
	    Date dateAdmitted=Date.valueOf(str);
		ward.setDateAdmitted(dateAdmitted);
		str="2015-03-31";  
	    Date dateDischarged=Date.valueOf(str);
	    ward.setDateAdmitted(dateDischarged);
	    ward.setStaffId(123);
	    ward.setPatientId(456);
		wd.insertWard(ward);
		Ward newward = new Ward();
		newward.setBedNo(1);
		newward.setType("abc");
		newward.setLocation("def");
		str="2015-03-31";  
	    dateAdmitted=Date.valueOf(str);
		newward.setDateAdmitted(dateAdmitted);
		str="2015-03-31";  
	    dateDischarged=Date.valueOf(str);
	    newward.setDateAdmitted(dateDischarged);
	    newward.setStaffId(123);
	    newward.setPatientId(456);
	    assertTrue(wd.updateWard(1,newward));
		
	}

	@Test
	public void testDisplayWard() throws ClassNotFoundException, SQLException {
		wd.deleteWard(1);
		Ward ward = new Ward();
		ward.setBedNo(1);
		ward.setType("abc");
		ward.setLocation("def");
		String str="2015-03-31";  
	    Date dateAdmitted=Date.valueOf(str);
		ward.setDateAdmitted(dateAdmitted);
		str="2015-03-31";  
	    Date dateDischarged=Date.valueOf(str);
	    ward.setDateAdmitted(dateDischarged);
	    ward.setStaffId(123);
	    ward.setPatientId(456);
		wd.insertWard(ward);
		
		assertEquals(ward, wd.displayWard(1));
	}

	@Test
	public void testDisplayAllWards() throws ClassNotFoundException, SQLException {
		assertNotEquals(null, wd.displayAllWards());
	}

}
