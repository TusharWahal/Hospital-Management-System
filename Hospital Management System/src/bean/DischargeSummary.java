package bean;

import java.sql.Date;

public class DischargeSummary {
	int serialNo;
	Date admissionDate;
	Date dischargeDate;
	String history;
	String onExamination;
	String operationDone;
	String operativeFindings;
	String treatmentGiven;
	String recommendations;
	int patientId;
	int otId;
	int doctorId;
	int bedNo;
	
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public Date getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}
	public Date getDischargeDate() {
		return dischargeDate;
	}
	public void setDischargeDate(Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public String getOnExamination() {
		return onExamination;
	}
	public void setOnExamination(String onExamination) {
		this.onExamination = onExamination;
	}
	public String getOperationDone() {
		return operationDone;
	}
	public void setOperationDone(String operationDone) {
		this.operationDone = operationDone;
	}
	public String getOperativeFindings() {
		return operativeFindings;
	}
	public void setOperativeFindings(String operativeFindings) {
		this.operativeFindings = operativeFindings;
	}
	public String getTreatmentGiven() {
		return treatmentGiven;
	}
	public void setTreatmentGiven(String treatmentGiven) {
		this.treatmentGiven = treatmentGiven;
	}
	public String getRecommendations() {
		return recommendations;
	}
	public void setRecommendations(String recommendations) {
		this.recommendations = recommendations;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getOtId() {
		return otId;
	}
	public void setOtId(int otId) {
		this.otId = otId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public int getBedNo() {
		return bedNo;
	}
	public void setBedNo(int bedNo) {
		this.bedNo = bedNo;
	}
}
