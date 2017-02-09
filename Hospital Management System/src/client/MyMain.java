package client;

import java.io.IOException;
import java.sql.SQLException;

import ui.MyMenu;

public class MyMain {

	public static void main(String[] args) {
		try {
			MyMenu menu=new MyMenu();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
