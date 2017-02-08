package junitTest;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bean.DischargeSummary;
import bean.Person;
import dao.DischargeSummaryDaoImpl;

public class DischargeSummaryDaoImplTest {

	private DischargeSummaryDaoImpl dsd;
	
	@Before
	public void setUp() throws Exception {
		dsd = new DischargeSummaryDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		dsd = null;
	}

	@Test
	public void testInsertDischargeSummary() throws ClassNotFoundException, SQLException {
		 dsd.deleteDischargeSummary(1);
		
		 DischargeSummary dischargeSummary = new DischargeSummary();
		 
		 dischargeSummary.setSerialNo(1);
		 dischargeSummary.setPatientId(1);
		 dischargeSummary.setOtId(1);
		 dischargeSummary.setBedNo(1);
		 String str="1994-12-12";
		 Date date=Date.valueOf(str);
		 dischargeSummary.setAdmissionDate(date);
		 dischargeSummary.setDischargeDate(date);
		 dischargeSummary.setDoctorId(1);
		 dischargeSummary.setHistory("Eye Patient");
		 dischargeSummary.setOnExamination("Check Up Successful");
		 dischargeSummary.setOperationDone("Eye CheckUp");
		 dischargeSummary.setOperativeFindings("No Issue");
		 dischargeSummary.setTreatmentGiven("Eye Drop");
		 dischargeSummary.setRecommendations("Regular CheckUp");
		 
		 assertTrue(dsd.insertDischargeSummary(dischargeSummary));
	}
	
	@Test(expected=SQLException.class)
	public void testInsertDischargeSummaryNegative() throws ClassNotFoundException, SQLException {
		

		DischargeSummary dischargeSummary = new DischargeSummary();
		 
		dischargeSummary.setSerialNo(2);
		 dischargeSummary.setPatientId(1);
		 dischargeSummary.setOtId(1);
		 dischargeSummary.setBedNo(1);
		 String str="1994-12-12";
		 Date date=Date.valueOf(str);
		 dischargeSummary.setAdmissionDate(date);
		 dischargeSummary.setDischargeDate(date);
		 dischargeSummary.setDoctorId(1);
		 dischargeSummary.setHistory("Eye Patient");
		 dischargeSummary.setOnExamination("Check Up Successful");
		 dischargeSummary.setOperationDone("Eye CheckUp");
		 dischargeSummary.setOperativeFindings("No Issue");
		 dischargeSummary.setTreatmentGiven("Eye Drop");
		 dischargeSummary.setRecommendations("Regular CheckUp");
		
		assertFalse(dsd.insertDischargeSummary(dischargeSummary));
	}

	@Test
	public void testDeleteDischargeSummaryNegative() throws ClassNotFoundException, SQLException {
		
		assertFalse(dsd.deleteDischargeSummary(16501));
	}
	
	@Test
	public void testDeleteDischargeSummary() throws ClassNotFoundException, SQLException {
		
		DischargeSummary dischargeSummary = new DischargeSummary();
		 
		dischargeSummary.setSerialNo(5);
		 dischargeSummary.setPatientId(1);
		 dischargeSummary.setOtId(1);
		 dischargeSummary.setBedNo(1);
		 String str="1994-12-12";
		 Date date=Date.valueOf(str);
		 dischargeSummary.setAdmissionDate(date);
		 dischargeSummary.setDischargeDate(date);
		 dischargeSummary.setDoctorId(1);
		 dischargeSummary.setHistory("Eye Patient");
		 dischargeSummary.setOnExamination("Check Up Successful");
		 dischargeSummary.setOperationDone("Eye CheckUp");
		 dischargeSummary.setOperativeFindings("No Issue");
		 dischargeSummary.setTreatmentGiven("Eye Drop");
		 dischargeSummary.setRecommendations("Regular CheckUp");
		 dsd.insertDischargeSummary(dischargeSummary);
		 
		 assertTrue(dsd.deleteDischargeSummary(dischargeSummary.getSerialNo()));
	}
	
	
	@Test
	public void testUpdateDischargeSummary() throws ClassNotFoundException, SQLException {
		
		dsd.deleteDischargeSummary(1);
		
		 DischargeSummary dischargeSummary = new DischargeSummary();
		 
		 dischargeSummary.setSerialNo(8);
		 dischargeSummary.setPatientId(1);
		 dischargeSummary.setOtId(1);
		 dischargeSummary.setBedNo(1);
		 String str="1994-12-12";
		 Date date=Date.valueOf(str);
		 dischargeSummary.setAdmissionDate(date);
		 dischargeSummary.setDischargeDate(date);
		 dischargeSummary.setDoctorId(1);
		 dischargeSummary.setHistory("Eye Patient");
		 dischargeSummary.setOnExamination("Check Up Successful");
		 dischargeSummary.setOperationDone("Eye CheckUp");
		 dischargeSummary.setOperativeFindings("No Issue");
		 dischargeSummary.setTreatmentGiven("Eye Drop");
		 dischargeSummary.setRecommendations("Regular CheckUp");
		 dsd.insertDischargeSummary(dischargeSummary);
			
		 DischargeSummary newDischargeSummary = new DischargeSummary();
		 
		 newDischargeSummary.setSerialNo(1);
		 newDischargeSummary.setPatientId(1);
		 newDischargeSummary.setOtId(1);
		 newDischargeSummary.setBedNo(1);
		 newDischargeSummary.setAdmissionDate(date);
		 newDischargeSummary.setDischargeDate(date);
		 newDischargeSummary.setDoctorId(1);
		 newDischargeSummary.setHistory("Leg Patient");
		 newDischargeSummary.setOnExamination("Check Up Successful");
		 newDischargeSummary.setOperationDone("Leg CheckUp");
		 newDischargeSummary.setOperativeFindings("No Issue");
		 newDischargeSummary.setTreatmentGiven("Massage");
		 newDischargeSummary.setRecommendations("Regular CheckUp");
		 
		 
		 assertTrue(dsd.updateDischargeSummary(3, newDischargeSummary));
	}
	@Test
	public void testUpdateDischargeSummaryNegative() throws ClassNotFoundException, SQLException
	{
		DischargeSummary dischargeSummary = new DischargeSummary();
		 
		 dischargeSummary.setSerialNo(1);
		 dischargeSummary.setPatientId(1);
		 dischargeSummary.setOtId(1);
		 dischargeSummary.setBedNo(1);
		 String str="1994-12-12";
		 Date date=Date.valueOf(str);
		 dischargeSummary.setAdmissionDate(date);
		 dischargeSummary.setDischargeDate(date);
		 dischargeSummary.setDoctorId(1);
		 dischargeSummary.setHistory("Eye Patient");
		 dischargeSummary.setOnExamination("Check Up Successful");
		 dischargeSummary.setOperationDone("Eye CheckUp");
		 dischargeSummary.setOperativeFindings("No Issue");
		 dischargeSummary.setTreatmentGiven("Eye Drop");
		 dischargeSummary.setRecommendations("Regular CheckUp");
		
		assertFalse(dsd.updateDischargeSummary(2343, dischargeSummary));
	}
	

