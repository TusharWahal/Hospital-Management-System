package ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;

import bean.MedicalReport;

import bean.Technician;

import businessLogic.TechnicianBusinessLogic;

public class TechnicianMenu {

	public void logInMenu() {
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
		//sc.close();
		try {
			try {
				t=tb.technicianLogin(technicianId, technicianPassword);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(t!=null)
		{
			try {
				homeMenu();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
			try {
				mr=tb.viewMedicalReports(patientId);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(mr);
		}
		else if(choice==2){
			ArrayList<MedicalReport> mrArrayList = new ArrayList<MedicalReport>();
			TechnicianBusinessLogic tb= new TechnicianBusinessLogic();
			try {
				mrArrayList=tb.listMedicalReport();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(MedicalReport mr:mrArrayList)
			{
				System.out.println(mr);
			}
		}
		else if(choice==3)
		{
			TechnicianBusinessLogic tb= new TechnicianBusinessLogic();
			MedicalReport medicalreport = new MedicalReport();
			int patientId=0;
			System.out.println("Enter patient Id : ");
			patientId=sc.nextInt();
			String tests;
			System.out.println("Enter tests : ");
			tests=sc.next();
			try {
				medicalreport = tb.modifyMedicalReport(patientId, tests);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(choice==4){
			//sc.close();
			return;
		}
		else
		{
			System.out.println("\nInvalid Choice!!!");
		}
		//sc.close();
		}
	}
}
