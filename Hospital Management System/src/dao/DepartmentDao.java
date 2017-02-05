package dao;

import java.sql.SQLException;
import java.util.TreeSet;

import bean.Department;

public interface DepartmentDao {
	public boolean insertDepartment(Department newDepartment) throws ClassNotFoundException, SQLException;
	public boolean deleteDepartment(int departmentId) throws SQLException, ClassNotFoundException;
	public boolean updateDepartment(int departmentId, Department renewDepartment) throws ClassNotFoundException, SQLException;
	public Department displayDepartment(int departmentId) throws ClassNotFoundException, SQLException;
	public TreeSet<Department> displayAllDepartments() throws ClassNotFoundException, SQLException;
}
