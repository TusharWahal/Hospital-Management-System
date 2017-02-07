package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;
import java.sql.Connection;
import static helper.ConnectToDb.*;

import bean.MedicalReport;

public class MedicalReportDaoImpl implements MedicalReportDao {

	private PreparedStatement pstmt=null;
	private Connection con;
	private ResultSet rs;
	
	@Override
	public boolean insertMedicalReport(MedicalReport newMedicalReport) throws SQLException, ClassNotFoundException {
		con= openConnection(); 
		
		int patientId = newMedicalReport.getPatientId();
		Date visitDate = newMedicalReport.getVisitDate();
		String diagnosis=newMedicalReport.getDiagnosis();
		String investigations=newMedicalReport.getInvestigations();
		String tests=newMedicalReport.getTests();
		String recommendations=newMedicalReport.getRecommendations();
		
		pstmt=con.prepareStatement("insert into medicalreport (patientId,visitDate,diagnosis,investigations,tests,recommendations"
				+ "values" + "(?,?,?,?,?,?)");
		
		pstmt.setInt(1,patientId);
		pstmt.setDate(2, visitDate);
		pstmt.setString(3, diagnosis);
		pstmt.setString(4, investigations);
		pstmt.setString(5, tests);
		pstmt.setString(6, recommendations);
		
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
	public boolean deleteMedicalReport(int patientId) throws ClassNotFoundException, SQLException {
		con= openConnection();
		
		
		pstmt=con.prepareStatement("delete from medicalreport where patientId = ?");
		
		pstmt.setInt(1,patientId);
		
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
	public boolean updateMedicalReport(int MedicalReportId, MedicalReport renewMedicalReport) throws ClassNotFoundException, SQLException {
		con= openConnection();
		
		
		pstmt=con.prepareStatement("update medicalreport set visitDate = ? , diagnosis = ? "
				+ ", investigations = ? ,tests = ? "
				+ ", recommendations=? "
				+ "where patientId = ?");
		

		pstmt.setDate(1,renewMedicalReport.getVisitDate());
		pstmt.setString(2,renewMedicalReport.getDiagnosis());
		pstmt.setString(3, renewMedicalReport.getInvestigations());
		pstmt.setString(4, renewMedicalReport.getTests());
		pstmt.setString(5, renewMedicalReport.getRecommendations());
		
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
	public MedicalReport displayMedicalReport(int patientId) throws ClassNotFoundException, SQLException {
		con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from medicalreport where patientId = ?");
		pstmt.setInt(1,patientId);
		
		rs=pstmt.executeQuery();
		
		MedicalReport medicalreport=new MedicalReport();
		while(rs.next())
		{
			medicalreport.setPatientId(rs.getInt("patientId"));
			medicalreport.setVisitDate(rs.getDate("visitDate"));
			medicalreport.setDiagnosis(rs.getString("diagnosis"));
			medicalreport.setInvestigations(rs.getString("investigations"));
			medicalreport.setTests(rs.getString("tests"));
		}
		
		closeConnection(con);
		return medicalreport;
	}

	@Override
	public TreeSet<MedicalReport> displayAllMedicalReports() throws ClassNotFoundException, SQLException {
		con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from medicalreport ");
		
		
		rs=pstmt.executeQuery();
		
		TreeSet<MedicalReport> medicalReportList=new TreeSet<MedicalReport>();
		
		MedicalReport medicalreport=new MedicalReport();
		while(rs.next())
		{
			medicalreport.setPatientId(rs.getInt("patientId"));
			medicalreport.setVisitDate(rs.getDate("visitDate"));
			medicalreport.setDiagnosis(rs.getString("diagnosis"));
			medicalreport.setInvestigations(rs.getString("investigations"));
			medicalreport.setTests(rs.getString("tests"));
			medicalreport.setRecommendations(rs.getString("recommendations"));
			medicalReportList.add(medicalreport);
		}
		
		closeConnection(con);

		return medicalReportList;
	}

}
