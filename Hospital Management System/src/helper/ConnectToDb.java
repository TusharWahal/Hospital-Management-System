package helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//import org.apache.log4j.Logger;

public class ConnectToDb {
	

	public static Connection openConnection() throws SQLException, ClassNotFoundException, IOException{
		
		FileInputStream fis=new FileInputStream("MyProp.prop");
		
		Properties p = new Properties();
		
		p.load(fis);
		
		String driver = p.getProperty("dn");
		String url = p.getProperty("url");
		String user = p.getProperty("user");
		String pwd = p.getProperty("pwd");
		
		Connection con;
		Class.forName(driver);
		//Connect to databases
		con=DriverManager.getConnection(url, user, pwd);
		
		return con;
		
	}
	public static void closeConnection(Connection con) throws SQLException
	{
		con.close();
	}
}
