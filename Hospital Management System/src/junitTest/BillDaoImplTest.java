package junitTest;

import static org.junit.Assert.*;

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
	public void testInsertBill() {
		bd.deleteBill(1);
	}

	@Test
	public void testDeleteBill() {
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
	public void testUpdateBill() {
		fail("Not yet implemented");
	}

	@Test
	public void testDisplayBill() {
		fail("Not yet implemented");
	}

	@Test
	public void testDisplayAllBills() {
		fail("Not yet implemented");
	}

}
