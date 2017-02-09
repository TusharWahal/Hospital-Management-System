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
			System.out.println("\t\t\t\tDoctor");
			System.out.println("\t\t\t\tStaff");
			System.out.println("\t\t\t\tTechnician");
			System.out.print("\n\n\nEnter your choice : ");
			choice=sc.nextInt();
			System.out.print("Enter departmentId : ");
			departmentId=sc.nextInt();
			System.out.println();
			
			switch(choice){
				
				case 1 :  ArrayList<Doctor> doctorList = db.departmentDoctors(departmentId);
						  for(Doctor d : doctorList){
							  System.out.println(d);
						  }
						  break;
						  
				case 2 :  ArrayList<Staff> staffList = db.departmentStaffs(departmentId);
				  		  for(Staff s : staffList){
				  			  System.out.println(s);
				  		  }
				  		  break;
				  
				case 3 :  ArrayList<Technician> technicianList = db.departmentTechnicians(departmentId);
				  		  for(Technician t : technicianList){
				  			  System.out.println(t);
				  		  }
				  		  break;
				  		  
				default : System.out.println("Invalid choice!!!");
						  break;
			}
		}
	}
}
