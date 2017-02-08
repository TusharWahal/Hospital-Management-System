package ui;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.TreeSet;

import bean.Staff;
import bean.Ward;
import businessLogic.StaffBusinessLogic;
import dao.WardDaoImpl;

public class StaffMenu {
	public void logInMenu() throws ClassNotFoundException,SQLException{
		int staffId;
		String staffPassword;
		Scanner sc = new Scanner(System.in);
		StaffBusinessLogic sb = new StaffBusinessLogic();
		Staff st=new Staff();
		while(true){
		System.out.println("\t\t\t\tWelcome to Sapient Hospital");
		System.out.print("\n\n\n\t\t\t\tEnter User Name : ");
		staffId=sc.nextInt();
		System.out.print("\t\t\t\tEnter Password : ");
		staffPassword=sc.next();
		sc.close();
		st=sb.staffLogin(staffId, staffPassword);
		if(st!=null)
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
		System.out.println("\n\n\n\t\t\t\t1.View My Wards");
		System.out.println("\t\t\t\t2.View All Wards");
		System.out.println("\t\t\t\t3.Logout");
				choice=sc.nextInt();
		
		if(choice==1){
			viewMyWardsMenu();
		}
		else if(choice==2){
			viewAllWardsMenu();
		}
		else if(choice==3){
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
	
	public void viewAllWardsMenu () throws ClassNotFoundException,SQLException
	{
		WardDaoImpl wd = new WardDaoImpl();
		TreeSet<Ward> wardtreeset = new TreeSet<Ward>();
		wardtreeset = wd.displayAllWards();
		for(Ward w:wardtreeset)
		{
			System.out.println(w+"\n");
		}
		
	}
	
	public void viewMyWardsMenu() throws ClassNotFoundException,SQLException
	{
		int staffId;
		Scanner sc = new Scanner(System.in);
		StaffBusinessLogic sbl = new StaffBusinessLogic();
		TreeSet<Ward> wardtreeset = new TreeSet<Ward>();
		System.out.println("\nEnter Staff ID:");
		staffId=sc.nextInt();
		sc.close();
		wardtreeset = sbl.myWards(staffId);
		for(Ward w:wardtreeset)
		{
			System.out.println(w+"\n");
		}
	}
}
