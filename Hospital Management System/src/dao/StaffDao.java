package dao;

import java.util.TreeSet;

import bean.Staff;

public interface StaffDao {
	public void insertStaff(Staff newStaff);
	public Staff deleteStaff(int staffId);
	public void updateStaff(int staffId, Staff renewStaff);
	public Staff displayStaff(int staffId);
	public TreeSet<Staff> displayAllStaffs();
}
