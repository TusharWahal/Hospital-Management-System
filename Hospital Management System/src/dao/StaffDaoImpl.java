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
import bean.Staff;
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
	String staffPassword=newStaff.getStaffPassword();
	
	
	
	
	pstmt=con.prepareStatement("insert into Staff (staffId,staffName" +
			"timing,specialization,staffAddress,staffPhoneNo,departmentId,staffPassword) values" + 
			"(?,?,?,?,?,?,?,?,?,?)");
	
	pstmt.setInt(1,staffId);
	pstmt.setString(2,staffName );
	pstmt.setString(3, timing);
	pstmt.setString(4, specialization);
	pstmt.setString(5, staffAddress);
	pstmt.setLong(6, staffPhoneNo);
	pstmt.setString(7, staffPassword);
	
	
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
	public boolean deleteStaff(int staffId) throws ClassNotFoundException, SQLException {
		con= openConnection();
		
		
		pstmt=con.prepareStatement("delete from staff where staffId = ?");
		
		pstmt.setInt(1,staffId);
		
		int rows=pstmt.executeUpdate();
		
		if(rows>0)
		{
			closeConnection(con);
			return true;
		}
		else 
		{
			closeConnection(con);
			return false;
		}

	}

	@Override
	public boolean updateStaff(int staffId, Staff renewStaff) throws ClassNotFoundException, SQLException {

		con= openConnection();
		
		
		pstmt=con.prepareStatement("update staff set staffName = ? , specialization =? "
				+ ", timing=? ,staffAddress=? "
				+ ", staffPhoneNo=?, departmentId=?, staffPassword=? "
				+ "where staffId= ?");
		

		pstmt.setString(1,renewStaff.getStaffName());
		pstmt.setString(2,renewStaff.getSpecialization());
		pstmt.setString(3, renewStaff.getTiming());
		pstmt.setString(4, renewStaff.getStaffAddress());
		pstmt.setLong(5, renewStaff.getStaffPhoneNo());
		pstmt.setInt(6, renewStaff.getDepartmentId());
		pstmt.setString(7, renewStaff.getStaffPassword());
		pstmt.setInt(8, staffId);
		
		int rows=pstmt.executeUpdate();
		
		if(rows>0)
		{
			closeConnection(con);
			return true;
		}
		else 
			{
			closeConnection(con);
			return false;
			}
		

		

	}

	@Override
	public Staff displayStaff(int staffId) throws ClassNotFoundException, SQLException {


		con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from staff where staffId = ?");
		pstmt.setInt(1,staffId);
		
		rs=pstmt.executeQuery();
		
		Staff staff=new Staff();
		while(rs.next())
		{
			staff.setStaffId(rs.getInt("staffId"));
			staff.setDepartmentId(rs.getInt("departmentId"));
			staff.setStaffAddress(rs.getString("staffAddress"));
			staff.setStaffName(rs.getString("staffName"));
			staff.setStaffPhoneNo(rs.getLong("staffPhoneNo"));
			staff.setSpecialization(rs.getString("specialization"));
			staff.setTiming(rs.getString("timing"));
			staff.setStaffPassword(rs.getString("staffPassword"));
		}
		
		closeConnection(con);
		return staff;

	}

	@Override
	public TreeSet<Staff> displayAllStaffs() throws ClassNotFoundException, SQLException {
	
		con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from staff ");
		
		
		rs=pstmt.executeQuery();
		
		TreeSet<Staff> staffList=new TreeSet<Staff>();
		
		Staff staff=new Staff();
		while(rs.next())
		{
			staff.setStaffId(rs.getInt("staffId"));
			staff.setDepartmentId(rs.getInt("departmentId"));
			staff.setStaffAddress(rs.getString("staffAddress"));
			staff.setStaffName(rs.getString("staffName"));
			staff.setStaffPhoneNo(rs.getLong("staffPhoneNo"));
			staff.setSpecialization(rs.getString("specialization"));
			staff.setTiming(rs.getString("timing"));
			staff.setStaffPassword(rs.getString("staffPassword"));
			staffList.add(staff);
		}
		
		closeConnection(con);

		return staffList;

	}

}
