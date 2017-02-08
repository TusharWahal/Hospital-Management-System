package bean;

import java.sql.Date;

public class MedicalReport implements Comparable<MedicalReport> {
	int patientId;
	Date visitDate;
	String diagnosis;
	String investigations;
	String tests;
	String recommendations;
	int doctorId;
	int technicianId;
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public int getTechnicianId() {
		return doctorId;
	}
	public void setTechnicianId(int technicianId) {
		this.technicianId = technicianId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getInvestigations() {
		return investigations;
	}
	public void setInvestigations(String investigations) {
		this.investigations = investigations;
	}
	public String getTests() {
		return tests;
	}
	public void setTests(String tests) {
		this.tests = tests;
	}
	public String getRecommendations() {
		return recommendations;
	}
	public void setRecommendations(String recommendations) {
		this.recommendations = recommendations;
	}
	
	
	
	@Override
	public String toString() {
		return "MedicalReport [patientId=" + patientId + ", visitDate=" + visitDate + ", diagnosis=" + diagnosis
				+ ", investigations=" + investigations + ", tests=" + tests + ", recommendations=" + recommendations
				+ ", doctorId=" + doctorId + ", technicianId=" + technicianId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diagnosis == null) ? 0 : diagnosis.hashCode());
		result = prime * result + doctorId;
		result = prime * result + ((investigations == null) ? 0 : investigations.hashCode());
		result = prime * result + patientId;
		result = prime * result + ((recommendations == null) ? 0 : recommendations.hashCode());
		result = prime * result + technicianId;
		result = prime * result + ((tests == null) ? 0 : tests.hashCode());
		result = prime * result + ((visitDate == null) ? 0 : visitDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MedicalReport other = (MedicalReport) obj;
		if (diagnosis == null) {
			if (other.diagnosis != null)
				return false;
		} else if (!diagnosis.equals(other.diagnosis))
			return false;
		if (doctorId != other.doctorId)
			return false;
		if (investigations == null) {
			if (other.investigations != null)
				return false;
		} else if (!investigations.equals(other.investigations))
			return false;
		if (patientId != other.patientId)
			return false;
		if (recommendations == null) {
			if (other.recommendations != null)
				return false;
		} else if (!recommendations.equals(other.recommendations))
			return false;
		if (technicianId != other.technicianId)
			return false;
		if (tests == null) {
			if (other.tests != null)
				return false;
		} else if (!tests.equals(other.tests))
			return false;
		if (visitDate == null) {
			if (other.visitDate != null)
				return false;
		} else if (!visitDate.equals(other.visitDate))
			return false;
		return true;
	}
	@Override
	public int compareTo(MedicalReport o) {
		if(this.equals(o))
			return 0;
		else
			return 1;
	}
}
