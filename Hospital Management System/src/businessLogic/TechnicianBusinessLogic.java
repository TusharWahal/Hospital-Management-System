package businessLogic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.TreeSet;

import bean.MedicalReport;
import bean.Technician;
import dao.MedicalReportDaoImpl;
import dao.TechnicianDaoImpl;

public class TechnicianBusinessLogic {
	
	MedicalReportDaoImpl mrd=new MedicalReportDaoImpl();
	TechnicianDaoImpl td= new TechnicianDaoImpl();
	
	public Technician technicianLogin(int technicianId, String technicianPassword) throws ClassNotFoundException, SQLException, IOException
	{
		Technician technician;
		if(td.displayTechnician(technicianId).getTechnicianId()==0)
		{
			return null;
		}
		else
		{
			technician=td.displayTechnician(technicianId);
			if(technician.getTechnicianPassword().equals(technicianPassword))
			{
				return technician;
			}
			else return null;
		}
	}
	
//	public boolean modifyMedicalReport(int patientId,MedicalReport newMedicalReport) throws ClassNotFoundException, SQLException
//	{
//		return mrd.updateMedicalReport(patientId,newMedicalReport);
//	}
	public boolean modifyMedicalReport(int patientId,MedicalReport newMedicalReport) throws ClassNotFoundException, SQLException, IOException
	{
		return mrd.updateMedicalReport(patientId,newMedicalReport);
	}
	public TreeSet<MedicalReport> listMedicalReport() throws ClassNotFoundException, SQLException, IOException
	{
		return mrd.displayAllMedicalReports();
	}
	public MedicalReport viewMedicalReports(int patientId) throws ClassNotFoundException, SQLException, IOException
	{
		return mrd.displayMedicalReport(patientId);
	}
	
	public MedicalReport modifyMedicalReport(int patientId, String tests) throws ClassNotFoundException, SQLException, IOException{
		MedicalReport mr =new MedicalReport();
		mr=mrd.displayMedicalReport(patientId);
		mr.setTests(tests);
		return mr;
	}
}
