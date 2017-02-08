package helper;

import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;


import bean.Reception;

public class AppointmentInput {

	private Reception recep;
	public Reception getRecep() {
		return recep;
	}
	public boolean input()
	{	
		Scanner sc=new Scanner(System.in);
		recep=new Reception();
		String personId;
		System.out.println("Enter Person ID");
		personId=(sc.nextLine());
		System.out.println("Enter Doctor ID ");
		int doctorId=(Integer.parseInt(sc.nextLine()));
		System.out.println("Enter Purpose For Appointment");
		String purpose=sc.nextLine();
		System.out.println("Enter Appointment Registration Fee");
		int fee=Integer.parseInt(sc.nextLine());
		
		Date currentDate=new Date(Calendar.getInstance().getTime().getTime());
		
	
		int regNo= Math.abs((int) currentDate.getTime());
		
		//check values for validation
		recep.setPersonId(personId);
		recep.setDoctorId(doctorId);
		recep.setPayment(fee);
		recep.setRegNo(regNo);
		recep.setAppointmentDate(currentDate);
		recep.setPurpose(purpose);
		
		
		return true;
		
	}
}

