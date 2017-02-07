package dao;

import java.sql.SQLException;
import java.util.TreeSet;

import bean.Staff;

public interface StaffDao {
	public boolean insertStaff(Staff newStaff) throws ClassNotFoundException, SQLException;
	public boolean deleteStaff(int staffId) throws ClassNotFoundException, SQLException;
	public boolean updateStaff(int staffId, Staff renewStaff) throws ClassNotFoundException, SQLException;
	public Staff displayStaff(int staffId) throws ClassNotFoundException, SQLException;
	public TreeSet<Staff> displayAllStaffs() throws ClassNotFoundException, SQLException;
}
