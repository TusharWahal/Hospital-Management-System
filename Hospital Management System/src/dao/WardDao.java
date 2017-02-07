package dao;

import java.sql.SQLException;
import java.util.TreeSet;

import bean.Ward;

public interface WardDao {
	public boolean insertWard(Ward newWard) throws ClassNotFoundException, SQLException;
	public boolean deleteWard(int bedNo) throws ClassNotFoundException, SQLException;
	public boolean updateWard(int bedNo, Ward renewWard) throws ClassNotFoundException, SQLException;
	public Ward displayWard(int bedNo) throws ClassNotFoundException, SQLException;
	public TreeSet<Ward> displayAllWards() throws ClassNotFoundException, SQLException;
	//test
}
