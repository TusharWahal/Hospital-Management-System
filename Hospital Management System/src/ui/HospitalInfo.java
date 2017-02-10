package ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;

import bean.Department;
import bean.Doctor;
import bean.Staff;
import bean.Technician;
import businessLogic.DepartmentBusinessLogic;

public class HospitalInfo {
	
	DepartmentBusinessLogic db = new DepartmentBusinessLogic();
	
	public HospitalInfo() throws ClassNotFoundException, SQLException, IOException{
		
		while(true){
			
			ArrayList<Department> departmentList = db.listDepartment();
			for(Department d : departmentList){
				System.out.println(d);
			} 
			
			int choice,departmentId;
			Scanner sc = new Scanner(System.in);
			System.out.println();
			System.out.println("\t\t\t\t1. Doctor");
			System.out.println("\t\t\t\t2. Staff");
			System.out.println("\t\t\t\t3. Technician");
			System.out.println("\t\t\t\t4. Back");
			System.out.print("\n\n\nEnter your choice : ");
			choice=sc.nextInt();
//			System.out.print("Enter departmentId : ");
//			departmentId=sc.nextInt();
//			System.out.println();
			
			switch(choice){
				
				case 1 :System.out.print("Enter departmentId : ");
						departmentId=sc.nextInt();
						System.out.println();
 
						ArrayList<Doctor> doctorList = db.departmentDoctors(departmentId);
						  for(Doctor d : doctorList){
							  System.out.println(d);
						  }
						  System.out.println();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("Thread Error"+e);
				}
						  break;
						  
				case 2 :
					System.out.print("Enter departmentId : ");
					departmentId=sc.nextInt();
					System.out.println();

					ArrayList<Staff> staffList = db.departmentStaffs(departmentId);
				  		  for(Staff s : staffList){
				  			  System.out.println(s);
				  		  }
				  		  System.out.println();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
				  		  break;
				  
				case 3 :
					System.out.print("Enter departmentId : ");
					departmentId=sc.nextInt();
					System.out.println();

					ArrayList<Technician> technicianList = db.departmentTechnicians(departmentId);
				  		  for(Technician t : technicianList){
				  			  System.out.println(t);
				  		  }
				  		  System.out.println();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
				  		  break;
				case 4: return;
				  		  
				default : System.out.println("Invalid choice!!!");
				System.out.println();
						  break;
			}
		}
	}
}
