package dao;

import java.util.TreeSet;

import bean.Department;

public interface DepartmentDao {
	public void insertDepartment(Department newDepartment);
	public Department deleteDepartment(int departmentId);
	public void updateDepartment(int departmentId, Department renewDepartment);
	public Department displayDepartment(int departmentId);
	public TreeSet<Department> displayAllDepartments();
}
