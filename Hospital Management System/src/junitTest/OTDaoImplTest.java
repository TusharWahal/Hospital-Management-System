package junitTest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bean.MedicalReport;
import bean.OT;
import dao.MedicalReportDaoImpl;
import dao.OTDaoImpl;

public class OTDaoImplTest {

	private OTDaoImpl otd;
	@Before
	public void setUp() throws Exception {
		otd=new OTDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		otd=null;
	}

	@Test
	public void testInsertOT() throws ClassNotFoundException, SQLException, IOException {
		otd.deleteOT(0);
		OT ot = new OT();
		ot.setOtId(0);
		ot.setDescription("abc");
		ot.setEquipments("def");
		ot.setPatientId(123);
		ot.setStaffId(456);
		ot.setDoctorId(789);
		assertTrue(otd.insertOT(ot));
	}

	@Test(expected=SQLException.class)
	public void testInsertMedicalReportNegative() throws ClassNotFoundException, SQLException, IOException {
	
		OT ot = new OT();
		ot.setOtId(0);
		ot.setDescription("abc");
		ot.setEquipments("def");
		ot.setPatientId(123);
		ot.setStaffId(456);
		ot.setDoctorId(789);
		
		assertFalse(otd.insertOT(ot));
	}	
	
	@Test
	public void testDeleteOT() throws ClassNotFoundException, SQLException, IOException {
		otd.deleteOT(0);
		OT ot = new OT();
		ot.setOtId(0);
		ot.setDescription("abc");
		ot.setEquipments("def");
		ot.setPatientId(123);
		ot.setStaffId(456);
		ot.setDoctorId(789);
		otd.insertOT(ot);
		assertTrue(otd.deleteOT(0));
	}
	
	@Test
	public void testDeleteOTNegative() throws ClassNotFoundException, SQLException, IOException {
		assertFalse(otd.deleteOT(12131));
	}

	@Test
	public void testUpdateOT() throws ClassNotFoundException, SQLException, IOException {
		otd.deleteOT(0);
		OT ot = new OT();
		ot.setOtId(0);
		ot.setDescription("abc");
		ot.setEquipments("def");
		ot.setPatientId(123);
		ot.setStaffId(456);
		ot.setDoctorId(789);
		otd.insertOT(ot);
	    OT newot = new OT();
	    newot.setDescription("abc");
		newot.setEquipments("def");
		newot.setPatientId(123);
		newot.setStaffId(456);
		newot.setDoctorId(789);
		assertTrue(otd.updateOT(0,newot));
	}
	
	@Test
	public void testUpdateMedicalReportNegative() throws ClassNotFoundException, SQLException, IOException
	{
	
		OT newot = new OT();
	    newot.setDescription("abc");
		newot.setEquipments("def");
		newot.setPatientId(123);
		newot.setStaffId(456);
		newot.setDoctorId(789);
		
		assertFalse(otd.updateOT(2343, newot));
	}


	@Test
	public void testDisplayOT() throws ClassNotFoundException, SQLException, IOException {
		otd.deleteOT(0);
		OT ot = new OT();
		ot.setOtId(0);
		ot.setDescription("abc");
		ot.setEquipments("def");
		ot.setPatientId(123);
		ot.setStaffId(456);
		ot.setDoctorId(789);
		otd.insertOT(ot);
		
		assertEquals(ot, otd.displayOT(0));
	}

	@Test
	public void testDisplayOTNegative() throws ClassNotFoundException, SQLException, IOException {
		assertEquals(0,otd.displayOT(234234).getOtId());	
	}
	
	@Test
	public void testDisplayAllOTs() throws ClassNotFoundException, SQLException, IOException {
		assertNotEquals(null, otd.displayAllOTs());
	}

}
