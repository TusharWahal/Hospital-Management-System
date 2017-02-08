package businessLogic;

import java.sql.SQLException;

import bean.Bill;
import bean.DischargeSummary;
import bean.MedicalReport;
import bean.Person;
import dao.BillDaoImpl;
import dao.DischargeSummaryDaoImpl;
import dao.MedicalReportDaoImpl;
import dao.PersonDaoImpl;

public class PersonBusinessLogic {
	
	PersonDaoImpl pd= new PersonDaoImpl();
	BillDaoImpl bd= new BillDaoImpl();
	DischargeSummaryDaoImpl dsd = new DischargeSummaryDaoImpl();
	MedicalReportDaoImpl mrd = new MedicalReportDaoImpl();
	
	public MedicalReport viewMedicalReport(int patientId) throws ClassNotFoundException, SQLException
	{
		return mrd.displayMedicalReport(patientId);
	}
	
	public Bill viewBill(int patientId) throws ClassNotFoundException, SQLException
	{
		return bd.displayBill(patientId);
	}
	
	public DischargeSummary viewDischargeSummary(int patientId) throws ClassNotFoundException, SQLException
	{
		return dsd.displayDischargeSummary(patientId);
	}
	
	public Person personLogin(String personId, String personPassword) throws ClassNotFoundException, SQLException
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
