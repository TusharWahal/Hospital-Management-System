package junitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
		fail("Not yet implemented");
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
