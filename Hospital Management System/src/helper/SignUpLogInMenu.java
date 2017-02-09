package helper;

import java.io.IOException;
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
				 System.out.println(p);
			try {
				if(pb.personSignUp(p))
				 {
					 System.out.println("Succesfull Registration");
				 }
				else
				{
					System.out.println("Registration Failed");
				}
			} catch (ClassNotFoundException | SQLException | IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("Sign Up Failed!! Choose another usernaem");
			}
						 
				 //View your own details
				 SignUpLogInMenu sulim = new SignUpLogInMenu();
				 break;
			
		case 2 :  String personId,personPassword;
				  System.out.print("Enter personId : ");
				  personId = sc.next();
				  System.out.println();
				  System.out.print("Enter password : ");
				  personPassword = sc.next();
				  boolean flag=false;
				  try {
					  if(pb.personLogin(personId, personPassword).equals(null))
					  {
						  flag=false;
					  }
					  else{ 
						  Person person=pb.personLogin(personId, personPassword);
						  System.out.println("Welcome  "+person.getPersonName().toUpperCase());
						  flag=true;
						  }
				  } catch (ClassNotFoundException | IOException e) {
					  // TODO Auto-generated catch block
					  System.out.println(e);
				  } catch (SQLException e) {
					  // TODO Auto-generated catch block
					  System.out.println(e);
				  }
				  if(flag==true)
				  {
				  PatientMenu pm = new PatientMenu();
				  break;
				  }
				  else{
					  System.out.println("Wrong Username/Password");
					  break;
				  }
		 default : System.out.println("Invalid choice!!!");
		 		  break;
		}
	}
}
