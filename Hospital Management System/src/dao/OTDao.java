package dao;

import java.util.TreeSet;

import bean.OT;

public interface OTDao {
	public boolean insertOT(OT newOT);
	public boolean deleteOT(int OTId);
	public boolean updateOT(int OTId, OT renewOT);
	public OT displayOT(int OTId);
	public TreeSet<OT> displayAllOTs();
}

