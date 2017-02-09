package businessLogic;

import java.sql.SQLException;
import java.util.TreeSet;

import bean.Bill;
import bean.Department;
import bean.DischargeSummary;
import bean.Doctor;
import bean.MedicalReport;
import bean.Person;
import bean.Reception;
import bean.Staff;
import bean.Technician;
import dao.BillDaoImpl;
import dao.DepartmentDaoImpl;
import dao.DischargeSummaryDaoImpl;
import dao.MedicalReportDaoImpl;
import dao.PersonDaoImpl;
import dao.ReceptionDaoImpl;
import dao.DoctorDaoImpl;
import dao.StaffDaoImpl;
import dao.TechnicianDaoImpl;

public class AdminBusinessLogic {
	
	ReceptionDaoImpl rd=new ReceptionDaoImpl();
	MedicalReportDaoImpl mrd=new MedicalReportDaoImpl();
	DischargeSummaryDaoImpl dsd=new DischargeSummaryDaoImpl();
	BillDaoImpl bd=new BillDaoImpl();
	DepartmentDaoImpl dd=new DepartmentDaoImpl();
	DoctorDaoImpl dod=new DoctorDaoImpl();
	StaffDaoImpl sd=new StaffDaoImpl();
	TechnicianDaoImpl td=new TechnicianDaoImpl();
	PersonDaoImpl pd=new PersonDaoImpl();

