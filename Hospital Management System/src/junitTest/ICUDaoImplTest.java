package junitTest;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bean.ICU;
import dao.ICUDaoImpl;

public class ICUDaoImplTest {

	ICUDaoImpl icud;
	
	@Before
	public void setUp() throws Exception {
		icud = new ICUDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		icud = null;
	}

	@Test
	public void testInsertICU() throws ClassNotFoundException, SQLException {
		icud.deleteICU(1);
		
		ICU icu = new ICU();
		
		icu.setIcuId(1);
		icu.setExamination("Heart");
		icu.setInvestigations("Heart");
		icu.setOperationDescription("Fine");
		 
		 assertTrue(icud.insertICU(icu));
	}

	@Test
	public void testDeleteICU() throws ClassNotFoundException, SQLException {

		ICU icu = new ICU();
		
		icu.setIcuId(1);
		icu.setExamination("Heart");
		icu.setInvestigations("Heart");
		icu.setOperationDescription("Fine");
		 
		 assertTrue(icud.deleteICU(icu.getIcuId()));
	}

	@Test
	public void testUpdateICU() throws ClassNotFoundException, SQLException {

		icud.deleteICU(1);
		
		ICU icu = new ICU();
		
		icu.setIcuId(1);
		icu.setExamination("Heart");
		icu.setInvestigations("Heart");
		icu.setOperationDescription("Fine");
		

		ICU newIcu = new ICU();
		
		newIcu.setIcuId(1);
		newIcu.setExamination("Heart");
		newIcu.setInvestigations("Heart");
		newIcu.setOperationDescription("Fine");
		 
		 assertTrue(icud.updateICU(1, newIcu));
	}

	@Test
	public void testDisplayICU() throws ClassNotFoundException, SQLException {

		icud.deleteICU(1);
		
		ICU icu = new ICU();
		
		icu.setIcuId(1);
		icu.setExamination("Heart");
		icu.setInvestigations("Heart");
		icu.setOperationDescription("Fine");
		
		icud.insertICU(icu);
		
		assertEquals(icu, icud.displayICU(1));
	}

	@Test
	public void testDisplayAllICUs() throws ClassNotFoundException, SQLException {
		TreeSet<ICU> icuList=new TreeSet<ICU>();
		

		icud.deleteICU(1);
		
		ICU icu = new ICU();
		
		icu.setIcuId(1);
		icu.setExamination("Heart");
		icu.setInvestigations("Heart");
		icu.setOperationDescription("Fine");
		icuList.add(icu);
		
		icud.insertICU(icu);
		
		assertEquals(icuList, icud.displayAllICUs());
	}

}
