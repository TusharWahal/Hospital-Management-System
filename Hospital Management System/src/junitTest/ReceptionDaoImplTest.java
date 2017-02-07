package junitTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bean.Reception;
import dao.ReceptionDaoImpl;

public class ReceptionDaoImplTest {

	private ReceptionDaoImpl dd;

	@Before
	public void setUp() throws Exception {
		dd=new ReceptionDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		dd=null;
	}

	@Test
	public void testInsertReception() throws ClassNotFoundException, SQLException {
		dd.deleteReception(1);
		Reception reception=new Reception();
		reception.setRegNo(1);
		reception.setPersonId("Gurgaon");
		reception.setPurpose("Dr Batra");
		reception.setPayment(1234567890);
		
		assertTrue(dd.insertReception(reception));
		
		
	}
	

	@Test
	public void testDeleteReception() throws ClassNotFoundException, SQLException {
		
		dd.deleteReception(1);
		Reception reception=new Reception();
		reception.setRegNo(1);
		reception.setPersonId("Gurgaon");
		reception.setPurpose("Dr Batra");
		reception.setPayment(1234567890);
		
		dd.insertReception(reception);
		assertTrue(dd.deleteReception(1));
	}

	@Test
	public void testUpdateReception() throws ClassNotFoundException, SQLException {
		
		dd.deleteReception(1);
		Reception reception=new Reception();
		reception.setRegNo(1);
		reception.setPersonId("Gurgaon");
		reception.setPurpose("Dr Batra");
		reception.setPayment(1234567890);
		
		dd.insertReception(reception);
		
		Reception newreception=new Reception();
		
		newreception.setRegNo(1);
		newreception.setPersonId("Mumbai");
		newreception.setPurpose("Dr Batra");
		newreception.setPayment(1876543210);
		
		assertTrue(dd.updateReception(1,newreception));
		
		//assertEquals(newreception.getReceptionAddress(), dd.displayReception(1).getReceptionAddress());
		
		
	}

	@Test
	public void testDisplayReception() throws ClassNotFoundException, SQLException {
		
		dd.deleteReception(1);
		Reception reception=new Reception();
		reception.setRegNo(1);
		reception.setPersonId("Gurgaon");
		reception.setPurpose("Dr Batra");
		reception.setPayment(1234567890);
		
		dd.insertReception(reception);
		
		assertEquals(reception, dd.displayReception(1));
		
		
	}

	@Test
	public void testDisplayAllReceptions() throws ClassNotFoundException, SQLException {
		
		assertNotEquals(null, dd.displayAllReceptions());
		
	}

}
