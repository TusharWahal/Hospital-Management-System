package helper;

import java.sql.SQLException;
import java.util.Scanner;

import bean.Person;
import businessLogic.PersonBusinessLogic;
import ui.PatientMenu;

public class SignUpLogInMenu {
	
	PersonBusinessLogic pb = new PersonBusinessLogic();

	public SignUpLogInMenu(){
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("\t\t\t\tWelcome to Sapient Hospital");
		System.out.println("\n\n0.Back");
		System.out.println("\n\n\t\t\t\t1.Sign Up");
		System.out.println("\t\t\t\t2.Log In");
		System.out.println("\n\n\nEnter your choice : ");
		choice=sc.nextInt();
		
		switch(choice){
		
		case 0 : return;
				 
		case 1 : PersonInput pi = new PersonInput();
				 pi.input();
				 Person p = pi.getPerson();
				 System.out.println(p);						//View your own details
				 SignUpLogInMenu sulim = new SignUpLogInMenu();
				 break;
			
		case 2 :  String personId,personPassword;
				  System.out.print("Enter personId : ");
				  personId = sc.next();
				  System.out.println();
				  System.out.print("Enter password : ");
				  personPassword = sc.next();
				  try {
					  Person person=pb.personLogin(personId, personPassword);
				  } catch (ClassNotFoundException e) {
					  // TODO Auto-generated catch block
					  e.printStackTrace();
				  } catch (SQLException e) {
					  // TODO Auto-generated catch block
					  e.printStackTrace();
				  }
				  PatientMenu pm = new PatientMenu();
				  break;
				  
		 default : System.out.println("Invalid choice!!!");
		 		  break;
		}
	}
}
