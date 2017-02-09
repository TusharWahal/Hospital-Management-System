package dao;

import java.sql.SQLException;
import java.util.TreeSet;

import bean.OT;

public interface OTDao {
	public boolean insertOT(OT newOT) throws ClassNotFoundException, SQLException;
	public boolean deleteOT(int OTId) throws ClassNotFoundException, SQLException;
	public boolean updateOT(int OTId, OT renewOT) throws ClassNotFoundException, SQLException;
	public OT displayOT(int OTId) throws ClassNotFoundException, SQLException;
	public TreeSet<OT> displayAllOTs() throws ClassNotFoundException, SQLException;
}

