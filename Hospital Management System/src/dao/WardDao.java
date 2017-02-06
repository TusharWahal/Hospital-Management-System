package dao;

import java.util.TreeSet;

import bean.Ward;

public interface WardDao {
	public boolean insertWard(Ward newWard);
	public boolean deleteWard(int bedNo);
	public boolean updateWard(int bedNo, Ward renewWard);
	public Ward displayWard(int bedNo);
	public TreeSet<Ward> displayAllWards();
}
