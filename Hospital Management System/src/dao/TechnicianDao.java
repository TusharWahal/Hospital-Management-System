package dao;

import java.util.TreeSet;

import bean.Technician;

public interface TechnicianDao {
	public void insertTechnician(Technician newTechnician);
	public Technician deleteTechnician(int technicianId);
	public void updateTechnician(int technicianId, Technician renewTechnician);
	public Technician displayTechnician(int technicianId);
	public TreeSet<Technician> displayAllTechnicians();
}
