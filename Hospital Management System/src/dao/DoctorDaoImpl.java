package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;
import static helper.ConnectToDb.*;

import bean.Doctor;

public class DoctorDaoImpl implements DoctorDao {
	
	private PreparedStatement pstmt=null;
	private Connection con;
	private ResultSet rs;

	@Override
	public boolean insertDoctor(Doctor newDoctor) throws ClassNotFoundException, SQLException {
		
		con= openConnection();
		
		int doctorId =newDoctor.getDoctorId();
		String doctorName = newDoctor.getDoctorName();
		String doctorAddress=newDoctor.getDoctorAddress();
		String doctorSpecializtion=newDoctor.getSpecialization();
		String doctorTiming=newDoctor.getTiming();
		long doctorPhoneNo=newDoctor.getDoctorPhoneNo();
		int departmentId=newDoctor.getDepartmentId();
		String doctorPassword=newDoctor.getDoctorPassword();
		
		pstmt=con.prepareStatement("insert into doctor (doctorId,doctorName,specialization,timing,doctorAddress,"
				+ "doctorPhoneNo,departmentId,doctorPassword) values" + "(?,?,?,?,?,?,?,?)");
		
		pstmt.setInt(1,doctorId);
		pstmt.setString(2,doctorName);
		pstmt.setString(3, doctorSpecializtion);
		pstmt.setString(4, doctorTiming);
		pstmt.setString(5, doctorAddress);
		pstmt.setLong(6, doctorPhoneNo);
		pstmt.setInt(7, departmentId);
		pstmt.setString(8, doctorPassword);
		
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
	public boolean deleteDoctor(int doctorId) throws ClassNotFoundException, SQLException {
		con= openConnection();
		
		
		pstmt=con.prepareStatement("delete from doctor where doctorId = ?");
		
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
	public boolean updateDoctor(int doctorId, Doctor renewDoctor) throws ClassNotFoundException, SQLException {
		
		con= openConnection();
		
		
		pstmt=con.prepareStatement("update doctor set doctorName = ? , specialization =? "
				+ ", timing=? ,doctorAddress=? "
				+ ", doctorPhoneNo=?, departmentId=?, doctorPassword=? "
				+ "where doctorId= ?");
		

		pstmt.setString(1,renewDoctor.getDoctorName());
		pstmt.setString(2,renewDoctor.getSpecialization());
		pstmt.setString(3, renewDoctor.getTiming());
		pstmt.setString(4, renewDoctor.getDoctorAddress());
		pstmt.setLong(5, renewDoctor.getDoctorPhoneNo());
		pstmt.setInt(6, renewDoctor.getDepartmentId());
		pstmt.setString(7, renewDoctor.getDoctorPassword());
		pstmt.setInt(8, doctorId);
		
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
	public Doctor displayDoctor(int doctorId) throws ClassNotFoundException, SQLException {
		
		con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from doctor where doctorId = ?");
		pstmt.setInt(1,doctorId);
		
		rs=pstmt.executeQuery();
		
		Doctor doctor=new Doctor();
		while(rs.next())
		{
			doctor.setDoctorId(rs.getInt("doctorId"));
			doctor.setDepartmentId(rs.getInt("departmentId"));
			doctor.setDoctorAddress(rs.getString("doctorAddress"));
			doctor.setDoctorName(rs.getString("doctorName"));
			doctor.setDoctorPhoneNo(rs.getLong("doctorPhoneNo"));
			doctor.setSpecialization(rs.getString("specialization"));
			doctor.setTiming(rs.getString("timing"));
			doctor.setDoctorPassword(rs.getString("doctorPassword"));
		}
		
		closeConnection(con);
		return doctor;
	}

	@Override
	public TreeSet<Doctor> displayAllDoctors() throws ClassNotFoundException, SQLException {
		con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from doctor ");
		
		
		rs=pstmt.executeQuery();
		
		TreeSet<Doctor> doctorList=new TreeSet<Doctor>();
		
		Doctor doctor=new Doctor();
		while(rs.next())
		{
			doctor.setDoctorId(rs.getInt("doctorId"));
			doctor.setDepartmentId(rs.getInt("departmentId"));
			doctor.setDoctorAddress(rs.getString("doctorAddress"));
			doctor.setDoctorName(rs.getString("doctorName"));
			doctor.setDoctorPhoneNo(rs.getLong("doctorPhoneNo"));
			doctor.setSpecialization(rs.getString("specialization"));
			doctor.setTiming(rs.getString("timing"));
			doctor.setDoctorPassword(rs.getString("doctorPassword"));
			doctorList.add(doctor);
		}
		
		closeConnection(con);

		return doctorList;
	}

}
