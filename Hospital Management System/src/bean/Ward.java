package bean;

import java.sql.Date;

public class Ward {
	private int bedNo;
	private String type;
	private String location;
	private Date dateAdmitted;
	private Date dateDischarged;
	private int staffId;
	private int patientId;
	
	
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getBedNo() {
		return bedNo;
	}
	public void setBedNo(int bedNo) {
		this.bedNo = bedNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getDateAdmitted() {
		return dateAdmitted;
	}
	public void setDateAdmitted(Date dateAdmitted) {
		this.dateAdmitted = dateAdmitted;
	}
	public Date getDateDischarged() {
		return dateDischarged;
	}
	public void setDateDischarged(Date dateDischarged) {
		this.dateDischarged = dateDischarged;
	}
}
