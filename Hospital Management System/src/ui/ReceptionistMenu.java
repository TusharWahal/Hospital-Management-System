package ui;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.TreeSet;

import bean.MedicalReport;
import bean.Reception;
import businessLogic.AdminBusinessLogic;
import helper.AppointmentInput;

public class ReceptionistMenu {
	
	AdminBusinessLogic abl=new AdminBusinessLogic();
	
	public void ReceptionistMainDisplay()
	{
		while(true)
		{
			int choice;
			Scanner sc = new Scanner(System.in);
			System.out.println("\t\t\t\t1.Appointments");
			System.out.println("\t\t\t\t2.Medical Reports");
			System.out.println("\t\t\t\t3.Discharge Summary");
			System.out.println("\t\t\t\t4.Bills");
			System.out.println("\t\t\t\t5.Department");
			System.out.println("\t\t\t\t6.Patient");
			System.out.println("\t\t\t\t\t7.Log Out");
			System.out.print("\n\n\t\t\t\tEnter your choice : ");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:appointmentMenu();
					break;
			case 2:medicalReportMenu();
					break;
			case 3:dischargeSummaryMenu();
			break;
			case 4:billsMenu();
			break;
			case 5:departmentMenu();
			break;
			case 6:addRemovePatientMenu();
			break;
			case 7:return;
			default :break;
			}
		
		}
	}
	
	public void appointmentMenu(){
		while(true)
		{
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("\t\t\t\t1.Add Appointment");
		System.out.println("\t\t\t\t2.Remove Appointment");
		System.out.println("\t\t\t\t3.Modify Appointment");
		System.out.println("\t\t\t\t4.List Appointments");
		System.out.print("\n\n5.Back");
		System.out.print("\t\t\t\tEnter your choice : ");
		choice=sc.nextInt();
		
		switch(choice)
		{
		case 1:addAppointment();break;
		case 2:removeAppintment(); break;
		case 3:System.out.println("Functionality not implemented yet!! SORRY!!");break;//change to list appointments by functionality
		case 4:listAppointment(); break;
		case 5:return;
		default:System.out.println("Invalid Option");
		break;
		}
		}
	}
	public void addAppointment()
	{
		AppointmentInput ai=new AppointmentInput();
		ai.input();
		Reception appointment=new Reception();
		appointment=ai.getRecep();
		
		try {
			abl.addReception(appointment);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Registration Error !! Please Try Again");
			return;
		}

		return;
	}
	public void removeAppintment()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter The Appointment Patient Id That You Want To Delete");
		String reg=sc.nextLine();
		int regNo=Integer.parseInt(reg);
		try {
			boolean removed=abl.removeReception(regNo);
			if(removed==true)
			{
				System.out.println("Appointment deleted");
				return;
			}
			else
			{
				System.out.println("No Such Appointment Exist");
				return;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No Such Apointment Exist");
			return;
		}
		
		
	}
	
	public void listAppointment()
	{
		try {
			TreeSet<Reception> appointmentList= abl.listReception();
			
			for(Reception r:appointmentList)
			{
				System.out.println(r);
			}
			//Option to Select appointment and list appointments for patients
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No Appintments");
			return;
		}
		return;
	}
	
	
	public void medicalReportMenu(){
		
		while(true)
		{
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("\t\t\t\t1.List Medical Reports");
		System.out.println("\t\t\t\t2.Back");
		System.out.print("\n\n\t\t\t\tEnter your choice : ");
		choice=sc.nextInt();
		switch(choice)
		{
		case 1:listMedicalReport();
			break;
		case 2:return;
		default:break;
		}
		}
	}
	public void listMedicalReport()
	{
		try {
			TreeSet<MedicalReport> medicalList= abl.listMedicalReport();
			
			for(MedicalReport m:medicalList)
			{
				System.out.println(m);
			}
			//Option to Select medical report
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No Appintments");
			return;
		}
		return;
		
	}
	
	public void dischargeSummaryMenu(){
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("\t\t\t\t1.Add Discharge Summary");
		System.out.println("\t\t\t\t2.Remove Discharge Summary");
		System.out.println("\t\t\t\t3.Modify Discharge Summary");
		System.out.println("\t\t\t\t4.List Discharge summaries");
		System.out.print("\n\n\t\t\t\tEnter your choice : ");
		choice=sc.nextInt();
	}
	
	public void billsMenu(){
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("\t\t\t\t1.Add Bill");
		System.out.println("\t\t\t\t2.Remove Bill");
		System.out.println("\t\t\t\t3.Modify Bill");
		System.out.println("\t\t\t\t4.List Bills");
		System.out.print("\n\n\t\t\t\tEnter your choice : ");
		choice=sc.nextInt();
	}
	
	public void departmentMenu(){
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("\t\t\t\t1.Add Department");
		System.out.println("\t\t\t\t2.Remove Department");
		System.out.println("\t\t\t\t3.Modify Department");
		System.out.println("\t\t\t\t4.List Departments");
		System.out.print("\n\n\t\t\t\tEnter your choice : ");
		choice=sc.nextInt();
	}
	
	public void addRemovePatientMenu(){
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("\t\t\t\t1.Remove Department");
		System.out.println("\t\t\t\t2.List Departments");
		System.out.print("\n\n\t\t\t\tEnter your choice : ");
		choice=sc.nextInt();
	}
	
	
	
	
	

}
