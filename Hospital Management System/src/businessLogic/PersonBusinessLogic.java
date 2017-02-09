package businessLogic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Bill;
import bean.DischargeSummary;
import bean.Doctor;
import bean.MedicalReport;
import bean.Medicine;
import bean.Person;
import bean.Reception;
import dao.BillDaoImpl;
import dao.DischargeSummaryDaoImpl;
import dao.MedicalReportDaoImpl;
import dao.MedicineDaoimpl;
import dao.PersonDaoImpl;
import dao.ReceptionDaoImpl;

public class PersonBusinessLogic {
	
	PersonDaoImpl pd= new PersonDaoImpl();
	BillDaoImpl bd= new BillDaoImpl();
	DischargeSummaryDaoImpl dsd = new DischargeSummaryDaoImpl();
	MedicalReportDaoImpl mrd = new MedicalReportDaoImpl();
	ReceptionDaoImpl rd = new ReceptionDaoImpl();
	MedicineDaoimpl md = new MedicineDaoimpl();
		
	public ArrayList<Reception> listReception() throws ClassNotFoundException, SQLException, IOException
	{
		return rd.displayAllReceptions();
	}
	
	public MedicalReport viewMedicalReport(int patientId) throws ClassNotFoundException, SQLException, IOException
	{
		return mrd.displayMedicalReport(patientId);
	}
	
	public Bill viewBill(int billNo) throws ClassNotFoundException, SQLException, IOException
	{
		return bd.displayBill(billNo);
	}
	
	public DischargeSummary viewDischargeSummary(int patientId) throws ClassNotFoundException, SQLException, IOException
	{
		return dsd.displayDischargeSummary(patientId);
	}
	
//	public boolean addPerson(Person newPerson) throws ClassNotFoundException, SQLException
//	{
//		return pd.insertPerson(newPerson);	
//	}
//	public boolean modifyPerson(String personId, Person newPerson) throws ClassNotFoundException, SQLException
//	{
//		return pd.updatePerson(personId,newPerson);
//	}
	
	public ArrayList<Medicine> myMedicines(int patientId) throws ClassNotFoundException, SQLException, IOException
	{
		ArrayList<Medicine> medicineList=new ArrayList<Medicine>();
		medicineList=md.displayAllMedicines();
		ArrayList<Medicine> patientMedicines=new ArrayList<Medicine>();
		for(Medicine ml: medicineList){
			if(ml.getPatientId()==patientId){
				patientMedicines.add(ml);
			}
		}
		return patientMedicines;
	}
	public boolean personSignUp(Person person) throws ClassNotFoundException, SQLException, IOException
	{
		return pd.insertPerson(person);
	}
	
	
	public Person personLogin(String personId, String personPassword) throws ClassNotFoundException, SQLException, IOException
	{
		Person person=new Person();
		person = pd.displayPerson(personId);
		//System.out.println(person);
		if(person.getPersonId()==null)
		{
			return null;
		}
		else
		{
			
			if(person.getPersonPassword().equals(personPassword))
			{
				return person;
			}
			else return null;
		}
	}
	public ArrayList<Reception> myAppointments(String personId) throws ClassNotFoundException, SQLException, IOException
	{
		ArrayList<Reception> receptionList=new ArrayList<Reception>();
		receptionList=rd.displayAllReceptions();
		//System.out.println(receptionList);
		ArrayList<Reception> doctorAppintments=new ArrayList<Reception>();
		for(Reception rl: receptionList){
			if(rl.getPersonId().equals(personId)){
				doctorAppintments.add(rl);
			}
		}
		return doctorAppintments;
	}

}
