package dao;

import java.util.TreeSet;

import bean.Bill;

public interface BillDao {
	public boolean insertBill(Bill newBill);
	public boolean deleteBill(int BillId);
	public boolean updateBill(int BillId, Bill renewBill);
	public Bill displayBill(int BillId);
	public TreeSet<Bill> displayAllBills();
}
