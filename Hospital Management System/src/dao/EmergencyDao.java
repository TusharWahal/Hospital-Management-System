package dao;

import java.util.ArrayList;

import bean.Emergency;

public interface EmergencyDao {
	public boolean insertEmergency(Emergency newEmergency);
	public boolean deleteEmergency(int emergencyId);
	public boolean updateEmergency(int emergencyId, Emergency renewEmergency);
	public Emergency displayEmergency(int emergencyId);
	public ArrayList<Emergency> displayAllEmergencys();
}
