package helper;
import java.sql.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

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
	    String strAge;
		int age;
		while(true){
			System.out.println("Enter Age : ");
			strAge=sc.next();
			if(Pattern.matches("[0-9]{2}",strAge)){
				age=Integer.parseInt(strAge);
				break;
			}
			else{
				System.out.println("The age contains characters!!!");
				}
		}
		String gender;
		while(true){
			System.out.println("Enter Gender : ");
			gender=sc.nextLine();
			if((gender.toLowerCase()).equals("male")||(gender.toLowerCase()).equals("female")){
				break;
			}
			else{
				System.out.println("The gender field can be male or female");
			}
		}
		
		String address;
		System.out.println("Enter Address : ");
		address=sc.nextLine();
		String strPhoneNo;
		long phoneNo;
		while(true){
			System.out.println("Enter Phone No. : ");
			strPhoneNo=sc.next();
			if(Pattern.matches("[0-9]{10}",strPhoneNo)){
				phoneNo=Long.parseLong(strPhoneNo);
				break;
			}
			else{
					System.out.println("The phone no contains characters!!!");
				}
		}
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
