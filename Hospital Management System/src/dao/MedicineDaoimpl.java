package dao;

import static helper.ConnectToDb.closeConnection;
import static helper.ConnectToDb.openConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;

import bean.MedicalReport;
import bean.Medicine;

public class MedicineDaoimpl implements MedicineDao {
	
	private PreparedStatement pstmt=null;
	private Connection con;
	private ResultSet rs;

	@Override
	public boolean insertMedicine(Medicine newMedicine) throws ClassNotFoundException, SQLException {
		con= openConnection(); 
		
		int sNo = newMedicine.getsNo();
		String medicineName = newMedicine.getMedicineName();
		int quantity=newMedicine.getQuantity();
		String dosage=newMedicine.getDosage();
		float price=newMedicine.getPrice();
		
		pstmt=con.prepareStatement("insert into medicalreport (sNo,medicineName,quantity,dosage,price)"
				+ "values" + "(?,?,?,?,?)");
		
		pstmt.setInt(1,sNo);
		pstmt.setString(2, medicineName);
		pstmt.setInt(3, quantity);
		pstmt.setString(4, dosage);
		pstmt.setFloat(5, price);
		
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
	public boolean deleteMedicine(int sNo) throws ClassNotFoundException, SQLException {
		con= openConnection();
		
		
		pstmt=con.prepareStatement("delete from medicine where sNo = ?");
		
		pstmt.setInt(1,sNo);
		
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
	public boolean updateMedicine(int sNo, Medicine renewMedicine) throws ClassNotFoundException, SQLException {
		con= openConnection();
		
		
		pstmt=con.prepareStatement("update medicine set medicineName = ? , quantity = ? "
				+ ", dosage = ? ,price = ? "
				+ "where sNo = ?");
		

		pstmt.setString(1,renewMedicine.getMedicineName());
		pstmt.setInt(2,renewMedicine.getQuantity());
		pstmt.setString(3, renewMedicine.getDosage());
		pstmt.setFloat(4, renewMedicine.getPrice());
		
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
	public Medicine displayMedicine(int sNo) throws ClassNotFoundException, SQLException {
		con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from medicine where sNo = ?");
		pstmt.setInt(1,sNo);
		
		rs=pstmt.executeQuery();
		
		Medicine medicine=new Medicine();
		while(rs.next())
		{
			medicine.setsNo(rs.getInt("sNo"));
			medicine.setMedicineName(rs.getString("medicineName"));
			medicine.setQuantity(rs.getInt("quantity"));
			medicine.setDosage(rs.getString("dosage"));
			medicine.setPrice(rs.getFloat("price"));
		}
		
		closeConnection(con);
		return medicine;
	}

	@Override
	public TreeSet<Medicine> displayAllMedicines() throws ClassNotFoundException, SQLException {
		con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from medicine ");
		
		
		rs=pstmt.executeQuery();
		
		TreeSet<Medicine> medicineList=new TreeSet<Medicine>();
		
		Medicine medicine = new Medicine();
		while(rs.next())
		{
			medicine.setsNo(rs.getInt("sNo"));
			medicine.setMedicineName(rs.getString("medicineName"));
			medicine.setQuantity(rs.getInt("quantity"));
			medicine.setDosage(rs.getString("dosage"));
			medicine.setPrice(rs.getFloat("price"));
			medicineList.add(medicine);
		}
		
		closeConnection(con);

		return medicineList;
	}

}
