package bean;

public class Bill implements Comparable<Bill> {
	int billNo;
	int patientId;
	int serialNo;
	float doctorVisit;
	float bedCharges;
	float tests;
	float medicines;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(bedCharges);
		result = prime * result + billNo;
		result = prime * result + Float.floatToIntBits(doctorVisit);
		result = prime * result + Float.floatToIntBits(medicines);
		result = prime * result + patientId;
		result = prime * result + serialNo;
		result = prime * result + Float.floatToIntBits(tests);
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
		Bill other = (Bill) obj;
		if (Float.floatToIntBits(bedCharges) != Float.floatToIntBits(other.bedCharges))
			return false;
		if (billNo != other.billNo)
			return false;
		if (Float.floatToIntBits(doctorVisit) != Float.floatToIntBits(other.doctorVisit))
			return false;
		if (Float.floatToIntBits(medicines) != Float.floatToIntBits(other.medicines))
			return false;
		if (patientId != other.patientId)
			return false;
		if (serialNo != other.serialNo)
			return false;
		if (Float.floatToIntBits(tests) != Float.floatToIntBits(other.tests))
			return false;
		return true;
	}
	public int getBillNo() {
		return billNo;
	}
	public void setBillNo(int billNo) {
		this.billNo = billNo;
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
	@Override
	public int compareTo(Bill o) {
		if(this.equals(o))
		{return 0;
		}
		
		return 1;
	}
}
