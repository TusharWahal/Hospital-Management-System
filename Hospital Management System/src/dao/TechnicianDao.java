package dao;

import java.sql.SQLException;
import java.util.TreeSet;

import bean.Technician;

public interface TechnicianDao {
	public boolean insertTechnician (Technician newTechnician) throws ClassNotFoundException, SQLException;
	public boolean deleteTechnician(int technicianId) throws ClassNotFoundException, SQLException;
	public boolean updateTechnician(int technicianId, Technician renewTechnician) throws ClassNotFoundException, SQLException;
	public Technician displayTechnician(int technicianId) throws ClassNotFoundException, SQLException;
	public TreeSet<Technician> displayAllTechnicians() throws ClassNotFoundException, SQLException;
}
