package dao;

import static helper.ConnectToDb.closeConnection;
import static helper.ConnectToDb.openConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;

import bean.Bill;
import bean.DischargeSummary;

public class DischargeSummaryDaoImpl implements DischargeSummaryDao {

	private PreparedStatement pstmt=null;
	private Connection con;
	private ResultSet rs;
	
	@Override
	public boolean insertDischargeSummary(DischargeSummary newDischargeSummary) throws ClassNotFoundException, SQLException {


		con= openConnection();
		
		 int serialNo = newDischargeSummary.getSerialNo();
		 Date admissionDate = newDischargeSummary.getAdmissionDate();
		 Date dischargeDate = newDischargeSummary.getDischargeDate();
		 String history = newDischargeSummary.getHistory();
		 String onExamination = newDischargeSummary.getOnExamination();
		 String operationDone = newDischargeSummary.getOperationDone();
		 String operationFindings = newDischargeSummary.getOperativeFindings();
		 String treatmentGiven = newDischargeSummary.getTreatmentGiven();
		 String recommendations = newDischargeSummary.getRecommendations();
		
		pstmt=con.prepareStatement("insert into DischargeSummary (serialNo,admissionDate,dischargeDate,history" +
				",onExamination,operationDone,operationFindings,treatmentGiven,recommendations) values (?,?,?,?,?,?,?,?,?)");
		
		pstmt.setInt(1,serialNo);
		pstmt.setDate(2, admissionDate);
		pstmt.setDate(3, dischargeDate);
		pstmt.setString(4, history);
		pstmt.setString(5, onExamination);
		pstmt.setString(6, operationDone);
		pstmt.setString(7, operationFindings);
		pstmt.setString(8, treatmentGiven);
		pstmt.setString(9, recommendations);
		
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
	public boolean deleteDischargeSummary(int dischargeSummaryId) throws ClassNotFoundException, SQLException {

		con= openConnection();
		
		
		pstmt=con.prepareStatement("delete from DischargeSummary where dischargeSummaryId = ?");
		
		pstmt.setInt(1,dischargeSummaryId);
		
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
	public boolean updateDischargeSummary(int dischargeSummaryId, DischargeSummary renewDischargeSummary) throws ClassNotFoundException, SQLException {

		con= openConnection();
		
		
		pstmt=con.prepareStatement("update DischargeSummary set admissionDate=?,dischargeDate=?,history=?" +
				",onExamination=?,operationDone=?,operationFindings=?,treatmentGiven=?,recommendations=? where serialNo=?");
		

		
		pstmt.setDate(1, renewDischargeSummary.getAdmissionDate());
		pstmt.setDate(2, renewDischargeSummary.getDischargeDate());
		pstmt.setString(3, renewDischargeSummary.getHistory());
		pstmt.setString(4, renewDischargeSummary.getOnExamination());
		pstmt.setString(5, renewDischargeSummary.getOperationDone());
		pstmt.setString(6, renewDischargeSummary.getOperativeFindings());
		pstmt.setString(7, renewDischargeSummary.getTreatmentGiven());
		pstmt.setString(8, renewDischargeSummary.getRecommendations());
		pstmt.setInt(9,dischargeSummaryId);
		
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
	public DischargeSummary displayDischargeSummary(int dischargeSummaryId) throws ClassNotFoundException, SQLException {

		con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from DischargeSummary where serialNo = ?");
		pstmt.setInt(1,dischargeSummaryId);
		
		rs=pstmt.executeQuery();
		
		DischargeSummary dischargeSummary = new DischargeSummary();
		 
		 dischargeSummary.setSerialNo(rs.getInt("serailNo"));
		 dischargeSummary.setAdmissionDate(rs.getDate("admissionDate"));
		 dischargeSummary.setDischargeDate(rs.getDate("discahrgeDate"));
		 dischargeSummary.setHistory(rs.getString("history"));
		 dischargeSummary.setOnExamination(rs.getString("onExamination"));
		 dischargeSummary.setOperationDone(rs.getString("operationDone"));
		 dischargeSummary.setOperativeFindings(rs.getString("operativeFindings"));
		 dischargeSummary.setTreatmentGiven(rs.getString("treatmentGiven"));
		 dischargeSummary.setRecommendations(rs.getString("recommendations"));
		
		closeConnection(con);
		return dischargeSummary;
	}

	@Override
	public TreeSet<DischargeSummary> displayAllDischargeSummarys() throws ClassNotFoundException, SQLException {

		con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from DischargeSummary");
		
		
		rs=pstmt.executeQuery();
		
		TreeSet<DischargeSummary> dischargeSummaryList=new TreeSet<DischargeSummary>();
		DischargeSummary dischargeSummary = new DischargeSummary();
		
		
		while(rs.next())
		{
			dischargeSummary.setSerialNo(rs.getInt("serailNo"));
			 dischargeSummary.setAdmissionDate(rs.getDate("admissionDate"));
			 dischargeSummary.setDischargeDate(rs.getDate("discahrgeDate"));
			 dischargeSummary.setHistory(rs.getString("history"));
			 dischargeSummary.setOnExamination(rs.getString("onExamination"));
			 dischargeSummary.setOperationDone(rs.getString("operationDone"));
			 dischargeSummary.setOperativeFindings(rs.getString("operativeFindings"));
			 dischargeSummary.setTreatmentGiven(rs.getString("treatmentGiven"));
			 dischargeSummary.setRecommendations(rs.getString("recommendations"));
			dischargeSummaryList.add(dischargeSummary);
		}
		
		closeConnection(con);
		return dischargeSummaryList;
	}

}
