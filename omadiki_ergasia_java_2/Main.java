package omadiki_ergasia_java_2;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	private static CreateTable table = null;
	private static String userInput;
	private	static int menuInput = 0;
	private static ArrayList<String> pleiada = new ArrayList<String>();

    public static void main(String[] args){
		System.out.println(" Welcome to the 'Palaimaxoi' Database Manager ");
		while (menuInput != 7) {
			menuInput = Menus.starterMenu();

			switch (menuInput) {
				case 1:
					table = Menus.menuCreateTable();
					break;
				case 2:
					if (table == null) {
						System.out.println("\nNo table was found! Please create a table first.\n");
					} else {
						Menus.InsertRowsMenu(table);
					}
					break;
				case 3:
					if (table == null) {
						System.out.println("\nNo table was found! Please create a table first.\n");
					} else {
						Menus.viewMenu(table);
					}
					break;
				case 4:
					if (table == null) {
						System.out.println("\nNo table was found! Please create a table first.\n");
					} else {
						userInput = Menus.searchMenu();
						SearchRetrieveData.searchData(table,userInput);
					}
					break;
				case 5:
					if (table == null) {
						System.out.println("\nNo table was found! Please create a table first.\n");
					} else {
						Menus.updateMenu(table);
					}
					break;
				case 6:
					if (table == null) {
						System.out.println("\nNo table was found! Please create a table first.\n");
					} else {
						Menus.deleteMenu(table);
					}
					break;
				case 7:
					break;
			}
		}
    	System.out.println("\nThank you for using our database manager. We appreciate your preference!\n");
	}
}
