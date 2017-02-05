package dao;

import java.util.TreeSet;

import bean.Reception;

public interface ReceptionDao {
	public void insertReception(Reception newReception);
	public Reception deleteReception(int ReceptionId);
	public void updateReception(int ReceptionId, Reception renewReception);
	public Reception displayReception(int ReceptionId);
	public TreeSet<Reception> displayAllReceptions();
}
