package junitTest;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bean.Bill;

import dao.BillDaoImpl;

public class BillDaoImplTest {

	private BillDaoImpl bd;
	@Before
	public void setUp() throws Exception {
		bd=new BillDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		bd=null;
	}

	@Test
	public void testInsertBill() throws ClassNotFoundException, SQLException {
		bd.deleteBill(1);
	}

	@Test
	public void testDeleteBill() throws ClassNotFoundException, SQLException {
		 bd.deleteBill(1);
		 Bill bill=new Bill();
		 bill.setNumber(1);
		 bill.setDoctorVisit(1);
		 bill.setBedCharges(1);
		 bill.setTests(1);
		 bill.setMedicines(1);
		 
		 assertTrue(bd.insertBill(bill));
	}

	@Test
	public void testUpdateBill() throws ClassNotFoundException, SQLException {
		bd.deleteBill(1);
		
		Bill bill=new Bill();
		 bill.setNumber(1);
		 bill.setDoctorVisit(1);
		 bill.setBedCharges(1);
		 bill.setTests(1);
		 bill.setMedicines(1);
		 bd.insertBill(bill);
		 
		 Bill newBill=new Bill();
		 newBill.setNumber(1);
		 newBill.setDoctorVisit(2);
		 newBill.setBedCharges(5);
		 newBill.setTests(1);
		 newBill.setMedicines(3);
		 
		 assertEquals(newBill.getDoctorVisit(), bd.displayBill(1).getDoctorVisit());
		 
		 
		 
		
	}

	@Test
	public void testDisplayBill() throws ClassNotFoundException, SQLException {

		bd.deleteBill(1);
		
		 Bill bill=new Bill();
		 bill.setNumber(1);
		 bill.setDoctorVisit(1);
		 bill.setBedCharges(1);
		 bill.setTests(1);
		 bill.setMedicines(1);
		 bd.insertBill(bill);
		 
		 assertEquals(bill, bd.displayBill(1));
	}

	@Test
	public void testDisplayAllBills() throws ClassNotFoundException, SQLException {
		
		TreeSet<Bill> billList=new TreeSet<Bill>();
		
		 bd.deleteBill(1);
		
		 Bill bill=new Bill();
		 bill.setNumber(1);
		 bill.setDoctorVisit(1);
		 bill.setBedCharges(1);
		 bill.setTests(1);
		 bill.setMedicines(1);
		 billList.add(bill);
		 
		 assertEquals(bill, bd.displayAllBills());
		
	}

}
