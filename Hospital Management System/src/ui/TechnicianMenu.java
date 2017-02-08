package ui;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.TreeSet;

import bean.MedicalReport;

import bean.Technician;

import businessLogic.TechnicianBusinessLogic;

public class TechnicianMenu {

	public void logInMenu() throws ClassNotFoundException,SQLException{
		int technicianId;
		String technicianPassword;
		Scanner sc = new Scanner(System.in);
		TechnicianBusinessLogic tb = new TechnicianBusinessLogic();
		Technician t=new Technician();
		while(true){
		System.out.println("\t\t\t\tWelcome to Sapient Hospital");
		System.out.print("\n\n\n\t\t\t\tEnter User Name : ");
		technicianId=sc.nextInt();
		System.out.print("\t\t\t\tEnter Password : ");
		technicianPassword=sc.next();
		sc.close();
		t=tb.technicianLogin(technicianId, technicianPassword);
		if(t!=null)
		{
			homeMenu();
		}
		else
		{
			System.out.println("\nStaff not found!!!");
		}
		}
	}
	public void homeMenu() throws ClassNotFoundException,SQLException{
		
		while(true){
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("\t\t\t\tWelcome to Sapient Hospital");
		System.out.println("\n\n\n\t\t\t\t1.View Medical Report");
		System.out.println("\t\t\t\t2. View All Medical Reports");
		System.out.println("\t\t\t\t3. Modify");
		System.out.println("\t\t\t\t4.Logout");
				choice=sc.nextInt();
		
		if(choice==1){
			int patientId=0;
			TechnicianBusinessLogic tb= new TechnicianBusinessLogic();
			MedicalReport mr=new MedicalReport();
			mr=tb.viewMedicalReports(patientId);
			System.out.println(mr);
		}
		else if(choice==2){
			TreeSet<MedicalReport> mrtreeset = new TreeSet<MedicalReport>();
			TechnicianBusinessLogic tb= new TechnicianBusinessLogic();
			mrtreeset=tb.listMedicalReport();
			for(MedicalReport mr:mrtreeset)
			{
				System.out.println(mr);
			}
		}
		else if(choice==3)
		{
			
		}
		else if(choice==4){
			sc.close();
			return;
		}
		else
		{
			System.out.println("\nInvalid Choice!!!");
		}
		sc.close();
		}
	}
}
