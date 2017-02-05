package dao;

import java.util.TreeSet;

import bean.Doctor;

public interface DoctorDao {
	public void insertDoctor(Doctor newDoctor);
	public Doctor deleteDoctor(int doctorId);
	public void updateDoctor(int doctorId, Doctor renewDoctor);
	public Doctor displayDoctor(int doctorId);
	public TreeSet<Doctor> displayAllDoctors();
}
