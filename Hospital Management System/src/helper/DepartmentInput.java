package helper;

import java.sql.Date;
import java.util.Scanner;

import bean.Department;
import bean.Person;

public class DepartmentInput {

		private Department department;
		public Department getDepartment(){
			return department;
		}
		
		public boolean input(){
			Scanner sc=new Scanner(System.in);
			department = new Department();
			int departmentId;
			System.out.println("Eneter Department Id : ");
			departmentId=sc.nextInt();
			String departmentName;
			System.out.println("Enter Department Name : ");
			departmentName=sc.nextLine();
			String departmentLocation;
			System.out.println("Enter Department Location : ");
			departmentLocation=sc.nextLine();
			String description;
			System.out.println("Enter Description : ");
			description=sc.nextLine(); 
			
			department.setDepartmentId(departmentId);
			department.setDepartmentName(departmentName);
			department.setDepartmentLocation(departmentLocation);
			department.setDescription(description);
			return true;
		}
}
