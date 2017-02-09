package junitTest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

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
	public void testInsertReception() throws ClassNotFoundException, SQLException, IOException {
		dd.deleteReception(1);
		Reception reception=new Reception();
		reception.setRegNo(1);
		reception.setPersonId("ABCD");
		reception.setPurpose("asjkdhasd");
		reception.setPayment(12345);
		reception.setDoctorId(0);
		String str="2015-03-31";  
	    Date date=Date.valueOf(str);
		reception.setAppointmentDate(date);
		
		assertTrue(dd.insertReception(reception));
		
		
	}
	

	@Test
	public void testDeleteReception() throws ClassNotFoundException, SQLException, IOException {
		
		dd.deleteReception(1);
		Reception reception=new Reception();
		reception.setRegNo(1);
		reception.setPersonId("ABCD");
		reception.setPurpose("Dr Batra");
		reception.setPayment(0);
		reception.setDoctorId(0);
		String str="2015-03-31";  
	    Date date=Date.valueOf(str);
		reception.setAppointmentDate(date);
		
		dd.insertReception(reception);
		assertTrue(dd.deleteReception(1));
	}

	@Test
	public void testUpdateReception() throws ClassNotFoundException, SQLException, IOException {
		
		dd.deleteReception(1);
		Reception reception=new Reception();
		reception.setRegNo(1);
		reception.setPersonId("ABCD");
		reception.setPurpose("Dr Batra");
		reception.setPayment(0);
		reception.setDoctorId(0);
		String str="2015-03-31";  
	    Date date=Date.valueOf(str);
		reception.setAppointmentDate(date);
		
		dd.insertReception(reception);
		
		Reception newreception=new Reception();
		
		newreception.setRegNo(1);
		newreception.setPersonId("ABCD");
		newreception.setPurpose("Dr Batra");
		newreception.setPayment(18);
		
		assertTrue(dd.updateReception(1,newreception));
		
		//assertEquals(newreception.getReceptionAddress(), dd.displayReception(1).getReceptionAddress());
		
		
	}

	@Test
	public void testDisplayReception() throws ClassNotFoundException, SQLException, IOException {
		
		dd.deleteReception(1);
		Reception reception=new Reception();
		reception.setRegNo(1);
		reception.setPersonId("ABCD");
		reception.setPurpose("Dr Batra");
		reception.setPayment(0);
		reception.setDoctorId(0);
		String str="2015-03-31";  
	    Date date=Date.valueOf(str);
		reception.setAppointmentDate(date);
		
		dd.insertReception(reception);
		
		assertEquals(reception, dd.displayReception(1));
		
		
	}

	@Test
	public void testDisplayAllReceptions() throws ClassNotFoundException, SQLException, IOException {
		
		assertNotEquals(null, dd.displayAllReceptions());
		
	}

}
