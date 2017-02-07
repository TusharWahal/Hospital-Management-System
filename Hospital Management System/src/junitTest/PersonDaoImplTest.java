package junitTest;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bean.Person;


import dao.PersonDaoImpl;

public class PersonDaoImplTest {

	private PersonDaoImpl pd;
	
	@Before
	public void setUp() throws Exception {
		pd=new PersonDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		pd=null;
	}

	@Test
	public void testInsertPerson() throws ClassNotFoundException, SQLException {
		
		pd.deletePerson(1);
		Person person=new Person();
		person.setPersonId("PatindId");
		person.setPersonIdType("Patient");
		person.setPersonName("XYZ");
		person.setPersonDateOfBirth(null);
		person.setPersonAge(16);
		person.setPersonGender("Male");
		person.setPersonAddress("Delhi");
		person.setPersonPhoneNo(25299266);
		person.setPersonPassword("pass");
		
		assertTrue(pd.insertPerson(person));
	}

	@Test
	public void testDeletePerson() throws ClassNotFoundException, SQLException {
		
		pd.deletePerson(1);
		Person person=new Person();
		person.setPersonId("PatienId");
		person.setPersonIdType("Patient");
		person.setPersonName("XYZ");
		person.setPersonDateOfBirth(null);
		person.setPersonAge(16);
		person.setPersonGender("Male");
		person.setPersonAddress("Delhi");
		person.setPersonPhoneNo(25299266);
		person.setPersonPassword("pass");
		pd.insertPerson(person);
		assertTrue(pd.deletePerson(1));
	}

	@Test
	public void testUpdatePerson() throws ClassNotFoundException, SQLException {
		
		pd.deletePerson(1);
		Person person=new Person();
		person.setPersonId("PatienId");
		person.setPersonIdType("Patient");
		person.setPersonName("XYZ");
		person.setPersonDateOfBirth(null);
		person.setPersonAge(16);
		person.setPersonGender("Male");
		person.setPersonAddress("Delhi");
		person.setPersonPhoneNo(25299266);
		person.setPersonPassword("pass");
		pd.insertPerson(person);
		
		
		Person newPerson=new Person();
		newPerson.setPersonId("PatientId");
		newPerson.setPersonIdType("Patient");
		newPerson.setPersonName("XYZ");
		newPerson.setPersonDateOfBirth(null);
		newPerson.setPersonAge(16);
		newPerson.setPersonGender("Male");
		newPerson.setPersonAddress("Delhi");
		newPerson.setPersonPhoneNo(28299266);
		newPerson.setPersonPassword("pass");
		pd.updatePerson(1,newPerson);
		
		assertEquals(newPerson.getPersonAddress(), pd.displayPerson(1).getPersonAddress());
	}

	@Test
	public void testDisplayPerson() throws ClassNotFoundException, SQLException {
		
		pd.deletePerson(1);
		Person person=new Person();
		person.setPersonId("PatientID");
		person.setPersonIdType("Patient");
		person.setPersonName("XYZ");
		person.setPersonDateOfBirth(null);
		person.setPersonAge(16);
		person.setPersonGender("Male");
		person.setPersonAddress("Delhi");
		person.setPersonPhoneNo(25299266);
		person.setPersonPassword("pass");
		pd.insertPerson(person);
		
		assertEquals(person, pd.displayPerson(1));
	}

	@Test
	public void testDisplayAllPersons() throws ClassNotFoundException, SQLException {
		
		TreeSet<Person> personList=new TreeSet<Person>();
		pd.deletePerson(1);
		Person person=new Person();
		person.setPersonId("PatientId");
		person.setPersonIdType("Patient");
		person.setPersonName("XYZ");
		person.setPersonDateOfBirth(null);
		person.setPersonAge(16);
		person.setPersonGender("Male");
		person.setPersonAddress("Delhi");
		person.setPersonPhoneNo(25299266);
		person.setPersonPassword("pass");
		personList.add(person);
		
		assertEquals(personList, pd.displayAllPersons());
	}

}
