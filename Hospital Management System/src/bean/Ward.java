package bean;

import java.sql.Date;

public class Ward implements Comparable<Ward> {
	private int bedNo;
	private String type;
	private String location;
	private Date dateAdmitted;
	private Date dateDischarged;
	private int staffId;
	private int patientId;
	
	
	@Override
	public String toString() {
		return "Ward [bedNo=" + bedNo + ", type=" + type + ", location=" + location + ", dateAdmitted=" + dateAdmitted
				+ ", dateDischarged=" + dateDischarged + ", staffId=" + staffId + ", patientId=" + patientId + "]";
	}
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bedNo;
		result = prime * result + ((dateAdmitted == null) ? 0 : dateAdmitted.hashCode());
		result = prime * result + ((dateDischarged == null) ? 0 : dateDischarged.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + patientId;
		result = prime * result + staffId;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Ward other = (Ward) obj;
		if (bedNo != other.bedNo)
			return false;
		if (dateAdmitted == null) {
			if (other.dateAdmitted != null)
				return false;
		} else if (!dateAdmitted.equals(other.dateAdmitted))
			return false;
		if (dateDischarged == null) {
			if (other.dateDischarged != null)
				return false;
		} else if (!dateDischarged.equals(other.dateDischarged))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (patientId != other.patientId)
			return false;
		if (staffId != other.staffId)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	@Override
	public int compareTo(Ward o) {
		if(this.equals(o))
			return 0;
		else
			return 1;
	}
	
}
