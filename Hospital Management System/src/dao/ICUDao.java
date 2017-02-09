package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.TreeSet;

import bean.ICU;

public interface ICUDao {
	public boolean insertICU(ICU newICU) throws ClassNotFoundException, SQLException, IOException;
	public boolean deleteICU(int ICUId) throws ClassNotFoundException, SQLException, IOException;
	public boolean updateICU(int ICUId, ICU renewICU) throws ClassNotFoundException, SQLException, IOException;
	public ICU displayICU(int ICUId) throws ClassNotFoundException, SQLException, IOException;
	public TreeSet<ICU> displayAllICUs() throws ClassNotFoundException, SQLException, IOException;
}
