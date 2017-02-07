package dao;

import java.sql.SQLException;
import java.util.TreeSet;

import bean.DischargeSummary;

public interface DischargeSummaryDao {
	public boolean insertDischargeSummary(DischargeSummary newDischargeSummary) throws ClassNotFoundException, SQLException;
	public boolean deleteDischargeSummary(int DischargeSummaryId) throws ClassNotFoundException, SQLException;
	public boolean updateDischargeSummary(int DischargeSummaryId, DischargeSummary renewDischargeSummary) throws ClassNotFoundException, SQLException;
	public DischargeSummary displayDischargeSummary(int DischargeSummaryId) throws ClassNotFoundException, SQLException;
	public TreeSet<DischargeSummary> displayAllDischargeSummarys() throws ClassNotFoundException, SQLException;
}
