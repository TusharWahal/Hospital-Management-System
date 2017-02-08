package businessLogic;

import java.sql.SQLException;
import java.util.TreeSet;

import bean.Staff;
import bean.Ward;
import dao.StaffDaoImpl;
import dao.WardDaoImpl;

public class StaffBusinessLogic {

	StaffDaoImpl sd = new StaffDaoImpl();
	WardDaoImpl wd = new WardDaoImpl();
	//OTDaoImpl ot = new OTDaoImpl();
	
	public Staff staffLogin(int staffId, String staffPassword) throws ClassNotFoundException, SQLException
	{
		Staff staff;
		if(sd.displayStaff(staffId).getStaffId()==0)
		{
			return null;
		}
		else
		{
			staff=sd.displayStaff(staffId);
			if(staff.getStaffPassword().equals(staffPassword))
			{
				return staff;
			}
			else return null;
		}
	}
	
	public TreeSet<Ward> myWards(int staffId) throws ClassNotFoundException, SQLException
	{
		TreeSet<Ward> wardList=new TreeSet<Ward>();
		
		wardList=wd.displayAllWards();
		
		TreeSet<Ward> myWards=new TreeSet<Ward>();
		
		for(Ward wl: wardList)
		{
			if(wl.getStaffId()==staffId)
			{
				myWards.add(wl);
			}
		}
		
		return myWards;
		
	}
	
	public TreeSet<Ward> allWards() throws ClassNotFoundException, SQLException
	{
		TreeSet<Ward> wardList=new TreeSet<Ward>();
		
		wardList=wd.displayAllWards();

		return wardList;
		
	}
	
//	public TreeSet<OT> allOTs() throws ClassNotFoundException, SQLException
//	{
//		TreeSet<OT> otList=new TreeSet<OT>();
//		
//		otList=od.displayAllOTs();
//		
//		return otList;
//		
//	}
}
