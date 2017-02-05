package bean;

import java.sql.Date;

public class Person {
	String personId;
	String personIdType;
	String personName;
	Date personDateOfBirth;
	int personAge;
	String personGender;
	String personAddress;
	int personPhoneNo;
	String personPassword;
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getPersonIdType() {
		return personIdType;
	}
	public void setPersonIdType(String personIdType) {
		this.personIdType = personIdType;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public Date getPersonDateOfBirth() {
		return personDateOfBirth;
	}
	public void setPersonDateOfBirth(Date personDateOfBirth) {
		this.personDateOfBirth = personDateOfBirth;
	}
	public int getPersonAge() {
		return personAge;
	}
	public void setPersonAge(int personAge) {
		this.personAge = personAge;
	}
	public String getPersonGender() {
		return personGender;
	}
	public void setPersonGender(String personGender) {
		this.personGender = personGender;
	}
	public String getPersonAddress() {
		return personAddress;
	}
	public void setPersonAddress(String personAddress) {
		this.personAddress = personAddress;
	}
	public int getPersonPhoneNo() {
		return personPhoneNo;
	}
	public void setPersonPhoneNo(int personPhoneNo) {
		this.personPhoneNo = personPhoneNo;
	}
	public String getPersonPassword() {
		return personPassword;
	}
	public void setPersonPassword(String personPassword) {
		this.personPassword = personPassword;
	}
}
