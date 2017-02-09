package helper;

import java.sql.Date;
import java.util.Scanner;

import bean.MedicalReport;

public class MedicalReportData {

	MedicalReport medicalReport;
	
	Scanner sc=new Scanner(System.in) ;
	public MedicalReport insert()
	{
		medicalReport=new MedicalReport();
		System.out.println("Enter Patient ID:\n");
		medicalReport.setPatientId(Integer.parseInt(sc.nextLine()));
		
		String visitDateString;
		System.out.println("Enter visit Date:\n");
		visitDateString=sc.nextLine();
		Date visitDate = Date.valueOf(visitDateString);
		medicalReport.setVisitDate(visitDate);//Date as Input.//Manage format
		
		System.out.println("Enter Diagnosis:\n");
		medicalReport.setDiagnosis(sc.nextLine());
		
		System.out.println("Enter Investigations:\n");
		medicalReport.setInvestigations(sc.nextLine());
		
		System.out.println("Enter Tests:\n");
		medicalReport.setTests(sc.nextLine());
		
		System.out.println("Enter Recommendations:\n");
		medicalReport.setRecommendations(sc.nextLine());
		
		System.out.println("Enter Technician ID:\n");
		medicalReport.setTechnicianId(Integer.parseInt(sc.nextLine()));
		
		return medicalReport;
	}
}
