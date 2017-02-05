package dao;

import java.util.TreeSet;

import bean.Ward;

public interface WardDao {
	public void insertWard(Ward newWard);
	public Ward deleteWard(int bedNo);
	public void updateWard(int bedNo, Ward renewWard);
	public Ward displayWard(int bedNo);
	public TreeSet<Ward> displayAllWards();
}
