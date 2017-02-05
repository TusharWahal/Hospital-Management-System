package dao;

import java.util.TreeSet;

import bean.MedicalReport;

public interface MedicalReportDao {
	public void insertMedicalReport(MedicalReport newMedicalReport);
	public MedicalReport deleteMedicalReport(int MedicalReportId);
	public void updateMedicalReport(int MedicalReportId, MedicalReport renewMedicalReport);
	public MedicalReport displayMedicalReport(int MedicalReportId);
	public TreeSet<MedicalReport> displayAllMedicalReports();
}
