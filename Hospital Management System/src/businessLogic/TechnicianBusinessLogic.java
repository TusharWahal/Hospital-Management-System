package businessLogic;

import java.sql.SQLException;
import java.util.TreeSet;

import bean.MedicalReport;
import dao.MedicalReportDaoImpl;

public class TechnicianBusinessLogic {
	
	MedicalReportDaoImpl mrd=new MedicalReportDaoImpl();
	
	public boolean modifyMedicalReport(int patientId,MedicalReport newMedicalReport) throws ClassNotFoundException, SQLException
	{
		return mrd.updateMedicalReport(patientId,newMedicalReport);
	}
	public TreeSet<MedicalReport> listMedicalReport() throws ClassNotFoundException, SQLException
	{
		return mrd.displayAllMedicalReports();
	}
	public MedicalReport viewMedicalReports(int patientId) throws ClassNotFoundException, SQLException
	{
		return mrd.displayMedicalReport(patientId);
	}
}
