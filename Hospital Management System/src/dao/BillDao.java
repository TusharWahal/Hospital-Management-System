package dao;

import java.util.TreeSet;

import bean.Bill;

public interface BillDao {
	public void insertBill(Bill newBill);
	public Bill deleteBill(int BillId);
	public void updateBill(int BillId, Bill renewBill);
	public Bill displayBill(int BillId);
	public TreeSet<Bill> displayAllBills();
}
