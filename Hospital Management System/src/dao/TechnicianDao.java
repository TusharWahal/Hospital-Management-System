package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Technician;

public interface TechnicianDao {
	public boolean insertTechnician (Technician newTechnician) throws ClassNotFoundException, SQLException, IOException;
	public boolean deleteTechnician(int technicianId) throws ClassNotFoundException, SQLException, IOException;
	public boolean updateTechnician(int technicianId, Technician renewTechnician) throws ClassNotFoundException, SQLException, IOException;
	public Technician displayTechnician(int technicianId) throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Technician> displayAllTechnicians() throws ClassNotFoundException, SQLException, IOException;
}
