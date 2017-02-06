package dao;

import java.util.TreeSet;

import bean.Medicine;

public interface MedicineDao {
	public boolean insertMedicine(Medicine newMedicine);
	public boolean deleteMedicine(int sNo);
	public boolean updateMedicine(int sNo, Medicine renewMedicine);
	public Medicine displayMedicine(int sNo);
	public TreeSet<Medicine> displayAllMedicines();
}
