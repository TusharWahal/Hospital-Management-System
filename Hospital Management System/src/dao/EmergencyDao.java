package dao;

import java.util.TreeSet;

import bean.Emergency;

public interface EmergencyDao {
	public void insertEmergency(Emergency newEmergency);
	public Emergency deleteEmergency(int EmergencyId);
	public void updateEmergency(int EmergencyId, Emergency renewEmergency);
	public Emergency displayEmergency(int EmergencyId);
	public TreeSet<Emergency> displayAllEmergencys();
}
