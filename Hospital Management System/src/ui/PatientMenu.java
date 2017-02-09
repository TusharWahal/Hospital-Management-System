package ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;

import bean.Reception;
import businessLogic.PersonBusinessLogic;
import helper.SignUpLogInMenu;

public class PatientMenu {
	
	PersonBusinessLogic pb = new PersonBusinessLogic();
	private String personId;
	
	public PatientMenu(String personId) {
		this.personId=personId;
		while(true){
			int choice;
			Scanner sc = new Scanner(System.in);
			System.out.println("\t\t\t\t1.List Appointments");
			System.out.println("\t\t\t\t2.View Medical Report");
			System.out.println("\t\t\t\t3.View Discharge Summary");
			System.out.println("\t\t\t\t4.View Bills");
			System.out.println("\t\t\t\t5.View Medicines");
			System.out.println("\t\t\t\t\t6.Log Out");
			System.out.print("\n\n\t\t\t\tEnter your choice : ");
			choice=sc.nextInt();
			
			switch(choice){
			
			case 1: try {
					ArrayList<Reception> receptionList = pb.myAppointments(personId);
					//System.out.println(receptionList);
					for(Reception r : receptionList){
						System.out.println(r);
					}
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				/***********************View Appointment*******************************/
					break;
			
			case 2: int patientId;
					System.out.print("Enter Patient Id : ");
					patientId=sc.nextInt();
				try {
					System.out.println(pb.viewMedicalReport(patientId));
				} catch (ClassNotFoundException| IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
					break;
				
			case 3: int serialNo;
					System.out.println("Enter serial No of discharge summary : ");
					serialNo=sc.nextInt();
				try {
					System.out.println(pb.viewDischargeSummary(serialNo));
				} catch (ClassNotFoundException| IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
			
			case 4: int billNo;
					System.out.println("Enter bill No :");
					billNo=sc.nextInt();
				try {
					System.out.println(pb.viewBill(billNo));
				} catch (ClassNotFoundException| IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
					
			case 5: int pId;
					System.out.println("Enter Patient Id :");
					pId=sc.nextInt();
				try {
					System.out.println(pb.myMedicines(pId));
				} catch (ClassNotFoundException| IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
			
			case 6: return;
					
			
			default: System.out.println("Invalid choice!!!");
					break;
			}
		}
	}
}

