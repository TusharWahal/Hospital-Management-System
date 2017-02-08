package helper;

import java.sql.Date;
import java.util.Scanner;

import bean.MedicalReport;

public class MedicalReportData {

	MedicalReport medicalReport;
	
	Scanner sc=new Scanner(System.in) ;
	public MedicalReport insert()
	{
		System.out.println("Enter Patient ID:\n");
		medicalReport.setPatientId(sc.nextInt());
		
		System.out.println("Enter visit Date:\n");
		medicalReport.setVisitDate(Date.valueOf(sc.next()));//Date as Input.//Manage format
		
		System.out.println("Enter Diagnosis:\n");
		medicalReport.setDiagnosis(sc.next());
		
		System.out.println("Enter Investigations:\n");
		medicalReport.setInvestigations(sc.next());
		
		System.out.println("Enter Tests:\n");
		medicalReport.setTests(sc.next());
		
		System.out.println("Enter Recommendations:\n");
		medicalReport.setRecommendations(sc.next());
		
		System.out.println("Enter Technician ID:\n");
		medicalReport.setTechnicianId(sc.nextInt());
		
		return medicalReport;
	}
}
