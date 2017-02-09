package ui;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.TreeSet;

import bean.Bill;
import bean.DischargeSummary;
import bean.MedicalReport;
import bean.Reception;
import businessLogic.AdminBusinessLogic;
import helper.AppointmentInput;
import helper.BillData;
import helper.DischargeSummaryData;

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
			//System.out.println("\t\t\t\t6.Patient");
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
			//case 6:addRemovePatientMenu();
			//break;
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
		
		
		while(true)
			{
			int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("\t\t\t\t1.Add Discharge Summary");
		System.out.println("\t\t\t\t2.Remove Discharge Summary");
		System.out.println("\t\t\t\t3.View Specific Discharge Summary");
		System.out.println("\t\t\t\t4.List Discharge summaries");
		System.out.print("\n\n\t\t\t\tEnter your choice : ");
		choice=sc.nextInt();
			switch(choice)
			{
			case 1:addDischargeSummary();
				break;
			case 2:removeDischargeSummary();
				break;
			case 3://display specific list
				break;
			case 4:listDischargeSummary();
				break;
			case 5:return;
			default: break;
				
			}
			}
	}

public void viewSpecificDischargeSummary()
{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Serial Number");
	String sn=sc.nextLine();
	int SerialNo=Integer.parseInt(sn);
	
	try {
		System.out.println(abl.viewDischargeSummary(SerialNo));
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("Discharge Summary Does Not Exist");
		return;
	}
	
	return;
	
	}


public void addDischargeSummary()
	{
	
	DischargeSummaryData dsd=new DischargeSummaryData();
	DischargeSummary discharge=new DischargeSummary();
	discharge=dsd.getDs();
		
		try {
			abl.addDischargeSummary(discharge);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Not a Unique Serial No Please select Other Serial Number and try again");
		}
		return;
		
	}

public void removeDischargeSummary(){
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter The Serial No For Discharge Summary That You Want To Delete");
	String sn=sc.nextLine();
	int serialNo=Integer.parseInt(sn);
	try {
		boolean removed=abl.removeDischargeSummary(serialNo);
		if(removed==true)
		{
			System.out.println("Discharge Summary deleted");
			return;
		}
		else
		{
			System.out.println("No Such Discharge Summary Exist");
			return;
		}
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("No Such Discharge Summary Exist");
		return;
	}
	
	
}

public void listDischargeSummary()
{
	
	try {
		TreeSet<DischargeSummary> dsList= abl.listDischargeSummary();
		
		for(DischargeSummary d:dsList)
		{
			System.out.println(d);
		}
		//Option to Select medical report
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("No Dischare Summary");
		return;
	}
	return;
	
}




	
	public void billsMenu(){
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("\t\t\t\t1.Add Bill");
		//System.out.println("\t\t\t\t2.Remove Bill");
		//System.out.println("\t\t\t\t3.Modify Bill");
		System.out.println("\t\t\t\t2.List Bills");
		System.out.println("3.Back");

		System.out.print("\n\n\t\t\t\tEnter your choice : ");
		choice=sc.nextInt();
		
		switch(choice)
		{
		case 1:addBill();
			break;
		case 2:removeBill();
			break;
	//	case 4:System.out.println("Functionality Under Construction!! Sorry!!"); 
		//	break;
		//case 5:System.out.println("Functionality Under Construction!! Sorry!!");
			//break;
		case 3:return;
		default:break;
		}
	}
	public void addBill()
	{
		BillData bd=new BillData();
		
		bd.input();
		Bill bill=bd.getBill();
		try {
			abl.addBill(bill);
			
			float totalPrice=abl.calculateBill(bill.getBillNo());
			
			System.out.println("Your Total Price ="+totalPrice);
			
			return;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(" Invalid Bill No Pleas Try Again");
			return;
		}
		
		
	}
	public void removeBill()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Bill Number That You Want To Delete");
		int billNumber=Integer.parseInt(sc.nextLine());
		try {
			abl.removeBill(billNumber);
			return;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No Such Bill Exist");
			return;
		}
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
