package ui;

import java.sql.SQLException;
import java.util.Scanner;

import helper.SignUpLogInMenu;

public class MyMenu {
	
	public MyMenu() throws ClassNotFoundException, SQLException{
		while(true){
		
			int choice;
			Scanner sc = new Scanner(System.in);
			System.out.println("\t\t\t\tWelcome to Sapient Hospital");
			System.out.println("\n\n\n\t\t\t\t1.Patient");
			System.out.println("\t\t\t\t2.Receptionist");
			System.out.println("\t\t\t\t3.Hospital Employee");
			System.out.println("\t\t\t\t4.Hospital Information");
			System.out.println("\n\n\nEnter your choice : ");
			choice=sc.nextInt();
			switch(choice){
		
				case 1: SignUpLogInMenu sulim = new SignUpLogInMenu();
						break;
				
//				case 2: ReceptionMenu receptionMenu = new ReceptionMenu();
//						break;
						
//				case 3: HospitalEmployeeMenu hospitalEmployeeMenu = new HospitalEmployeeMenu();
//						break;
						
				case 4: HospitalInfo hospitalinfo = new HospitalInfo();
						break;
				
				default: System.out.println("Invalid choice!!!");
						break;
			}
		}
	}
	
}