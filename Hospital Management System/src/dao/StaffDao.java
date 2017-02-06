package dao;

import java.sql.SQLException;
import java.util.TreeSet;

import bean.Staff;

public interface StaffDao {
	public boolean insertStaff(Staff newStaff) throws ClassNotFoundException, SQLException;
	public boolean deleteStaff(int staffId);
	public boolean updateStaff(int staffId, Staff renewStaff);
	public Staff displayStaff(int staffId);
	public TreeSet<Staff> displayAllStaffs();
}
