package dao;

import java.util.TreeSet;

import bean.OT;

public interface OTDao {
	public void insertOT(OT newOT);
	public OT deleteOT(int OTId);
	public void updateOT(int OTId, OT renewOT);
	public OT displayOT(int OTId);
	public TreeSet<OT> displayAllOTs();
}

