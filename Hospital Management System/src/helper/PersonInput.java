package helper;
import java.sql.Date;
import java.util.Scanner;

import bean.Person;

public class PersonInput {

	private Person person;
	public Person getPerson() {
		return person;
	}
		
	public boolean input(){
		Scanner sc=new Scanner(System.in);
		person = new Person();
		String id;
		System.out.println("Eneter Id : ");
		id=sc.nextLine();
		String idType;
		System.out.println("Enter Id type : ");
		idType=sc.nextLine();
		String name;
		System.out.println("Enter Name : ");
		name=sc.nextLine();
		String dateOfBirth;
		System.out.println("Enter  Date of Birth : ");
		dateOfBirth=sc.nextLine(); 
	    Date DOB=Date.valueOf(dateOfBirth);
		int age;
		System.out.println("Enter Age : ");
		age=sc.nextInt();
		String gender;
		System.out.println("Enter Gender : ");
		gender=sc.nextLine();
		String address;
		System.out.println("Enter Address : ");
		address=sc.nextLine();
		long phoneNo;
		System.out.println("Enter Phone No. : ");
		phoneNo=sc.nextLong();
		String password;
		System.out.println("Enter Password : ");
		password=sc.nextLine();
		
		person.setPersonId(id);
		person.setPersonIdType(idType);
		person.setPersonName(name);
		person.setPersonDateOfBirth(DOB);
		person.setPersonAge(age);
		person.setPersonGender(gender);
		person.setPersonAddress(address);
		person.setPersonPhoneNo(phoneNo);
		person.setPersonPassword(password);
		return true;
		}
}
