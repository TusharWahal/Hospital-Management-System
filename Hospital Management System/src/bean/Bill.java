package bean;

public class Bill {
	int number;
	float doctorVisit;
	float bedCharges;
	float tests;
	float medicines;
	int patientId;
	int serialNo;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public float getDoctorVisit() {
		return doctorVisit;
	}
	public void setDoctorVisit(float doctorVisit) {
		this.doctorVisit = doctorVisit;
	}
	public float getBedCharges() {
		return bedCharges;
	}
	public void setBedCharges(float bedCharges) {
		this.bedCharges = bedCharges;
	}
	public float getTests() {
		return tests;
	}
	public void setTests(float tests) {
		this.tests = tests;
	}
	public float getMedicines() {
		return medicines;
	}
	public void setMedicines(float medicines) {
		this.medicines = medicines;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
}
