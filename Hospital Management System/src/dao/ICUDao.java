package dao;

import java.util.TreeSet;

import bean.ICU;

public interface ICUDao {
	public boolean insertICU(ICU newICU);
	public boolean deleteICU(int ICUId);
	public boolean updateICU(int ICUId, ICU renewICU);
	public ICU displayICU(int ICUId);
	public TreeSet<ICU> displayAllICUs();
}
