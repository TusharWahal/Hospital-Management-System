package businessLogic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.TreeSet;

import bean.Department;
import bean.Doctor;
import bean.Staff;
import bean.Technician;
import dao.DepartmentDaoImpl;
import dao.DoctorDaoImpl;
import dao.StaffDaoImpl;
import dao.TechnicianDaoImpl;



public class DepartmentBusinessLogic {

	DepartmentDaoImpl dd = new DepartmentDaoImpl();
	DoctorDaoImpl dod=new DoctorDaoImpl();
	StaffDaoImpl sd=new StaffDaoImpl();
	TechnicianDaoImpl td=new TechnicianDaoImpl();
	
	public TreeSet<Department> listDepartment() throws ClassNotFoundException, SQLException, IOException
	{
		return dd.displayAllDepartments();
	}
	
	public TreeSet<Doctor> departmentDoctors(int departmentId) throws ClassNotFoundException, SQLException, IOException
	{
		TreeSet<Doctor> doctorList=new TreeSet<Doctor>();
		doctorList=dod.displayAllDoctors();
		TreeSet<Doctor> departmentDoctorList=new TreeSet<Doctor>();
		for(Doctor dl: doctorList){
			if(dl.getDepartmentId()==departmentId){
				departmentDoctorList.add(dl);
			}
		}
		return departmentDoctorList;
	}
	
	public TreeSet<Staff> departmentStaffs(int departmentId) throws ClassNotFoundException, SQLException, IOException
	{
		TreeSet<Staff> staffList=new TreeSet<Staff>();
		staffList=sd.displayAllStaffs();
		TreeSet<Staff> departmentStaffList=new TreeSet<Staff>();
		for(Staff sl: staffList){
			if(sl.getDepartmentId()==departmentId){
				departmentStaffList.add(sl);
			}
		}
		return departmentStaffList;
	}
	
	public TreeSet<Technician> departmentTechnicians(int departmentId) throws ClassNotFoundException, SQLException, IOException
	{
		TreeSet<Technician> technicianList=new TreeSet<Technician>();
		technicianList=td.displayAllTechnicians();
		TreeSet<Technician> departmentTechnicianList=new TreeSet<Technician>();
		for(Technician tl: technicianList){
			if(tl.getDepartmentId()==departmentId){
				departmentTechnicianList.add(tl);
			}
		}
		return departmentTechnicianList;
	}
//	public Department viewDepartment(int departmentId) throws ClassNotFoundException, SQLException
//	{
//		return dd.displayDepartment(departmentId);
//	}
//	
//	
//	public TreeSet<Doctor> listDoctor() throws ClassNotFoundException, SQLException
//	{
//		return dod.displayAllDoctors();
//	}
//	public Doctor viewDoctor(int doctorId) throws ClassNotFoundException, SQLException
//	{
//		return dod.displayDoctor(doctorId);
//	}
//
//	
//	public TreeSet<Staff> listStaff() throws ClassNotFoundException, SQLException
//	{
//		return sd.displayAllStaffs();
//	}
//	public Staff viewStaff(int staffId) throws ClassNotFoundException, SQLException
//	{
//		return sd.displayStaff(staffId);
//	}
//	
//	
//	public TreeSet<Technician> listTechnician() throws ClassNotFoundException, SQLException
//	{
//		return td.displayAllTechnicians();
//	}
//	public Technician viewTechnician(int technicianId) throws ClassNotFoundException, SQLException
//	{
//		return td.displayTechnician(technicianId);
//	}
}
