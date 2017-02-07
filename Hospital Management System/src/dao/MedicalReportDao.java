package dao;

import java.sql.SQLException;
import java.util.TreeSet;

import bean.MedicalReport;

public interface MedicalReportDao {
	public boolean insertMedicalReport(MedicalReport newMedicalReport) throws SQLException, ClassNotFoundException;
	public boolean deleteMedicalReport(int patientId) throws ClassNotFoundException, SQLException;
	public boolean updateMedicalReport(int patientId, MedicalReport renewMedicalReport) throws ClassNotFoundException, SQLException;
	public MedicalReport displayMedicalReport(int patientId) throws ClassNotFoundException, SQLException;
	public TreeSet<MedicalReport> displayAllMedicalReports() throws ClassNotFoundException, SQLException;
}
