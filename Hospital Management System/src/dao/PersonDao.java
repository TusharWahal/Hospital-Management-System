package dao;

import java.sql.SQLException;
import java.util.TreeSet;

import bean.Person;

public interface PersonDao {
	public void insertPerson(Person newPerson) throws SQLException, ClassNotFoundException;
	public boolean deletePerson(int personId) throws ClassNotFoundException, SQLException;
	public void updatePerson(int personId, Person renewPerson) throws ClassNotFoundException, SQLException;
	public Person displayPerson(int personId) throws ClassNotFoundException, SQLException;
	public TreeSet<Person> displayAllPersons() throws ClassNotFoundException, SQLException;
}
