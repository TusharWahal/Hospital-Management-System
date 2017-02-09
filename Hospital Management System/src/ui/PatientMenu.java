package ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;

import bean.Medicine;
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
					if(receptionList.size()==0)
					{
						System.out.println("No Appointments");
					}
					else 
					{
					for(Reception r : receptionList){
						System.out.println(r);
					}
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
					if(pb.viewMedicalReport(patientId).getPatientId()!=0)
						System.out.println(pb.viewMedicalReport(patientId));
					else
						System.out.println("No Medical Report");
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
					if(pb.viewDischargeSummary(serialNo).getPatientId()!=0)
						System.out.println(pb.viewDischargeSummary(serialNo));
					else
						System.out.println("No Discharge Summary");
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
					if(pb.viewBill(billNo).getPatientId()==0)
					{
						System.out.println("No Bills");
					}
					else
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
					ArrayList<Medicine> medicineList=new ArrayList<Medicine>();
					medicineList=pb.myMedicines(pId);
					if(medicineList.size()==0)
					{
						System.out.println("No Medicines");
					}
					else 
					{
					System.out.println("Your Medicines");
					for(Medicine m:medicineList)
					{
					System.out.println(m);
					}
					}
				
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

