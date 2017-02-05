package dao;

import java.util.TreeSet;

import bean.Person;

public interface PersonDao {
	public void insertPerson(Person newPerson);
	public Person deletePerson(int personId);
	public void updatePerson(int personId, Person renewPerson);
	public Person displayPerson(int personId);
	public TreeSet<Person> displayAllPersons();
}
