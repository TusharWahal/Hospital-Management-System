package dao;

import java.util.TreeSet;

import bean.Reception;

public interface ReceptionDao {
	public boolean insertReception(Reception newReception);
	public boolean deleteReception(int ReceptionId);
	public boolean updateReception(int ReceptionId, Reception renewReception);
	public Reception displayReception(int ReceptionId);
	public TreeSet<Reception> displayAllReceptions();
}
