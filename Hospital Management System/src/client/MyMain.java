package client;

import java.util.Scanner;

import ui.MyMenu;

public class MyMain {

	public static void main(String[] args) {
		MyMenu menu=new MyMenu();
		Scanner sc=new Scanner(System.in);
		while(true){
			menu.homeMenu();
		}
	}

}
