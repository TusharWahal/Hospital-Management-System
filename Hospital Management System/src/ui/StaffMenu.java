package ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;

import bean.Staff;
import bean.Ward;
import businessLogic.StaffBusinessLogic;
import dao.WardDaoImpl;

public class StaffMenu {
	private int staffId;
	public boolean logInMenu(){
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
		this.staffId=staffId;
		//sc.close();
		try {
			
			st=sb.staffLogin(staffId, staffPassword);
			//System.out.println(st);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(st!=null)
		{
			return true;
		}
		else
		{
			System.out.println("\nInvalid Username/Password!!!");
			return false;
		}
		}
	}
	
	public void homeMenu() {
		
		while(true){
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("\t\t\t\tWelcome to Sapient Hospital");
		System.out.println("\n\n\n\t\t\t\t1.View My Wards");
		System.out.println("\t\t\t\t2.View All Wards");
		System.out.println("\t\t\t\t3.Logout");
				choice=sc.nextInt();
		if(choice==1)
		{
			viewMyWardsMenu();
		}
		else if(choice==2){
			
				viewAllWardsMenu();
		}
		else if(choice==3){
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
	
	public void viewAllWardsMenu ()
	{
		WardDaoImpl wd = new WardDaoImpl();
		ArrayList<Ward> wardArrayList = new ArrayList<Ward>();
		try {
			wardArrayList = wd.displayAllWards();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		for(Ward w:wardArrayList)
		{
			System.out.println(w+"\n");
		}
		
	}
	
	public void viewMyWardsMenu()
	{
		int staffId;
		Scanner sc = new Scanner(System.in);
		StaffBusinessLogic sbl = new StaffBusinessLogic();
		ArrayList<Ward> wardArrayList = new ArrayList<Ward>();
		System.out.println("\nEnter Staff ID:");
		staffId=sc.nextInt();
		//sc.close();
		try {
			wardArrayList = sbl.myWards(staffId);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Ward w:wardArrayList)
		{
			System.out.println(w+"\n");
		}
	}
}
