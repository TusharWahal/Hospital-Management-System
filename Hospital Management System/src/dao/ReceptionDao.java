package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.TreeSet;

import bean.Reception;

public interface ReceptionDao {
	public boolean insertReception(Reception newReception) throws ClassNotFoundException,SQLException, IOException;
	public boolean deleteReception(int ReceptionId) throws ClassNotFoundException,SQLException, IOException;
	public boolean updateReception(int ReceptionId, Reception renewReception) throws ClassNotFoundException,SQLException, IOException;
	public Reception displayReception(int ReceptionId) throws ClassNotFoundException,SQLException, IOException;
	public TreeSet<Reception> displayAllReceptions() throws ClassNotFoundException,SQLException, IOException;
}
