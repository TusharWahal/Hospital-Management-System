package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.TreeSet;

import bean.Bill;

public interface BillDao {
	public boolean insertBill(Bill newBill) throws ClassNotFoundException, SQLException, IOException;
	public boolean deleteBill(int BillId) throws ClassNotFoundException, SQLException, IOException;
	public boolean updateBill(int BillId, Bill renewBill) throws ClassNotFoundException, SQLException, IOException;
	public Bill displayBill(int BillId) throws ClassNotFoundException, SQLException, IOException;
	public TreeSet<Bill> displayAllBills() throws ClassNotFoundException, SQLException, IOException;
}
