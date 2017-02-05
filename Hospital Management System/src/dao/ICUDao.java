package dao;

import java.util.TreeSet;

import bean.ICU;

public interface ICUDao {
	public void insertICU(ICU newICU);
	public ICU deleteICU(int ICUId);
	public void updateICU(int ICUId, ICU renewICU);
	public ICU displayICU(int ICUId);
	public TreeSet<ICU> displayAllICUs();
}
