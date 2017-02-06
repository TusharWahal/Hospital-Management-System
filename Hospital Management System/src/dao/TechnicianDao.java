package dao;

import java.util.TreeSet;

import bean.Technician;

public interface TechnicianDao {
	public boolean insertTechnician(Technician newTechnician);
	public boolean deleteTechnician(int technicianId);
	public boolean updateTechnician(int technicianId, Technician renewTechnician);
	public Technician displayTechnician(int technicianId);
	public TreeSet<Technician> displayAllTechnicians();
}
