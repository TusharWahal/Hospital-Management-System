package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDb {

	public static Connection openConnection() throws SQLException, ClassNotFoundException{
		
		Connection con;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connect to databases
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","sapient", "sapient");
		
		return con;
		
	}
	public static void closeConnection(Connection con) throws SQLException
	{
		con.close();
	}
}
