package businessLogic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Staff;
import bean.Ward;
import dao.StaffDaoImpl;
import dao.WardDaoImpl;

public class StaffBusinessLogic {

	StaffDaoImpl sd = new StaffDaoImpl();
	WardDaoImpl wd = new WardDaoImpl();
	//OTDaoImpl ot = new OTDaoImpl();
	
	public Staff staffLogin(int staffId, String staffPassword) throws ClassNotFoundException, SQLException, IOException
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
	
	public ArrayList<Ward> myWards(int staffId) throws ClassNotFoundException, SQLException, IOException
	{
		ArrayList<Ward> wardList=new ArrayList<Ward>();
		
		wardList=wd.displayAllWards();
		
		ArrayList<Ward> myWards=new ArrayList<Ward>();
		
		for(Ward wl: wardList)
		{
			if(wl.getStaffId()==staffId)
			{
				myWards.add(wl);
			}
		}
		
		return myWards;
		
	}
	
	public ArrayList<Ward> allWards() throws ClassNotFoundException, SQLException, IOException
	{
		ArrayList<Ward> wardList=new ArrayList<Ward>();
		
		wardList=wd.displayAllWards();

		return wardList;
		
	}
	
//	public ArrayList<OT> allOTs() throws ClassNotFoundException, SQLException
//	{
//		ArrayList<OT> otList=new ArrayList<OT>();
//		
//		otList=od.displayAllOTs();
//		
//		return otList;
//		
//	}
}
