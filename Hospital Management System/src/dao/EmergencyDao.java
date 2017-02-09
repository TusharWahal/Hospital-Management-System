package dao;

import java.util.ArrayList;

import bean.Emergency;

public interface EmergencyDao {
	public boolean insertEmergency(Emergency newEmergency);
	public boolean deleteEmergency(int EmergencyId);
	public boolean updateEmergency(int EmergencyId, Emergency renewEmergency);
	public Emergency displayEmergency(int EmergencyId);
	public ArrayList<Emergency> displayAllEmergencys();
}
