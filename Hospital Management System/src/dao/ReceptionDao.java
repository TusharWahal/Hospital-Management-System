package dao;

import java.sql.SQLException;
import java.util.TreeSet;

import bean.Reception;

public interface ReceptionDao {
	public boolean insertReception(Reception newReception) throws ClassNotFoundException,SQLException;
	public boolean deleteReception(int ReceptionId) throws ClassNotFoundException,SQLException;
	public boolean updateReception(int ReceptionId, Reception renewReception) throws ClassNotFoundException,SQLException;
	public Reception displayReception(int ReceptionId) throws ClassNotFoundException,SQLException;
	public TreeSet<Reception> displayAllReceptions() throws ClassNotFoundException,SQLException;
}
