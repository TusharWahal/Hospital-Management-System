package dao;

import java.sql.SQLException;
import java.util.TreeSet;

import bean.Bill;

public interface BillDao {
	public boolean insertBill(Bill newBill) throws ClassNotFoundException, SQLException;
	public boolean deleteBill(int BillId) throws ClassNotFoundException, SQLException;
	public boolean updateBill(int BillId, Bill renewBill) throws ClassNotFoundException, SQLException;
	public Bill displayBill(int BillId) throws ClassNotFoundException, SQLException;
	public TreeSet<Bill> displayAllBills() throws ClassNotFoundException, SQLException;
}
