package junitTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bean.Doctor;
import bean.Medicine;
import dao.MedicineDaoimpl;

public class MedicineDaoImplTest {
	
	private MedicineDaoimpl md;

	@Before
	public void setUp() throws Exception {
		md=new MedicineDaoimpl();
	}

	@After
	public void tearDown() throws Exception {
		md=null;
	}

	@Test
	public void testInsertMedicine() throws ClassNotFoundException, SQLException {
		md.deleteMedicine(1);
		Medicine medicine = new Medicine();
		medicine.setsNo(1);
		medicine.setMedicineName("abc");
		medicine.setQuantity(2);
		medicine.setDosage("def");
		medicine.setPrice(123);
		medicine.setPatientId(123);
		medicine.setBillNo(12345);
		assertTrue(md.insertMedicine(medicine));
	}

	@Test(expected=SQLException.class)
	public void testInsertMedicineNegative() throws ClassNotFoundException, SQLException {	
		Medicine medicine = new Medicine();
		medicine.setsNo(1);
		medicine.setMedicineName("abc");
		medicine.setQuantity(2);
		medicine.setDosage("def");
		medicine.setPrice(123);
		medicine.setPatientId(123);
		medicine.setBillNo(12345);
		
		assertFalse(md.insertMedicine(medicine));
	}
	
	@Test
	public void testDeleteMedicine() throws ClassNotFoundException, SQLException {
		md.deleteMedicine(1);
		Medicine medicine = new Medicine();
		medicine.setsNo(1);
		medicine.setMedicineName("abc");
		medicine.setQuantity(2);
		medicine.setDosage("def");
		medicine.setPrice(123);
		medicine.setPatientId(123);
		medicine.setBillNo(12345);
		md.insertMedicine(medicine);
		assertTrue(md.deleteMedicine(1));
	}
	
	@Test
	public void testDeleteMedicineNegative() throws ClassNotFoundException, SQLException {
		assertFalse(md.deleteMedicine(12131));
	}

	@Test
	public void testUpdateMedicine() throws ClassNotFoundException, SQLException {
		md.deleteMedicine(1);
		Medicine medicine = new Medicine();
		medicine.setsNo(1);
		medicine.setMedicineName("abc");
		medicine.setQuantity(2);
		medicine.setDosage("def");
		medicine.setPrice(123);
		medicine.setPatientId(123);
		medicine.setBillNo(12345);
		md.insertMedicine(medicine);
		Medicine newmedicine = new Medicine();
		newmedicine.setsNo(1);
		newmedicine.setMedicineName("abc");
		newmedicine.setQuantity(2);
		newmedicine.setDosage("def");
		newmedicine.setPrice(123);
		newmedicine.setPatientId(123);
		newmedicine.setBillNo(12345);
		assertTrue(md.updateMedicine(1,newmedicine));

	}
	
	@Test
	public void testUpdateMedicineNegative() throws ClassNotFoundException, SQLException
	{
		Medicine newmedicine = new Medicine();
		newmedicine.setsNo(1);
		newmedicine.setMedicineName("abc");
		newmedicine.setQuantity(2);
		newmedicine.setDosage("def");
		newmedicine.setPrice(123);
		newmedicine.setPatientId(123);
		newmedicine.setBillNo(12345);
		
		assertFalse(md.updateMedicine(2343, newmedicine));
	}

	@Test
	public void testDisplayMedicine() throws ClassNotFoundException, SQLException {
		md.deleteMedicine(1);
		Medicine medicine = new Medicine();
		medicine.setsNo(1);
		medicine.setMedicineName("abc");
		medicine.setQuantity(2);
		medicine.setDosage("def");
		medicine.setPrice(123);
		medicine.setPatientId(123);
		medicine.setBillNo(12345);
		md.insertMedicine(medicine);
		
		assertEquals(medicine, md.displayMedicine(1));
	}

	@Test
	public void testDisplayMedicineNegative() throws ClassNotFoundException, SQLException {
		assertEquals(0,md.displayMedicine(234234).getsNo());
	}
	@Test
	public void testDisplayAllMedicines() throws ClassNotFoundException, SQLException {
		assertNotEquals(null, md.displayAllMedicines());
	}

}
