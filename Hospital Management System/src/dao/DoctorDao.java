package dao;

import java.sql.SQLException;
import java.util.TreeSet;

import bean.Doctor;

public interface DoctorDao {
	public boolean insertDoctor(Doctor newDoctor) throws ClassNotFoundException, SQLException;
	public boolean deleteDoctor(int doctorId) throws ClassNotFoundException, SQLException;
	public boolean updateDoctor(int doctorId, Doctor renewDoctor) throws ClassNotFoundException, SQLException;
	public Doctor displayDoctor(int doctorId) throws ClassNotFoundException, SQLException;
	public TreeSet<Doctor> displayAllDoctors() throws SQLException, ClassNotFoundException;
}
