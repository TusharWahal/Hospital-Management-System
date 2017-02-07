package dao;

import java.sql.SQLException;
import java.util.TreeSet;

import bean.Medicine;

public interface MedicineDao {
	public boolean insertMedicine(Medicine newMedicine) throws ClassNotFoundException, SQLException;
	public boolean deleteMedicine(int sNo) throws ClassNotFoundException, SQLException;
	public boolean updateMedicine(int sNo, Medicine renewMedicine) throws ClassNotFoundException, SQLException;
	public Medicine displayMedicine(int sNo) throws ClassNotFoundException, SQLException;
	public TreeSet<Medicine> displayAllMedicines() throws ClassNotFoundException, SQLException;
}
