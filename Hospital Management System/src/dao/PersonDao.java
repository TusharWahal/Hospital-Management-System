package dao;

import java.sql.SQLException;
import java.util.TreeSet;

import bean.Person;

public interface PersonDao {
	public boolean insertPerson(Person newPerson) throws SQLException, ClassNotFoundException;
	public boolean deletePerson(String personId) throws ClassNotFoundException, SQLException;
	public boolean updatePerson(String personId, Person renewPerson) throws ClassNotFoundException, SQLException;
	public Person displayPerson(String personId) throws ClassNotFoundException, SQLException;
	public TreeSet<Person> displayAllPersons() throws ClassNotFoundException, SQLException;
}
