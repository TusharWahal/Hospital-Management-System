package dao;

import static helper.ConnectToDb.closeConnection;
import static helper.ConnectToDb.openConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;

import bean.Staff;

public class StaffDaoImpl implements StaffDao {

	private PreparedStatement pstmt=null;
	private Connection con;
	private ResultSet rs;
	
	@Override
	public boolean insertStaff(Staff newStaff) throws ClassNotFoundException, SQLException {		
		con= openConnection();
	
	int staffId=newStaff.getStaffId();
	String staffName=newStaff.getStaffName();
	String staffAddress=newStaff.getStaffAddress();
	String specialization=newStaff.getSpecialization();
	String timing=newStaff.getTiming();
	long staffPhoneNo=newStaff.getStaffPhoneNo();
	int departmentId=newStaff.getDepartmentId();
	
	
	
	
	pstmt=con.prepareStatement("insert into Staff (staffId,staffName" +
			"timing,specialization,staffAddress,staffPhoneNo,departmentId) values" + 
			"(?,?,?,?,?,?,?,?,?)");
	
	pstmt.setInt(1,staffId);
	pstmt.setString(2,staffName );
	pstmt.setString(3, timing);
	pstmt.setString(4, specialization);
	pstmt.setString(5, staffAddress);
	pstmt.setLong(6, staffPhoneNo);
	
	
	int rows=pstmt.executeUpdate();
	
	if(rows>0)
	{
		closeConnection(con);
		return true;
	}
	else closeConnection(con);
	return false;

	}

	@Override
	public boolean deleteStaff(int staffId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateStaff(int staffId, Staff renewStaff) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Staff displayStaff(int staffId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeSet<Staff> displayAllStaffs() {
		// TODO Auto-generated method stub
		return null;
	}

}
