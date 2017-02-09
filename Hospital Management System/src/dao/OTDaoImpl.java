package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;
import java.sql.Connection;
import static helper.ConnectToDb.*;

import bean.OT;

public class OTDaoImpl implements OTDao {
	
	private PreparedStatement pstmt=null;
	private Connection con;
	private ResultSet rs;

	@Override
	public boolean insertOT(OT newOT) throws ClassNotFoundException, SQLException {
		con= openConnection(); 
		
		int otId = newOT.getOtId();
		String description = newOT.getDescription();
		String equipments = newOT.getEquipments();
		int patientId = newOT.getPatientId();
		int staffId = newOT.getStaffId();
		int doctorId = newOT.getDoctorId();
		
		pstmt=con.prepareStatement("insert into ot (otId,description,equipments,patientId,staffId,doctorId)"
				+ "values" + "(?,?,?,?,?,?)");
		
		pstmt.setInt(1,otId);
		pstmt.setString(2, description);
		pstmt.setString(3, equipments);
		pstmt.setInt(1,patientId);
		pstmt.setInt(1,staffId);
		pstmt.setInt(1,doctorId);
		
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
	public boolean deleteOT(int OTId) throws ClassNotFoundException, SQLException {
		con= openConnection();
		
		
		pstmt=con.prepareStatement("delete from ot where otId = ?");
		
		pstmt.setInt(1,OTId);
		
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
	public boolean updateOT(int OTId, OT renewOT) throws ClassNotFoundException, SQLException {
		con= openConnection();
		
		
		pstmt=con.prepareStatement("update ot set description = ? , equipments = ? "
				+ ", patientId = ? ,staffId = ? "
				+ ", doctorId= ? "
				+ "where otId = ?");
		

		pstmt.setInt(1,renewOT.getOtId());
		pstmt.setString(2,renewOT.getDescription());
		pstmt.setString(3, renewOT.getEquipments());
		pstmt.setInt(3, renewOT.getPatientId());
		pstmt.setInt(4, renewOT.getStaffId());
		pstmt.setInt(5, renewOT.getDoctorId());
		
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
	public OT displayOT(int OTId) throws ClassNotFoundException, SQLException {
		con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from ot where otId = ?");
		pstmt.setInt(1,OTId);
		
		rs=pstmt.executeQuery();
		
		OT ot=new OT();
		while(rs.next())
		{
			ot.setOtId(rs.getInt("otId"));
			ot.setDescription(rs.getString("description"));
			ot.setEquipments(rs.getString("equipments"));
			ot.setPatientId(rs.getInt("patientId"));
		    ot.setStaffId(rs.getInt("staffId"));
			ot.setDoctorId(rs.getInt("doctorId"));
		}
		
		closeConnection(con);
		return ot;
	}

	@Override
	public TreeSet<OT> displayAllOTs() throws ClassNotFoundException, SQLException {
		con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from ot ");
		
		
		rs=pstmt.executeQuery();
		
		TreeSet<OT> otList=new TreeSet<OT>();
		
		OT ot=new OT();
		while(rs.next())
		{
			ot.setOtId(rs.getInt("otId"));
			ot.setDescription(rs.getString("description"));
			ot.setEquipments(rs.getString("equipments"));
			ot.setPatientId(rs.getInt("patientId"));
		    ot.setStaffId(rs.getInt("staffId"));
			ot.setDoctorId(rs.getInt("doctorId"));
		}
		
		closeConnection(con);

		return otList;
	}

}