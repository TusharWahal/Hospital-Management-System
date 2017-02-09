package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.TreeSet;

import bean.OT;

public interface OTDao {
	public boolean insertOT(OT newOT) throws ClassNotFoundException, SQLException, IOException;
	public boolean deleteOT(int OTId) throws ClassNotFoundException, SQLException, IOException;
	public boolean updateOT(int OTId, OT renewOT) throws ClassNotFoundException, SQLException, IOException;
	public OT displayOT(int OTId) throws ClassNotFoundException, SQLException, IOException;
	public TreeSet<OT> displayAllOTs() throws ClassNotFoundException, SQLException, IOException;
}

