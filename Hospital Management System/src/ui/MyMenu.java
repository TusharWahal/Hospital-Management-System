package ui;

import java.util.Scanner;

public class MyMenu {

	public void homeMenu(){
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("\t\t\t\tWelcome to Sapient Hospital");
		System.out.println("\n\n\n\t\t\t\t1.Patient");
		System.out.println("\t\t\t\t2.Receptionist");
		System.out.println("\t\t\t\t3.Hospital Employee");
		System.out.println("\t\t\t\t4.Hospital Information");
		System.out.println("\n\n\nEnter your choice : ");
		choice=sc.nextInt();
		
		if(choice==1){
			signUpLogInMenu();
		}
		else if(choice==2){
			logInMenu();
		}
		else if(choice==3){
			hospitalEmployeeMenu();
		}
		else{
			System.out.println("Invalid choice!!!");
		}
	}
	
	public void signUpLogInMenu(){
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("\t\t\t\tWelcome to Sapient Hospital");
		System.out.println("\n\n0.Back");
		System.out.println("\n\n\t\t\t\t1.Sign Up");
		System.out.println("\t\t\t\t2.Log In");
		System.out.println("\n\n\nEnter your choice : ");
		choice=sc.nextInt();
		
		if(choice==1){
			//To do
		}
		else if(choice==2){
			logInMenu();
		}
	}
	
	public void logInMenu(){
		String userName;
		String password;
		Scanner sc = new Scanner(System.in);
		System.out.println("\t\t\t\tWelcome to Sapient Hospital");
		System.out.print("\n\n\n\t\t\t\tEnter User Name : ");
		userName=sc.next();
		System.out.print("\t\t\t\tEnter Password : ");
		password=sc.next();
	}
	
	public void hospitalEmployeeMenu(){
		System.out.println("\t\t\t\tDoctor");
		System.out.println("\t\t\t\tStaff");
		System.out.println("\t\t\t\tTechnician");
	}
}