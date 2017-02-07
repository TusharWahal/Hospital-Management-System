package junitTest;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bean.DischargeSummary;
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
		 dischargeSummary.setAdmissionDate(null);
		 dischargeSummary.setDischargeDate(null);
		 dischargeSummary.setHistory("Eye Patient");
		 dischargeSummary.setOnExamination("Check Up Successful");
		 dischargeSummary.setOperationDone("Eye CheckUp");
		 dischargeSummary.setOperativeFindings("No Issue");
		 dischargeSummary.setTreatmentGiven("Eye Drop");
		 dischargeSummary.setRecommendations("Regular CheckUp");
		 
		 assertTrue(dsd.insertDischargeSummary(dischargeSummary));
	}

	@Test
	public void testDeleteDischargeSummary() throws ClassNotFoundException, SQLException {
		DischargeSummary dischargeSummary = new DischargeSummary();
		 
		 dischargeSummary.setSerialNo(1);
		 dischargeSummary.setAdmissionDate(null);
		 dischargeSummary.setDischargeDate(null);
		 dischargeSummary.setHistory("Eye Patient");
		 dischargeSummary.setOnExamination("Check Up Successful");
		 dischargeSummary.setOperationDone("Eye CheckUp");
		 dischargeSummary.setOperativeFindings("No Issue");
		 dischargeSummary.setTreatmentGiven("Eye Drop");
		 dischargeSummary.setRecommendations("Regular CheckUp");
		 
		 assertTrue(dsd.deleteDischargeSummary(dischargeSummary.getSerialNo()));
	}

	@Test
	public void testUpdateDischargeSummary() throws ClassNotFoundException, SQLException {
		
		dsd.deleteDischargeSummary(1);
		
		 DischargeSummary dischargeSummary = new DischargeSummary();
		 
		 dischargeSummary.setSerialNo(1);
		 dischargeSummary.setAdmissionDate(null);
		 dischargeSummary.setDischargeDate(null);
		 dischargeSummary.setHistory("Eye Patient");
		 dischargeSummary.setOnExamination("Check Up Successful");
		 dischargeSummary.setOperationDone("Eye CheckUp");
		 dischargeSummary.setOperativeFindings("No Issue");
		 dischargeSummary.setTreatmentGiven("Eye Drop");
		 dischargeSummary.setRecommendations("Regular CheckUp");
			
		 DischargeSummary newDischargeSummary = new DischargeSummary();
		 
		 newDischargeSummary.setSerialNo(1);
		 newDischargeSummary.setAdmissionDate(null);
		 newDischargeSummary.setDischargeDate(null);
		 newDischargeSummary.setHistory("Leg Patient");
		 newDischargeSummary.setOnExamination("Check Up Successful");
		 newDischargeSummary.setOperationDone("Leg CheckUp");
		 newDischargeSummary.setOperativeFindings("No Issue");
		 newDischargeSummary.setTreatmentGiven("Massage");
		 newDischargeSummary.setRecommendations("Regular CheckUp");
		 
		 assertEquals(newDischargeSummary.getHistory(),dsd.displayDischargeSummary(1).getHistory() );
	}

	@Test
	public void testDisplayDischargeSummary() throws ClassNotFoundException, SQLException {
		 
		 dsd.deleteDischargeSummary(1);
		
		 DischargeSummary dischargeSummary = new DischargeSummary();
		 
		 dischargeSummary.setSerialNo(1);
		 dischargeSummary.setAdmissionDate(null);
		 dischargeSummary.setDischargeDate(null);
		 dischargeSummary.setHistory("Eye Patient");
		 dischargeSummary.setOnExamination("Check Up Successful");
		 dischargeSummary.setOperationDone("Eye CheckUp");
		 dischargeSummary.setOperativeFindings("No Issue");
		 dischargeSummary.setTreatmentGiven("Eye Drop");
		 dischargeSummary.setRecommendations("Regular CheckUp");
		 
		 assertEquals(dischargeSummary.getHistory(), dsd.displayDischargeSummary(1).getHistory());
	}

	@Test
	public void testDisplayAllDischargeSummarys() throws ClassNotFoundException, SQLException {
		TreeSet<DischargeSummary> dischargeSummaryList=new TreeSet<DischargeSummary>();
		
		 dsd.deleteDischargeSummary(1);
		

		 DischargeSummary dischargeSummary = new DischargeSummary();
		 
		 dischargeSummary.setSerialNo(1);
		 dischargeSummary.setAdmissionDate(null);
		 dischargeSummary.setDischargeDate(null);
		 dischargeSummary.setHistory("Eye Patient");
		 dischargeSummary.setOnExamination("Check Up Successful");
		 dischargeSummary.setOperationDone("Eye CheckUp");
		 dischargeSummary.setOperativeFindings("No Issue");
		 dischargeSummary.setTreatmentGiven("Eye Drop");
		 dischargeSummary.setRecommendations("Regular CheckUp");
		 dischargeSummaryList.add(dischargeSummary);
		 
		 dsd.insertDischargeSummary(dischargeSummary);
		 
		 assertEquals(dischargeSummary, dsd.displayAllDischargeSummarys());
	}

}
