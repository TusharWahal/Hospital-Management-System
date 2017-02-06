package dao;

import java.util.TreeSet;

import bean.DischargeSummary;

public interface DischargeSummaryDao {
	public boolean insertDischargeSummary(DischargeSummary newDischargeSummary);
	public boolean deleteDischargeSummary(int DischargeSummaryId);
	public boolean updateDischargeSummary(int DischargeSummaryId, DischargeSummary renewDischargeSummary);
	public DischargeSummary displayDischargeSummary(int DischargeSummaryId);
	public TreeSet<DischargeSummary> displayAllDischargeSummarys();
}
