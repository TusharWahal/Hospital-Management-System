package dao;

import java.sql.SQLException;
import java.util.TreeSet;

import bean.Medicine;

public interface MedicineDao {
	public boolean insertMedicine(Medicine newMedicine) throws ClassNotFoundException, SQLException;
	public boolean updateMedicine(int sNo, Medicine renewMedicine) throws ClassNotFoundException, SQLException;
	public TreeSet<Medicine> displayAllMedicines() throws ClassNotFoundException, SQLException;
	boolean deleteMedicine(int sNo, int patientId) throws ClassNotFoundException, SQLException;
	Medicine displayMedicine(int sNo, int patientId) throws ClassNotFoundException, SQLException;
}
