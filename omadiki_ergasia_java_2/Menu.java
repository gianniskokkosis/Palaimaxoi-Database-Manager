package omadiki_ergasia_java_2;

import java.util.Scanner;
import java.util.ArrayList;


public class Menu {
	private static Scanner input = new Scanner(System.in);

	public static int starterMenu() {
		String userInput;
		int menuInput = 0;

		while ( (menuInput != 1 && menuInput != 2 && menuInput != 3 && menuInput != 4 && menuInput != 5
			&& menuInput != 6 && menuInput != 7 )) {
				System.out.println();
				System.out.println(" --- MENU ---");
				System.out.println("  1.Create a Table");
				System.out.println("  2.Insert data");
				System.out.println("  3.View data");
				System.out.println("  4.Search for Data");
				System.out.println("  5.Update Data");
				System.out.println("  6.Delete Data");
				System.out.println("  7.Exit");
				System.out.print("  Please type one of the above numbers. Your choice: ");
				userInput = input.nextLine();

				try {
					menuInput = Integer.parseInt(userInput);
				} catch (NumberFormatException e) {
					menuInput = -1;
					System.out.print(" Invalid input. Please try again.\n");
				}
			}
			return menuInput;
	}

	//Create Table menu
	public static CreateTable menuCreateTable() {
		String wordEnding;
		String userInput;
		String tableName = null;
		int numberOfColumns = 0;
		ArrayList<String> columns = new ArrayList<String>();

		while ( numberOfColumns <= 0 || (tableName == null || tableName.equals(""))  ) {
			System.out.println();
			System.out.println("  Please type the name of the Table.");
			tableName = input.nextLine();
			System.out.println("  Please type the number of columns the table should contain.\n  ");
			userInput = input.nextLine();

			try {
				numberOfColumns = Integer.parseInt(userInput);
			} catch (NumberFormatException e) {
				numberOfColumns = -1;
			}
		}
		for (int i = 1; i <= numberOfColumns; i++) {
			if (i == 1) {
				wordEnding = "st";
			} else if (i == 2) {
				wordEnding = "nd";
			} else if (i == 3) {
				wordEnding = "rd";
			} else {
				wordEnding = "th";
			}

			System.out.println("  Please type the name of the " + i + wordEnding +
				" column: \n  ");
			String nameOfColumns = input.nextLine();
			columns.add(nameOfColumns);
		}
		CreateTable table = new CreateTable(tableName, numberOfColumns, columns);
		System.out.println("  Your table has been created and is ready to accept data\n");
		return table;
	}

	public static void menu_Search_Retrive_Data() {
		//System.out.println("Please give the name of the Table you want to search.");
		//String table = input.next();
		System.out.println("Please give the value you want to search.");
		String value = input.next();
		//SearchRetriveData.searchData(table,value);

	}
}
