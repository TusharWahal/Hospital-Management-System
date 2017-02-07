package dao;

import static helper.ConnectToDb.closeConnection;
import static helper.ConnectToDb.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;

import bean.Bill;
import bean.Person;

public class BillDaoImpl implements BillDao {
	
	private PreparedStatement pstmt=null;
	private Connection con;
	private ResultSet rs;

	@Override
	public boolean insertBill(Bill newBill) throws ClassNotFoundException, SQLException {

		con= openConnection();
		
		int number = newBill.getNumber();
		float doctorVisit = newBill.getDoctorVisit();
		float bedCharges = newBill.getBedCharges();
		float tests = newBill.getTests();
		float medicines = newBill.getMedicines();
		
		pstmt=con.prepareStatement("insert into Bill (number,doctorVisit,bedCharges,tests,medicines" +
				") values (?,?,?,?,?)");
		
		pstmt.setInt(1,number);
		pstmt.setFloat(2, doctorVisit);
		pstmt.setFloat(3, bedCharges);
		pstmt.setFloat(4, tests);
		pstmt.setFloat(5, medicines);
		
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
	public boolean deleteBill(int billId) throws ClassNotFoundException, SQLException {

		con= openConnection();
		
		
		pstmt=con.prepareStatement("delete from Bill where billId = ?");
		
		pstmt.setInt(1,billId);
		
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
	public boolean updateBill(int BillId, Bill renewBill) throws ClassNotFoundException, SQLException {

		con= openConnection();
		
		
		pstmt=con.prepareStatement("update Bill set doctorVisit=?,bedCharges=?," +
				"tests=?,medicines=? where number=?");
		

		pstmt.setFloat(1,renewBill.getDoctorVisit());
		pstmt.setFloat(2, renewBill.getBedCharges());
		pstmt.setFloat(3, renewBill.getTests());
		pstmt.setFloat(4, renewBill.getMedicines());
		pstmt.setInt(5, renewBill.getNumber());
		
		
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
	public Bill displayBill(int billId) throws ClassNotFoundException, SQLException {

		con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from Bill where number = ?");
		pstmt.setInt(1,billId);
		
		rs=pstmt.executeQuery();
		
		Bill bill = new Bill();
		
		
		
			bill.setNumber(rs.getInt("number"));
			bill.setDoctorVisit(rs.getFloat("doctorVisit"));
			bill.setBedCharges(rs.getFloat("bedCharges"));
			bill.setTests(rs.getFloat("tests"));
			bill.setMedicines(rs.getFloat("medicines"));
		
		closeConnection(con);
		return bill;
	}

	@Override
	public TreeSet<Bill> displayAllBills() throws ClassNotFoundException, SQLException {

		con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from Bill");
		
		
		rs=pstmt.executeQuery();
		
		TreeSet<Bill> billList=new TreeSet<Bill>();
		Bill bill = new Bill();
		
		
		while(rs.next())
		{
			bill.setNumber(rs.getInt("number"));
			bill.setDoctorVisit(rs.getFloat("doctorVisit"));
			bill.setBedCharges(rs.getFloat("bedCharges"));
			bill.setTests(rs.getFloat("tests"));
			bill.setMedicines(rs.getFloat("medicines"));
			billList.add(bill);
		}
		
		closeConnection(con);
		return billList;
	}

}
