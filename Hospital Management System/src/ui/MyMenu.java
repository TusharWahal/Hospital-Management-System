package ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import helper.SignUpLogInMenu;

public class MyMenu {
	
	public MyMenu() throws ClassNotFoundException, SQLException, IOException{
		while(true){
			

		
			int choice; 
			Scanner sc = new Scanner(System.in);
			System.out.println(" \t\t\t\t\t\t\t  _______");
			System.out.println("\t\t\t\t\t\t\t |       |");
			System.out.println("\t\t\t\t\t\t\t |       |");
			System.out.println("\t\t\t\t\t\t\t |_______|");
			System.out.println("\t\t\t\t\t\t _______//");
			System.out.println("\t\t\t\t\t\t|       |");
			System.out.println("\t\t\t\t\t\t|       |");
			System.out.println("\t\t\t\t\t\t|_______|");
			System.out.println("\t\t\t\t\t\t\t\\\\_______");
			System.out.println("\t\t\t\t\t\t\t |       |");
			System.out.println("\t\t\t\t\t\t\t |       |");
			System.out.println("\t\t\t\t\t\t\t |_______|");
			System.out.println("\t\t\t\t\t\t _______//");
			System.out.println("\t\t\t\t\t\t|       |");
			System.out.println("\t\t\t\t\t\t|       |");
			System.out.println("\t\t\t\t\t\t|_______|");
			System.out.println("\n\t\t\t\t\t\tSAPIENT HOSPITAL");
			System.out.println("\n\n\t\t\t\tWelcome to Sapient Hospital");
			System.out.println("\n\n\n\t\t\t\t1.Patient");
			System.out.println("\t\t\t\t2.Receptionist");
			System.out.println("\t\t\t\t3.Hospital Employee");
			System.out.println("\t\t\t\t4.Hospital Information");
			System.out.print("\n\n\nEnter your choice : ");
			choice=sc.nextInt();
			switch(choice){
		
				case 1: SignUpLogInMenu sulim = new SignUpLogInMenu();
						break;
				
				case 2: ReceptionistMenu receptionMenu = new ReceptionistMenu();
				
						
						receptionMenu.receptionistMainDisplay();
						break;
						
				case 3://System.out.println("Under Construction"); 
					HospitalEmployeeMenu hospitalEmployeeMenu = new HospitalEmployeeMenu();
						break;
						
				case 4: HospitalInfo hospitalinfo = new HospitalInfo();
						break;
				
				default: System.out.println("Invalid choice!!!");
						break;
			}
		}
	}
	
}