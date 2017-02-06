package dao;

import java.util.TreeSet;

import bean.MedicalReport;

public interface MedicalReportDao {
	public boolean insertMedicalReport(MedicalReport newMedicalReport);
	public boolean deleteMedicalReport(int MedicalReportId);
	public boolean updateMedicalReport(int MedicalReportId, MedicalReport renewMedicalReport);
	public MedicalReport displayMedicalReport(int MedicalReportId);
	public TreeSet<MedicalReport> displayAllMedicalReports();
}
