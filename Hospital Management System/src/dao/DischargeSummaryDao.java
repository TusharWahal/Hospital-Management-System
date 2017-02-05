package dao;

import java.util.TreeSet;

import bean.DischargeSummary;

public interface DischargeSummaryDao {
	public void insertDischargeSummary(DischargeSummary newDischargeSummary);
	public DischargeSummary deleteDischargeSummary(int DischargeSummaryId);
	public void updateDischargeSummary(int DischargeSummaryId, DischargeSummary renewDischargeSummary);
	public DischargeSummary displayDischargeSummary(int DischargeSummaryId);
	public TreeSet<DischargeSummary> displayAllDischargeSummarys();
}
