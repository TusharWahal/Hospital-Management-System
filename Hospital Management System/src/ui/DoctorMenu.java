package ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import bean.Doctor;
import bean.MedicalReport;
import bean.Medicine;
import businessLogic.DoctorBusinessLogic;
import helper.MedicalReportData;
import helper.MedicineData;

public class DoctorMenu {

	private Doctor doctor=new Doctor();
	private DoctorBusinessLogic dbl= new DoctorBusinessLogic();
	private MedicalReportData mr = new MedicalReportData();
	private MedicineData md = new MedicineData();
	private MedicalReport medicalReport = new MedicalReport();
	private Medicine medicine = new Medicine();
	
	private static final String MENU_OPTIONS ="\t\t\t\t1.View Appointments\n" +
												"\t\t\t\t2.Medical Report\n" +
												"\t\t\t\t\t3.Log Out\n";

	private static final String MEDICAL_REPORT_OPTIONS ="\t\t\t\t1.Add Medical Report\n" +
			"\t\t\t\t2.Delete Medical Report\n" +
			"\t\t\t\t\t3.Update Medical Report\n" +
			"\t\t\t\t\t4.View Specific Medical Report\n" +
			"\t\t\t\t\t5.View All Medical Report\n" +
			"\t\t\t\t\t6.Exit\n";
	
	private static final String ADDING_MEDICAL_REPORT_FAILED_MSG =
			"Could not add medical report\n";
	
	private static final String APPOINTMENTS_DISPLAY_FAILED_MSG =
			"Could not display your appointments\n";
	
	private static final String ERROR_DESC_PREFIX_MSG = "Error\n";
	
	public DoctorMenu(Doctor doctor) {
		this.doctor=doctor;
	}
	
	
	public void displayMenu(){
		System.out.println(MENU_OPTIONS);
		choice();
		
	}
	
	public boolean choice() {
		Scanner scanner = new Scanner(System.in);
		
		int choice=scanner.nextInt();
		
		switch(choice){
		case 1:
			try {
				
				dbl.myAppointments(doctor.getDoctorId());
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println(APPOINTMENTS_DISPLAY_FAILED_MSG +
						ERROR_DESC_PREFIX_MSG + ": " + e);
				e.printStackTrace();
			} 
			break;
		case 2:
			
				System.out.println(MEDICAL_REPORT_OPTIONS);
				medicalChoice();
			
			break;
		}
		return true;
	}
	public boolean medicalChoice() {
		Scanner scanner = new Scanner(System.in);
		
		int choice=scanner.nextInt();
		
		switch(choice){
		case 1:
			try {
				
				medicalReport=mr.insert();
				medicalReport.setDoctorId(doctor.getDoctorId());
				dbl.addMedicalReport(medicalReport);
				
				System.out.println("Enter Medicine:\n");
				medicine=md.insert();
				medicine.setPatientId(medicalReport.getPatientId());
				dbl.addMedicine(medicine);
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println(ADDING_MEDICAL_REPORT_FAILED_MSG +
						ERROR_DESC_PREFIX_MSG + ": " + e);
				e.printStackTrace();
			} 
			break;
		case 2:
			try {
				System.out.println("Enter Patient ID to remove Medical Report:\n");
				int patientId= scanner.nextInt();
				dbl.removeMedicalReport(patientId);
				dbl.removeMedicine(medicine.getsNo(),patientId);
				
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println(APPOINTMENTS_DISPLAY_FAILED_MSG +
						ERROR_DESC_PREFIX_MSG + ": " + e);
				e.printStackTrace();
			} 
			break;
			
		case 3:
			try {
				medicalReport=mr.insert();
				medicalReport.setDoctorId(doctor.getDoctorId());
				
				medicine=md.insert();
				medicine.setPatientId(medicalReport.getPatientId());
				
				dbl.modifyMedicalReport(medicalReport.getPatientId(), medicalReport);
				dbl.modifyMedicine(medicine.getsNo(), medicine);
				
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println(APPOINTMENTS_DISPLAY_FAILED_MSG +
						ERROR_DESC_PREFIX_MSG + ": " + e);
				e.printStackTrace();
			} 
			break;
			
		case 4:
			try {
				System.out.println("Enter Patient ID to view Medical Report:\n");
				int patientId= scanner.nextInt();
				dbl.viewMedicalReports(patientId);
				
				System.out.println("Enter Serial Number to view Medicine:\n");
				int sNo= scanner.nextInt();
				dbl.viewMedicine(sNo,patientId);
				
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println(APPOINTMENTS_DISPLAY_FAILED_MSG +
						ERROR_DESC_PREFIX_MSG + ": " + e);
				e.printStackTrace();
			} 
			break;
			
		case 5:
			try {
				dbl.listMedicalReport();
				dbl.listMedicine();
				
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println(APPOINTMENTS_DISPLAY_FAILED_MSG +
						ERROR_DESC_PREFIX_MSG + ": " + e);
				e.printStackTrace();
			} 
			break;
			
		case 6:
			return false;
			
		default:
			System.out.println("Enter correct choice!\n");
		}
		return true;
	}
}
