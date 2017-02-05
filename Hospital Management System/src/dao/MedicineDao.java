package dao;

import java.util.TreeSet;

import bean.Medicine;

public interface MedicineDao {
	public void insertMedicine(Medicine newMedicine);
	public Medicine deleteMedicine(int sNo);
	public void updateMedicine(int sNo, Medicine renewMedicine);
	public Medicine displayMedicine(int sNo);
	public TreeSet<Medicine> displayAllMedicines();
}