	public boolean adminLogin(String username, String password) throws ClassNotFoundException, SQLException
	{
		if(username==null)
		{
			return false;
		}
		else if(username=="admin")
		{
			if(password.equals("pass")){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	
	/**********************************************Reception**********************************************/
	public boolean addReception(Reception newReception) throws ClassNotFoundException, SQLException
	{
		return rd.insertReception(newReception);	
	}
	public boolean removeReception(int regNo) throws ClassNotFoundException, SQLException
	{
		return rd.deleteReception(regNo);
	}
	public boolean modifyReception(int regNo, Reception newReception) throws ClassNotFoundException, SQLException
	{
		return rd.updateReception(regNo,newReception);
	}
	public TreeSet<Reception> listReception() throws ClassNotFoundException, SQLException
	{
		return rd.displayAllReceptions();
	}
	public Reception viewReceptions(int regNo) throws ClassNotFoundException, SQLException
	{
		return rd.displayReception(regNo);
	}
	
	
	/**********************************************Medical Report**********************************************/
	public boolean addMedicalReport(MedicalReport newMedicalReport) throws ClassNotFoundException, SQLException
	{
		return mrd.insertMedicalReport(newMedicalReport);
		
	}
	public boolean removeMedicalReport(int patientId) throws ClassNotFoundException, SQLException
	{
		return mrd.deleteMedicalReport(patientId);
	}
	public boolean modifyMedicalReport(int patientId,MedicalReport newMedicalReport) throws ClassNotFoundException, SQLException
	{
		return mrd.updateMedicalReport(patientId,newMedicalReport);
	}
	public TreeSet<MedicalReport> listMedicalReport() throws ClassNotFoundException, SQLException
	{
		return mrd.displayAllMedicalReports();
	}
	public MedicalReport viewMedicalReports(int patientId) throws ClassNotFoundException, SQLException
	{
		return mrd.displayMedicalReport(patientId);
	}
	

	/**********************************************Discharge Summary**********************************************/
	public boolean addDischargeSummary(DischargeSummary newDischargeSummary) throws ClassNotFoundException, SQLException
	{
		return dsd.insertDischargeSummary(newDischargeSummary);
	}
	public boolean removeDischargeSummary(int serialNo) throws ClassNotFoundException, SQLException
	{
		return dsd.deleteDischargeSummary(serialNo);
	}
	public boolean modifyDischargeSummary(int serialNo,DischargeSummary newDischargeSummary) throws ClassNotFoundException, SQLException
	{
		return dsd.updateDischargeSummary(serialNo,newDischargeSummary);
	}
	public TreeSet<DischargeSummary> listDischargeSummary() throws ClassNotFoundException, SQLException
	{
		return dsd.displayAllDischargeSummarys();
	}
	public DischargeSummary viewDischargeSummary(int serialNo) throws ClassNotFoundException, SQLException
	{
		return dsd.displayDischargeSummary(serialNo);
	}
	
	
	/**********************************************Bills**********************************************/
	public boolean addBill(Bill newBill) throws ClassNotFoundException, SQLException
	{
		return bd.insertBill(newBill);	
	}
	public boolean removeBill(int number) throws ClassNotFoundException, SQLException
	{
		return bd.deleteBill(number);
	}
	public boolean modifyBill(int number, Bill newBill) throws ClassNotFoundException, SQLException
	{
		return bd.updateBill(number,newBill);
	}
	public TreeSet<Bill> listBill() throws ClassNotFoundException, SQLException
	{
		return bd.displayAllBills();
	}
	public Bill viewBill(int number) throws ClassNotFoundException, SQLException
	{
		return bd.displayBill(number);
	}
	public float calculateBill(int number) throws ClassNotFoundException, SQLException{
		Bill cBill=new Bill();
		cBill = bd.displayBill(number);
		float totalBill = cBill.getDoctorVisit() + cBill.getBedCharges() + cBill.getTests() + cBill.getMedicines();
		return totalBill;
	}
	
	/**********************************************Department**********************************************/
	public boolean addDepartment(Department newDepartment) throws ClassNotFoundException, SQLException
	{
		return dd.insertDepartment(newDepartment);	
	}
	public boolean removeDepartment(int departmentId) throws ClassNotFoundException, SQLException
	{
		return dd.deleteDepartment(departmentId);
	}
	public boolean modifyDepartment(int departmentId, Department newDepartment) throws ClassNotFoundException, SQLException
	{
		return dd.updateDepartment(departmentId,newDepartment);
	}
	public TreeSet<Department> listDepartment() throws ClassNotFoundException, SQLException
	{
		return dd.displayAllDepartments();
	}
	public Department viewDepartment(int departmentId) throws ClassNotFoundException, SQLException
	{
		return dd.displayDepartment(departmentId);
	}
	
	
	/**********************************************Doctor**********************************************/
	public boolean addDoctor(Doctor newDoctor) throws ClassNotFoundException, SQLException
	{
		return dod.insertDoctor(newDoctor);	
	}
	public boolean removeDoctor(int doctorId) throws ClassNotFoundException, SQLException
	{
		return dod.deleteDoctor(doctorId);
	}
	public boolean modifyDoctor(int doctorId, Doctor newDoctor) throws ClassNotFoundException, SQLException
	{
		return dod.updateDoctor(doctorId,newDoctor);
	}
	public TreeSet<Doctor> listDoctor() throws ClassNotFoundException, SQLException
	{
		return dod.displayAllDoctors();
	}
	public Doctor viewDoctor(int doctorId) throws ClassNotFoundException, SQLException
	{
		return dod.displayDoctor(doctorId);
	}
	
	/**********************************************Staff**********************************************/
	public boolean addStaff(Staff newStaff) throws ClassNotFoundException, SQLException
	{
		return sd.insertStaff(newStaff);	
	}
	public boolean removeStaff(int staffId) throws ClassNotFoundException, SQLException
	{
		return sd.deleteStaff(staffId);
	}
	public boolean modifyStaff(int staffId, Staff newStaff) throws ClassNotFoundException, SQLException
	{
		return sd.updateStaff(staffId,newStaff);
	}
	public TreeSet<Staff> listStaff() throws ClassNotFoundException, SQLException
	{
		return sd.displayAllStaffs();
	}
	public Staff viewStaff(int staffId) throws ClassNotFoundException, SQLException
	{
		return sd.displayStaff(staffId);
	}
	
	/**********************************************Technician**********************************************/
	public boolean addTechnician(Technician newTechnician) throws ClassNotFoundException, SQLException
	{
		return td.insertTechnician(newTechnician);	
	}
	public boolean removeTechnician(int technicianId) throws ClassNotFoundException, SQLException
	{
		return td.deleteTechnician(technicianId);
	}
	public boolean modifyTechnician(int technicianId, Technician newTechnician) throws ClassNotFoundException, SQLException
	{
		return td.updateTechnician(technicianId,newTechnician);
	}
	public TreeSet<Technician> listTechnician() throws ClassNotFoundException, SQLException
	{
		return td.displayAllTechnicians();
	}
	public Technician viewTechnician(int technicianId) throws ClassNotFoundException, SQLException
	{
		return td.displayTechnician(technicianId);
	}
	
	/*******************************************Person**********************************************/
	public boolean removePerson(String personId) throws ClassNotFoundException, SQLException
	{
		return pd.deletePerson(personId);
	}
	public TreeSet<Person> listPerson() throws ClassNotFoundException, SQLException
	{
		return pd.displayAllPersons();
	}
	public Person viewPerson(String personId) throws ClassNotFoundException, SQLException
	{
		return pd.displayPerson(personId);
	}
}
