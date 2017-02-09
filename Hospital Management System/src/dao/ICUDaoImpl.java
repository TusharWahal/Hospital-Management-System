package dao;

import static helper.ConnectToDb.closeConnection;
import static helper.ConnectToDb.openConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.DischargeSummary;
import bean.ICU;

public class ICUDaoImpl implements ICUDao {

	private PreparedStatement pstmt=null;
	private Connection con;
	private ResultSet rs;
	
	@Override
	public boolean insertICU(ICU newICU) throws ClassNotFoundException, SQLException, IOException {
		con= openConnection();
		
		int icuId= newICU.getIcuId();
		String examination = newICU.getExamination();
		String investigations = newICU.getInvestigations();
		String operationDescription = newICU.getOperationDescription();
		
		pstmt=con.prepareStatement("insert into ICU (icuId,examination,investigations," +
				"operationDescription) values (?,?,?,?)");
		
		pstmt.setInt(1,icuId);
		pstmt.setString(2, examination);
		pstmt.setString(3, investigations);
		pstmt.setString(4, operationDescription);
		
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
	public boolean deleteICU(int icuId) throws ClassNotFoundException, SQLException, IOException {

		con= openConnection();
		
		
		pstmt=con.prepareStatement("delete from ICU where icuId = ?");
		
		pstmt.setInt(1,icuId);
		
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
	public boolean updateICU(int icuId, ICU renewICU) throws ClassNotFoundException, SQLException, IOException {

		con= openConnection();
		
		
		pstmt=con.prepareStatement("update ICU set examination=?,investigations=?," +
				"operationDescription=? where icuId=?");
		

		
		pstmt.setString(1, renewICU.getExamination());
		pstmt.setString(2, renewICU.getInvestigations());
		pstmt.setString(3, renewICU.getOperationDescription());
		pstmt.setInt(4,icuId);
		
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
	public ICU displayICU(int icuId) throws ClassNotFoundException, SQLException, IOException {

		con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from ICU where icuId = ?");
		pstmt.setInt(1,icuId);
		
		rs=pstmt.executeQuery();
		
		ICU icu = new ICU();
		
		icu.setIcuId(rs.getInt(1));
		icu.setExamination(rs.getString(2));
		icu.setInvestigations(rs.getString(3));
		icu.setOperationDescription(rs.getString(4));
		
		closeConnection(con);
		return icu;
	}

	@Override
	public ArrayList<ICU> displayAllICUs() throws ClassNotFoundException, SQLException, IOException {

		con= openConnection();
		
		pstmt=con.prepareStatement("select * from ICU");
		
		rs=pstmt.executeQuery();
		
		ArrayList<ICU> icuList=new ArrayList<ICU>();
		ICU icu = new ICU();
		
		while(rs.next())
		{
			icu.setIcuId(rs.getInt(1));
			icu.setExamination(rs.getString(2));
			icu.setInvestigations(rs.getString(3));
			icu.setOperationDescription(rs.getString(4));
			
		}
		
		closeConnection(con);
		return icuList;
	}

}