	@Test
	public void testDisplayDischargeSummary() throws ClassNotFoundException, SQLException {
		 
		 //dsd.deleteDischargeSummary(1);
		
		 DischargeSummary dischargeSummary = new DischargeSummary();
		 
		 dischargeSummary.setSerialNo(1);
		 dischargeSummary.setPatientId(1);
		 dischargeSummary.setOtId(1);
		 dischargeSummary.setBedNo(1);
		 String str="1994-12-12";
		 Date date=Date.valueOf(str);
		 dischargeSummary.setAdmissionDate(date);
		 dischargeSummary.setDischargeDate(date);
		 dischargeSummary.setDoctorId(1);
		 dischargeSummary.setHistory("Eye Patient");
		 dischargeSummary.setOnExamination("Check Up Successful");
		 dischargeSummary.setOperationDone("Eye CheckUp");
		 dischargeSummary.setOperativeFindings("No Issue");
		 dischargeSummary.setTreatmentGiven("Eye Drop");
		 dischargeSummary.setRecommendations("Regular CheckUp");
		 dsd.insertDischargeSummary(dischargeSummary);
		 
		 assertEquals(dischargeSummary.getOperationDone(), dsd.displayDischargeSummary(1).getOperationDone());
	}
	
	@Test
	public void testDisplayDischargeSummaryNegative() throws ClassNotFoundException, SQLException {
		
		
		assertEquals(0,dsd.displayDischargeSummary(234234).getSerialNo());
		
	}

	@Test
	public void testDisplayAllDischargeSummarys() throws ClassNotFoundException, SQLException {
//		TreeSet<DischargeSummary> dischargeSummaryList=new TreeSet<DischargeSummary>();
//		
//		 dsd.deleteDischargeSummary(1);
//		
//
//		 DischargeSummary dischargeSummary = new DischargeSummary();
//		 
//		 dischargeSummary.setSerialNo(1);
//		 dischargeSummary.setPatientId(1);
//		 dischargeSummary.setOtId(1);
//		 dischargeSummary.setBedNo(1);
//		 dischargeSummary.setAdmissionDate(null);
//		 dischargeSummary.setDischargeDate(null);
//		 dischargeSummary.setDoctorId(1);
//		 dischargeSummary.setHistory("Eye Patient");
//		 dischargeSummary.setOnExamination("Check Up Successful");
//		 dischargeSummary.setOperationDone("Eye CheckUp");
//		 dischargeSummary.setOperativeFindings("No Issue");
//		 dischargeSummary.setTreatmentGiven("Eye Drop");
//		 dischargeSummary.setRecommendations("Regular CheckUp");
//
//		 
//		 dsd.insertDischargeSummary(dischargeSummary);
//		 
//		 assertEquals(dischargeSummary, dsd.displayAllDischargeSummarys());
		
		assertNotEquals(null, dsd.displayAllDischargeSummarys());
	}

}
