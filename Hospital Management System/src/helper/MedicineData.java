package helper;

import java.util.Scanner;

import bean.Medicine;

public class MedicineData {

	public Medicine insert(){
		
		Scanner sc = new Scanner(System.in);
		Medicine medicine = new Medicine();
		
		System.out.println("Enter Serial Number:\n");
		medicine.setsNo(sc.nextInt());
		
		System.out.println("Enter Medicine Name:\n");
		medicine.setMedicineName(sc.next());
		
		System.out.println("Enter Quantity:\n");
		medicine.setQuantity(sc.nextInt());
		
		System.out.println("Enter Dosage:\n");
		medicine.setDosage(sc.next());
		
		System.out.println("Enter Price:\n");
		medicine.setPrice(sc.nextInt());
		
		System.out.println("Enter Bill Number:\n");
		medicine.setBillNo(sc.nextInt());
		
		return medicine;
		
	}
}
