package junitTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bean.Department;

import dao.DepartmentDaoImpl;

public class DepartmentDaoImplTest {
	
	private DepartmentDaoImpl dd;

	@Before
	public void setUp() throws Exception {
		dd=new DepartmentDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		dd=null;
	}

	@Test
	public void testInsertDepartment() throws ClassNotFoundException, SQLException {
		Department department=new Department();
		department.setDepartmentId(0);
		department.setDepartmentLocation("Gurgaon");
		department.setDepartmentName("General");
		department.setDescription("dummyDescription");
		
		assertTrue(dd.insertDepartment(department));
	}

	@Test
	public void testDeleteDepartment() throws ClassNotFoundException, SQLException {
		//dummy values inserted manually
		assertTrue(dd.deleteDepartment(2));
		
	}

	@Test
	public void testUpdateDepartment() throws ClassNotFoundException, SQLException {
		
		Department department=new Department();
		
		department.setDepartmentLocation("Gurgaon");
		department.setDepartmentName("General");
		department.setDescription("dummyDescription");

		assertTrue(dd.updateDepartment(1, department));
		
	}

	@Test
	public void testDisplayDepartment() throws ClassNotFoundException, SQLException {
		
		Department department=new Department();
		department.setDepartmentId(3);
		department.setDepartmentLocation("dis location");
		department.setDepartmentName("xyz");
		department.setDescription("qwerty");
		
		assertEquals(department, dd.displayDepartment(3));
		
	}

	@Test
	public void testDisplayAllDepartments() throws ClassNotFoundException, SQLException {
		
		assertNotEquals(null, dd.displayAllDepartments());
		
	}

}
