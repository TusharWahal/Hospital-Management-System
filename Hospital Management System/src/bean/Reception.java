package bean;

import java.sql.Date;

public class Reception implements Comparable<Reception> {
	int regNo;
	String personId;
	String purpose;
	float payment;
	int doctorId;
	Date appointmentDate;
	
	@Override
	public String toString() {
		return "Reception [regNo=" + regNo + ", personId=" + personId + ", purpose=" + purpose + ", payment=" + payment
				+ ", doctorId=" + doctorId + ", appointmentDate=" + appointmentDate + "]";
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public int getRegNo() {
		return regNo;
	}
	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public float getPayment() {
		return payment;
	}
	public void setPayment(float payment) {
		this.payment = payment;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appointmentDate == null) ? 0 : appointmentDate.hashCode());
		result = prime * result + doctorId;
		result = prime * result + Float.floatToIntBits(payment);
		result = prime * result + ((personId == null) ? 0 : personId.hashCode());
		result = prime * result + ((purpose == null) ? 0 : purpose.hashCode());
		result = prime * result + regNo;
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
		Reception other = (Reception) obj;
		if (appointmentDate == null) {
			if (other.appointmentDate != null)
				return false;
		} else if (!appointmentDate.equals(other.appointmentDate))
			return false;
		if (doctorId != other.doctorId)
			return false;
		if (Float.floatToIntBits(payment) != Float.floatToIntBits(other.payment))
			return false;
		if (personId == null) {
			if (other.personId != null)
				return false;
		} else if (!personId.equals(other.personId))
			return false;
		if (purpose == null) {
			if (other.purpose != null)
				return false;
		} else if (!purpose.equals(other.purpose))
			return false;
		if (regNo != other.regNo)
			return false;
		return true;
	}
	@Override
	public int compareTo(Reception o) {
//		if(this.getRegNo().comparo.getRegNo())
//			return 0;
//		else if(this.getRegNo()>o.getRegNo())
//			return 1;
//		else 
			return -1;
	}
}
