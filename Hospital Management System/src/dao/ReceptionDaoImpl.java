package dao;

import static helper.ConnectToDb.closeConnection;
import static helper.ConnectToDb.openConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;

import bean.Reception;

public class ReceptionDaoImpl implements ReceptionDao {
	
	private PreparedStatement pstmt=null;
	private Connection con;
	private ResultSet rs;

	@Override
	public boolean insertReception(Reception newReception) throws ClassNotFoundException,SQLException, IOException{
		// TODO Auto-generated method stub
        con= openConnection();
		
		int regNo=newReception.getRegNo();
		String personId=newReception.getPersonId();
		String purpose=newReception.getPurpose();
		float payment=newReception.getPayment();
		int doctorId=newReception.getDoctorId();
		Date appointmentDate=newReception.getAppointmentDate();
		
		pstmt=con.prepareStatement("insert into Reception(regNo,personId," +
				"purpose,payment,doctorId,regDate) values " + 
				"(?,?,?,?,?,?)");
		
		pstmt.setInt(1,regNo);
		pstmt.setString(2,personId );
		pstmt.setString(3, purpose);
		pstmt.setFloat(4, payment);
		pstmt.setInt(5, doctorId);
		pstmt.setDate(6, appointmentDate);
		
		
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
	public boolean deleteReception(int regNo) throws ClassNotFoundException,SQLException, IOException {
		// TODO Auto-generated method stub
        con= openConnection();
		
		
		pstmt=con.prepareStatement("delete from Reception where regNo = ?");
		
		pstmt.setInt(1,regNo);
		
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
	public boolean updateReception(int regNo, Reception renewReception) throws ClassNotFoundException,SQLException, IOException {
		// TODO Auto-generated method stub
		   con= openConnection();
			
			
			pstmt=con.prepareStatement("update Reception set  personId =? "
					+ ", purpose=? ,payment=? ,doctorId=? ,regDate=? where regNo = ?  ");
			

			pstmt.setInt(6,regNo);
			pstmt.setString(1,renewReception.getPersonId());
			pstmt.setString(2, renewReception.getPurpose());
			pstmt.setFloat(3, renewReception.getPayment());
			pstmt.setInt(4, renewReception.getDoctorId());
			pstmt.setDate(5, renewReception.getAppointmentDate());
			
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
	public Reception displayReception(int regNo) throws ClassNotFoundException,SQLException, IOException {
		// TODO Auto-generated method stub
con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from Reception where regNo = ?");
		pstmt.setInt(1,regNo);
		
		rs=pstmt.executeQuery();
		
		Reception reception=new Reception();
		while(rs.next())
		{
			reception.setRegNo(rs.getInt("regNo"));
			reception.setPersonId(rs.getString("personId"));
			reception.setPurpose(rs.getString("purpose"));
			reception.setPayment(rs.getFloat("payment"));
			reception.setDoctorId(rs.getInt("doctorId"));
			reception.setAppointmentDate(rs.getDate("regDate"));
		}
		
		closeConnection(con);
		return reception;
	}

	@Override
	public TreeSet<Reception> displayAllReceptions() throws ClassNotFoundException,SQLException, IOException {
		// TODO Auto-generated method stub
		 con= openConnection();
			
			
			pstmt=con.prepareStatement("select * from reception ");
			
			
			rs=pstmt.executeQuery();
			
			TreeSet<Reception> receptionList=new TreeSet<Reception>();
			
			Reception reception=new Reception();
			while(rs.next())
			{
				reception.setRegNo(rs.getInt("regNo"));
				reception.setPersonId(rs.getString("personId"));
				reception.setPurpose(rs.getString("purpose"));
				reception.setPayment(rs.getFloat("payment"));
				reception.setDoctorId(rs.getInt("doctorId"));
				reception.setAppointmentDate(rs.getDate("regDate"));
				
				//System.out.println(reception);
				receptionList.add(reception);
			}
			
		//	System.out.println(receptionList);
			closeConnection(con);

			return receptionList;
	}

}
