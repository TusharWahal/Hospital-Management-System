package junitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.MedicalReportDaoImpl;

public class MedicalReportDaoImplTest {
	
	private MedicalReportDaoImpl mrd;
	@Before
	public void setUp() throws Exception {
		mrd=new MedicalReportDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		mrd=null;
	}

	@Test
	public void testInsertMedicalReport() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteMedicalReport() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateMedicalReport() {
		fail("Not yet implemented");
	}

	@Test
	public void testDisplayMedicalReport() {
		fail("Not yet implemented");
	}

	@Test
	public void testDisplayAllMedicalReports() {
		fail("Not yet implemented");
	}

}
