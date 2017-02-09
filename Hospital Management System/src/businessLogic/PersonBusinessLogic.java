package businessLogic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.TreeSet;

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
		
	public TreeSet<Reception> listReception() throws ClassNotFoundException, SQLException, IOException
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
	
	public TreeSet<Medicine> myMedicines(int patientId) throws ClassNotFoundException, SQLException, IOException
	{
		TreeSet<Medicine> medicineList=new TreeSet<Medicine>();
		medicineList=md.displayAllMedicines();
		TreeSet<Medicine> patientMedicines=new TreeSet<Medicine>();
		for(Medicine ml: medicineList){
			if(ml.getPatientId()==patientId){
				patientMedicines.add(ml);
			}
		}
		return patientMedicines;
	}
	
	
	public Person personLogin(String personId, String personPassword) throws ClassNotFoundException, SQLException, IOException
	{
		Person person=new Person();
		person = pd.displayPerson(personId);
		if(person.getPersonId()==null)
		{
			return null;
		}
		else
		{
			person=pd.displayPerson(personId);
			if(person.getPersonPassword().equals(personPassword))
			{
				return person;
			}
			else return null;
		}
	}

}
