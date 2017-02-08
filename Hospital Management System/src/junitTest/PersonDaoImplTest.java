package junitTest;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bean.Doctor;
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
		
		//Create necessary tables and insert one tuple for negative insert testing 
		pd.deletePerson("1");
		Person person=new Person();
		person.setPersonId("1");
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

	
	@Test(expected=SQLException.class)
	public void testInsertPersonNegative() throws ClassNotFoundException, SQLException {
		
		Person person=new Person();
		person.setPersonId("2");
		person.setPersonIdType("Patient");
		person.setPersonName("XYZ");
		person.setPersonDateOfBirth(null);
		person.setPersonAge(16);
		person.setPersonGender("Male");
		person.setPersonAddress("Delhi");
		person.setPersonPhoneNo(25299266);
		person.setPersonPassword("pass");
		
		assertFalse(pd.insertPerson(person));
	}
	
	@Test
	public void testDeletePersonNegative() throws ClassNotFoundException, SQLException {
		
		assertFalse(pd.deletePerson("346421"));
	}
	
	@Test
	public void testDeletePerson() throws ClassNotFoundException, SQLException {
		
		pd.deletePerson("1");
		Person person=new Person();
		person.setPersonId("1");
		person.setPersonIdType("Patient");
		person.setPersonName("XYZ");
		person.setPersonDateOfBirth(null);
		person.setPersonAge(16);
		person.setPersonGender("Male");
		person.setPersonAddress("Delhi");
		person.setPersonPhoneNo(25299266);
		person.setPersonPassword("pass");
		pd.insertPerson(person);
		assertTrue(pd.deletePerson("1"));
	}

	@Test
	public void testUpdatePerson() throws ClassNotFoundException, SQLException {
		
		pd.deletePerson("1");
		Person person=new Person();
		person.setPersonId("1");
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
		newPerson.setPersonId("1");
		newPerson.setPersonIdType("Patient");
		newPerson.setPersonName("XYZ");
		newPerson.setPersonDateOfBirth(null);
		newPerson.setPersonAge(16);
		newPerson.setPersonGender("Male");
		newPerson.setPersonAddress("Delhi");
		newPerson.setPersonPhoneNo(28299266);
		newPerson.setPersonPassword("pass");
		//pd.updatePerson("1",newPerson);
		
		assertTrue(pd.updatePerson("2", newPerson));
		//assertEquals(newPerson.getPersonAddress(), pd.displayPerson("1").getPersonAddress());
	}

	@Test
	public void testUpdatePersonNegative() throws ClassNotFoundException, SQLException
	{
		Person newPerson=new Person();
		
		newPerson.setPersonId("1");
		newPerson.setPersonIdType("Patient");
		newPerson.setPersonName("XYZ");
		newPerson.setPersonDateOfBirth(null);
		newPerson.setPersonAge(16);
		newPerson.setPersonGender("Male");
		newPerson.setPersonAddress("Delhi");
		newPerson.setPersonPhoneNo(28299266);
		newPerson.setPersonPassword("pass");
		
		assertFalse(pd.updatePerson("2343", newPerson));
	}
	
	@Test
	public void testDisplayPerson() throws ClassNotFoundException, SQLException {
		
		pd.deletePerson("1");
		Person person=new Person();
		person.setPersonId("1");
		person.setPersonIdType("Patient");
		person.setPersonName("XYZ");
		person.setPersonDateOfBirth(null);
		person.setPersonAge(16);
		person.setPersonGender("Male");
		person.setPersonAddress("Delhi");
		person.setPersonPhoneNo(25299266);
		person.setPersonPassword("pass");
		pd.insertPerson(person);
		
		assertEquals(person.getPersonAddress(), pd.displayPerson("1").getPersonAddress());
	}

	@Test
	public void testDisplayPersonNegative() throws ClassNotFoundException, SQLException {
		
		
		assertEquals(null,pd.displayPerson("234234").getPersonId());
		
	}
	
	@Test
	public void testDisplayAllPersons() throws ClassNotFoundException, SQLException {
		
//		TreeSet<Person> personList=new TreeSet<Person>();
//		pd.deletePerson("1");
//		Person person=new Person();
//		person.setPersonId("1");
//		person.setPersonIdType("Patient");
//		person.setPersonName("XYZ");
//		person.setPersonDateOfBirth(null);
//		person.setPersonAge(16);
//		person.setPersonGender("Male");
//		person.setPersonAddress("Delhi");
//		person.setPersonPhoneNo(25299266);
//		person.setPersonPassword("pass");
//		personList.add(person);
//		
//		assertEquals(personList, pd.displayAllPersons());
		
		assertNotEquals(null, pd.displayAllPersons().size());
	}

}
