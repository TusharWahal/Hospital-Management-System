package dao;

import static helper.ConnectToDb.closeConnection;
import static helper.ConnectToDb.openConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;

import bean.Ward;
import bean.Ward;

public class WardDaoImpl implements WardDao {
	private PreparedStatement pstmt=null;
	private Connection con;
	private ResultSet rs;

	@Override
	public boolean insertWard(Ward newWard) throws ClassNotFoundException, SQLException {
		
		con= openConnection();
		
		int bedNo =newWard.getBedNo();
		String wardType = newWard.getType();
		String wardLocation=newWard.getLocation();
		Date dateAdmitted=newWard.getDateAdmitted();
		Date dateDischarged=newWard.getDateDischarged();
		int staffId=newWard.getStaffId();
		int patientId=newWard.getPatientId();
		
		
		pstmt=con.prepareStatement("insert into ward (bedNo,"
				+ "type,location,dateAdmitted,dateDischarged,staffId,patientId)"
				+ " values" + "(?,?,?,?,?,?,?)");
		
		pstmt.setInt(1, bedNo);
		pstmt.setString(2, wardType);
		pstmt.setString(3, wardLocation);
		pstmt.setDate(4, dateAdmitted);
		pstmt.setDate(5, dateDischarged);
		pstmt.setInt(6, staffId);
		pstmt.setInt(7, patientId);


		
		
	
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
	public boolean deleteWard(int bedNo) throws ClassNotFoundException, SQLException {

		con= openConnection();
		
		
		pstmt=con.prepareStatement("delete from ward where bedNo = ?");
		
		pstmt.setInt(1,bedNo);
		
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
	public boolean updateWard(int bedNo, Ward renewWard) throws ClassNotFoundException, SQLException {
		con= openConnection();
		
		
		pstmt=con.prepareStatement("update ward set location = ? "
				+ ", type =? "
				+ ", dateAdmitted=?"
				+ ", dateDischarged=?"
				+ ", patientId=?"
				+ ", staffId=?"
				+ "where bedNo= ?");
		

		pstmt.setString(1,renewWard.getLocation());
		pstmt.setString(2,renewWard.getType());
		pstmt.setDate(3, renewWard.getDateAdmitted());
		pstmt.setDate(4, renewWard.getDateDischarged());
		pstmt.setInt(5, renewWard.getPatientId());
		pstmt.setInt(6, renewWard.getStaffId());
		pstmt.setInt(7, bedNo);
		
		int rows=pstmt.executeUpdate();
		
		if(rows>0)
		{
			closeConnection(con);
			return true ;
		}
		else 
		{
			closeConnection(con);
			return false;
			
		}

		
	}

	@Override
	public Ward displayWard(int bedNo) throws ClassNotFoundException, SQLException {
		
		con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from ward where bedNo = ?");
		pstmt.setInt(1,bedNo);
		
		rs=pstmt.executeQuery();
		
		Ward ward=new Ward();
		while(rs.next())
		{
			ward.setBedNo(rs.getInt("bedNo"));
			ward.setLocation(rs.getString("location"));
			ward.setType(rs.getString("wardType"));
			ward.setDateAdmitted(rs.getDate("dateAdmitted"));
			ward.setDateDischarged(rs.getDate("dateDischarged"));
			ward.setPatientId(rs.getInt("patientId"));
			ward.setStaffId(rs.getInt("staffId"));
		}
		
		closeConnection(con);
		return ward;

	}

	@Override
	public TreeSet<Ward> displayAllWards() throws ClassNotFoundException, SQLException {	
		con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from ward ");
		
		
		rs=pstmt.executeQuery();
		TreeSet<Ward> wardList=new TreeSet<Ward>();
		Ward ward=new Ward();
		while(rs.next())
		{
			ward.setBedNo(rs.getInt("bedNo"));
			ward.setLocation(rs.getString("location"));
			ward.setType(rs.getString("wardType"));
			ward.setDateAdmitted(rs.getDate("dateAdmitted"));
			ward.setDateDischarged(rs.getDate("dateDischarged"));
			ward.setPatientId(rs.getInt("patientId"));
			ward.setStaffId(rs.getInt("staffId"));
			wardList.add(ward);
		}
		
		closeConnection(con);
		return wardList;

	}

}
