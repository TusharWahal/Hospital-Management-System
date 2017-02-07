package dao;

import static helper.ConnectToDb.closeConnection;
import static helper.ConnectToDb.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;

import bean.Technician;

public class TechnicianDaoImpl implements TechnicianDao {
	
	private PreparedStatement pstmt=null;
	private Connection con;
	private ResultSet rs;
	
	@Override
	public boolean insertTechnician(Technician newTechnician) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		con= openConnection();
		
		int technicianId=newTechnician.getTechnicianId();
		String technicianName=newTechnician.getTechnicianName();
		String technicianAddress=newTechnician.getTechnicianAddress();
		String specialization=newTechnician.getSpecialization();
		String timing=newTechnician.getTiming();
		long technicianPhoneNo=newTechnician.getTechnicianPhoneNo();
		int departmentId=newTechnician.getDepartmentId();
		String technicianPassword=newTechnician.getTechnicianPassword();
		
		
		
		
		pstmt=con.prepareStatement("insert into Technician (technicianId,technicianName" +
				"timing,specialization,technicianAddress,technicianPhoneNo,departmentId,technicianPassword) values" + 
				"(?,?,?,?,?,?,?,?,?,?)");
		
		pstmt.setInt(1,technicianId);
		pstmt.setString(2,technicianName );
		pstmt.setString(3, timing);
		pstmt.setString(4, specialization);
		pstmt.setString(5, technicianAddress);
		pstmt.setLong(6, technicianPhoneNo);
		pstmt.setInt(7, departmentId);
		pstmt.setString(8, technicianPassword);
		
		
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
	public boolean deleteTechnician(int technicianId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
        con= openConnection();
		
		
		pstmt=con.prepareStatement("delete from technician where technicianId = ?");
		
		pstmt.setInt(1,technicianId);
		
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
	public boolean updateTechnician(int technicianId, Technician renewTechnician) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
        con= openConnection();
		
		
		pstmt=con.prepareStatement("update technician set technicianName = ? , specialization =? "
				+ ", timing=? ,technicianAddress=? "
				+ ", technicianPhoneNo=?, departmentId=?, technicianPassword=? "
				+ "where technicianId= ?");
		

		pstmt.setString(1,renewTechnician.getTechnicianName());
		pstmt.setString(2,renewTechnician.getSpecialization());
		pstmt.setString(3, renewTechnician.getTiming());
		pstmt.setString(4, renewTechnician.getTechnicianAddress());
		pstmt.setLong(5, renewTechnician.getTechnicianPhoneNo());
		pstmt.setInt(6, renewTechnician.getDepartmentId());
		pstmt.setString(7, renewTechnician.getTechnicianPassword());
		pstmt.setInt(8, technicianId);
		
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
		//return false;
	}

	@Override
	public Technician displayTechnician(int technicianId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
        con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from technician where technicianId = ?");
		pstmt.setInt(1,technicianId);
		
		rs=pstmt.executeQuery();
		
		Technician technician=new Technician();
		while(rs.next())
		{
			technician.setTechnicianId(rs.getInt("technicianId"));
			technician.setTechnicianId(rs.getInt("departmentId"));
			technician.setTechnicianAddress(rs.getString("technicianAddress"));
			technician.setTechnicianName(rs.getString("technicianName"));
			technician.setTechnicianPhoneNo(rs.getLong("technicianPhoneNo"));
			technician.setSpecialization(rs.getString("specialization"));
			technician.setTiming(rs.getString("timing"));
			technician.setTechnicianPassword(rs.getString("technicianPassword"));
		}
		
		closeConnection(con);
		return technician;
	}

	@Override
	public TreeSet<Technician> displayAllTechnicians() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
        con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from technician ");
		
		
		rs=pstmt.executeQuery();
		
		TreeSet<Technician> technicianList=new TreeSet<Technician>();
		
		Technician technician=new Technician();
		while(rs.next())
		{
			technician.setTechnicianId(rs.getInt("technicianId"));
			technician.setDepartmentId(rs.getInt("departmentId"));
			technician.setTechnicianAddress(rs.getString("technicianAddress"));
			technician.setTechnicianName(rs.getString("technicianName"));
			technician.setTechnicianPhoneNo(rs.getLong("technicianPhoneNo"));
			technician.setSpecialization(rs.getString("specialization"));
			technician.setTiming(rs.getString("timing"));
			technician.setTechnicianPassword(rs.getString("technicianPassword"));
			technicianList.add(technician);
		}
		
		closeConnection(con);

		return technicianList;
	}

}