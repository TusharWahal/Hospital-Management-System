package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Staff;

public interface StaffDao {
	public boolean insertStaff(Staff newStaff) throws ClassNotFoundException, SQLException, IOException;
	public boolean deleteStaff(int staffId) throws ClassNotFoundException, SQLException, IOException;
	public boolean updateStaff(int staffId, Staff renewStaff) throws ClassNotFoundException, SQLException, IOException;
	public Staff displayStaff(int staffId) throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Staff> displayAllStaffs() throws ClassNotFoundException, SQLException, IOException;
}
