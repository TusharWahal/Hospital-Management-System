package dao;

import java.sql.SQLException;
import java.util.TreeSet;

import bean.ICU;

public interface ICUDao {
	public boolean insertICU(ICU newICU) throws ClassNotFoundException, SQLException;
	public boolean deleteICU(int ICUId) throws ClassNotFoundException, SQLException;
	public boolean updateICU(int ICUId, ICU renewICU) throws ClassNotFoundException, SQLException;
	public ICU displayICU(int ICUId) throws ClassNotFoundException, SQLException;
	public TreeSet<ICU> displayAllICUs() throws ClassNotFoundException, SQLException;
}
