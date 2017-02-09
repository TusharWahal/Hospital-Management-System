package ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import bean.Doctor;
import bean.Staff;
import businessLogic.DoctorBusinessLogic;
import businessLogic.StaffBusinessLogic;

public class HospitalEmployeeMenu {

		public HospitalEmployeeMenu(){
			
			Scanner sc=new Scanner(System.in);
			System.out.println("1.Doctor");
			System.out.println("2.Staff");
			System.out.println("3.Back");
			
			int choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:doctorLogin();
				break;
			case 2:staffLogin();
				break;
			case 3:return;
			default:System.out.println("Invalid Option");break;
			
			}
			
			
		}
		public void doctorLogin()
		{
			int doctorId;
			String doctorPassword;
			Scanner sc = new Scanner(System.in);
			DoctorBusinessLogic db = new DoctorBusinessLogic();
			Doctor doc=new Doctor();
			while(true){
			System.out.println("\t\t\t\tWelcome to Sapient Hospital");
			System.out.print("\n\n\n\t\t\t\tEnter User Name : ");
			doctorId=sc.nextInt();
			System.out.print("\t\t\t\tEnter Password : ");
			doctorPassword=sc.next();
			boolean flag=false;
//			try {
//				db.doctorLogin(doctorId, doctorPassword);
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			//sc.close();
			try {
				if(!db.doctorLogin(doctorId, doctorPassword).equals(null))
				{
				doc=db.doctorLogin(doctorId, doctorPassword);
				flag=true;
				}
				else flag=false;
			} catch (ClassNotFoundException | SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(flag==true)
			{
				DoctorMenu doctorMenu = new DoctorMenu(doc);
				doctorMenu.displayMenu();
				return;
			}
			else
			{
				System.out.println("\nInvalid Username/Password!!!");
				return;
			}
			}			
		}
		public void staffLogin()
		{
			StaffMenu sm=new StaffMenu();
			boolean flag=sm.logInMenu();
			if(flag==true)
			{
				sm.homeMenu();
				return;
			}
			else return;
		}
		
}
