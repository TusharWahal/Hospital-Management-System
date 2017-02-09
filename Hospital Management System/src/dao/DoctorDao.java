package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Doctor;

public interface DoctorDao {
	public boolean insertDoctor(Doctor newDoctor) throws ClassNotFoundException, SQLException, IOException;
	public boolean deleteDoctor(int doctorId) throws ClassNotFoundException, SQLException, IOException;
	public boolean updateDoctor(int doctorId, Doctor renewDoctor) throws ClassNotFoundException, SQLException, IOException;
	public Doctor displayDoctor(int doctorId) throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Doctor> displayAllDoctors() throws SQLException, ClassNotFoundException, IOException;
}
