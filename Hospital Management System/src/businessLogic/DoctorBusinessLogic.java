package businessLogic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Doctor;
import bean.MedicalReport;
import bean.Medicine;
import bean.OT;
import bean.Reception;
import dao.DoctorDaoImpl;
import dao.MedicalReportDaoImpl;
import dao.MedicineDaoimpl;
import dao.ReceptionDao;
import dao.ReceptionDaoImpl;

public class DoctorBusinessLogic {
	
	DoctorDaoImpl dd=new DoctorDaoImpl();
	ReceptionDaoImpl rd=new ReceptionDaoImpl();
	MedicalReportDaoImpl mrd=new MedicalReportDaoImpl(); 
	MedicineDaoimpl md=new MedicineDaoimpl();
	
	public Doctor doctorLogin(int doctorId, String doctorPassword) throws ClassNotFoundException, SQLException, IOException
	{
		//System.out.println("aaaa");
		Doctor doctor=new Doctor();
		if(dd.displayDoctor(doctorId).getDoctorId()==0)
		{
			return null;
		}
		else
		{
			doctor=dd.displayDoctor(doctorId);
			if(doctor.getDoctorPassword().equals(doctorPassword))
			{
				return doctor;
			}
			else 
				return null;
		}
	}
	public ArrayList<Reception> myAppointments(int doctorId) throws ClassNotFoundException, SQLException, IOException
	{
		ArrayList<Reception> receptionList=new ArrayList<Reception>();
		receptionList=rd.displayAllReceptions();
		ArrayList<Reception> doctorAppintments=new ArrayList<Reception>();
		for(Reception rl: receptionList){
			if(rl.getDoctorId()==doctorId){
				doctorAppintments.add(rl);
			}
		}
		return doctorAppintments;
	}
	
	public boolean addMedicalReport(MedicalReport newMedicalReport) throws ClassNotFoundException, SQLException, IOException
	{
		return mrd.insertMedicalReport(newMedicalReport);
		
	}
	public boolean removeMedicalReport(int patientId) throws ClassNotFoundException, SQLException, IOException
	{
	
		return mrd.deleteMedicalReport(patientId);
	}
	public boolean modifyMedicalReport(int patientId,MedicalReport newMedicalReport) throws ClassNotFoundException, SQLException, IOException
	{
	
		return mrd.updateMedicalReport(patientId,newMedicalReport);
	}

	public ArrayList<MedicalReport> listMedicalReport() throws ClassNotFoundException, SQLException, IOException
	{
		return mrd.displayAllMedicalReports();
	}
	public MedicalReport viewMedicalReports(int patientId) throws ClassNotFoundException, SQLException, IOException
	{
		return mrd.displayMedicalReport(patientId);
	}
	
	public boolean addMedicine(Medicine newMedicine) throws ClassNotFoundException, SQLException, IOException
	{
		return md.insertMedicine(newMedicine);
		
	}
	public boolean removeMedicine(int sNo,int patientId) throws ClassNotFoundException, SQLException, IOException
	{
	
		return md.deleteMedicine(sNo,patientId);
	}
	public boolean modifyMedicine(int sNo,Medicine newMedicine) throws ClassNotFoundException, SQLException, IOException
	{
	
		return md.updateMedicine(sNo,newMedicine);
	}

	public ArrayList<Medicine> listMedicine() throws ClassNotFoundException, SQLException, IOException
	{
		return md.displayAllMedicines();
	}
	public Medicine viewMedicine(int sNo,int patientId) throws ClassNotFoundException, SQLException, IOException
	{
		return md.displayMedicine(sNo,patientId);
	}
}
