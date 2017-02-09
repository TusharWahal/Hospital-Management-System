package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.TreeSet;

import bean.MedicalReport;

public interface MedicalReportDao {
	public boolean insertMedicalReport(MedicalReport newMedicalReport) throws SQLException, ClassNotFoundException, IOException;
	public boolean deleteMedicalReport(int patientId) throws ClassNotFoundException, SQLException, IOException;
	public boolean updateMedicalReport(int patientId, MedicalReport renewMedicalReport) throws ClassNotFoundException, SQLException, IOException;
	public MedicalReport displayMedicalReport(int patientId) throws ClassNotFoundException, SQLException, IOException;
	public TreeSet<MedicalReport> displayAllMedicalReports() throws ClassNotFoundException, SQLException, IOException;
}
