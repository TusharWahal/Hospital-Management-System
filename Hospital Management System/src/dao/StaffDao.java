package dao;

import java.util.TreeSet;

import bean.Staff;

public interface StaffDao {
	public boolean insertStaff(Staff newStaff);
	public boolean deleteStaff(int staffId);
	public boolean updateStaff(int staffId, Staff renewStaff);
	public Staff displayStaff(int staffId);
	public TreeSet<Staff> displayAllStaffs();
}
