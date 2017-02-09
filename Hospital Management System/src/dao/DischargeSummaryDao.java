package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.TreeSet;

import bean.DischargeSummary;

public interface DischargeSummaryDao {
	public boolean insertDischargeSummary(DischargeSummary newDischargeSummary) throws ClassNotFoundException, SQLException, IOException;
	public boolean deleteDischargeSummary(int DischargeSummaryId) throws ClassNotFoundException, SQLException, IOException;
	public boolean updateDischargeSummary(int DischargeSummaryId, DischargeSummary renewDischargeSummary) throws ClassNotFoundException, SQLException, IOException;
	public DischargeSummary displayDischargeSummary(int DischargeSummaryId) throws ClassNotFoundException, SQLException, IOException;
	public TreeSet<DischargeSummary> displayAllDischargeSummarys() throws ClassNotFoundException, SQLException, IOException;
}
