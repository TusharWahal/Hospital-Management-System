package bean;

public class Staff  {
	int staffId;
	String staffName;
	String specialization;
	String timing;
	String staffAddress;
	long staffPhoneNo;
	String staffPassword;
	int departmentId;
	public int getDepartmentId()
	{
		return departmentId;
	}
	public void setDepartmentId(int departmentId)
	{
		this.departmentId = departmentId;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getTiming() {
		return timing;
	}
	public void setTiming(String timing) {
		this.timing = timing;
	}
	public String getStaffAddress() {
		return staffAddress;
	}
	public void setStaffAddress(String staffAddress) {
		this.staffAddress = staffAddress;
	}
	public long getStaffPhoneNo() {
		return staffPhoneNo;
	}
	public void setStaffPhoneNo(long staffPhoneNo) {
		this.staffPhoneNo = staffPhoneNo;
	}
	public String getStaffPassword() {
		return staffPassword;
	}
	public void setStaffPassword(String staffPassword) {
		this.staffPassword = staffPassword;
	}
}
