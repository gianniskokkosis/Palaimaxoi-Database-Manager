package omadiki_ergasia_java_2;

import java.util.Scanner;
import java.util.ArrayList;


public class Menus {
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

	//The insert data menu
	public static void insertRowsMenu(CreateTable table) {
		int numberOfRows = 0;
		String userInput;
		ArrayList<String> userAddedRow = new ArrayList<String>();

		while(numberOfRows <= 0) {
			System.out.println();
			System.out.println("  Please type the number of rows you wish to add: ");
			userInput = input.nextLine();

			try {
				numberOfRows = Integer.parseInt(userInput);
			} catch (NumberFormatException e) {
				numberOfRows = -1;
			}
		}
		for (int i = 1; i <= numberOfRows; i++) {
			System.out.println("  Please type values for the " + i + " row \n");
			for(int j = 0; j < table.getNumberOfColumns(); j++) {
				System.out.println("    Type a value for the field " + "'" +
					table.getColumnNames().get(j) + "'" + " : ");

					userInput = input.nextLine();
					userAddedRow.add(userInput);
			}
			table.addRow(userAddedRow);
			userAddedRow.clear();
		}
	}

	//The view data menu
	public static void viewMenu(CreateTable table) {
		int choice = 0;
		String input1;
		String input2;
		int int1 = 0;
		int int2 = 0;

		while(choice <= 0) {
			System.out.println();
			System.out.println("  --- VIEW DATA MENU ---");
			System.out.println("  1.Print the entire table");
			System.out.println("  2.Print specific rows ");
			System.out.println("  3.Back to start");
			System.out.print(" Please type one of the above numbers. Your choice: ");

			input1 = input.nextLine();

			try {
				choice = Integer.parseInt(input1);
			} catch(NumberFormatException e) {
				choice = -1;
			}
		}

		switch (choice) {
			case 1:
				SearchRetrieveData.printTable(table);
				break;
			case 2:
				System.out.println("\nPlease type two integers to define a range(e.g. 2 and 4). The rows of the table within the defined" +
				"range will be printed on the screen");
				input1 = input.nextLine();
				input2 = input.nextLine();

				while ( (int1 <= -1) || (int2 <= -1) || (int1 > int2) ) {
					System.out.println("  Please type two integers to define a range(e.g. 2 and 4). The rows of the table within the defined" +
					 	" range will be printed on the screen. \n ATTENTION!!! The first integer should be lesser or equal to the second.");
					input1 = input.nextLine();
					input2 = input.nextLine();

					try {
						int1 = Integer.parseInt(input1);
						int2 = Integer.parseInt(input2);

					} catch (NumberFormatException e) {
						int1 = -1;
						int2 = -1;
					}
				}

				SearchRetrieveData.printRows(table,int1,int2);
				break;
			case 3:
				break;
		}
	}

	//The search Menu
	public static String searchMenu() {
		System.out.println(" Please type the value you wish to search for.");
		String value = input.nextLine();
		return value;
	}

	//The update menu
	public static void updateMenu(CreateTable table) {
		ArrayList<String> update = new ArrayList<String>();

		System.out.println("  We reccomend viewing the contents of the table before selecting " +
			"which rows to update ");
		System.out.println("  Choose a row to update: " );
		int chosenRow = input.nextInt();
		String inputS;


		for(int i = 0; i< table.getColumnNames().size() - 1; i++) {
			System.out.println("  Type a value for the field " + "'" +
				table.getColumnNames().get(i) + "'" + " : ");
			inputS = input.nextLine();
			update.add(inputS);
		}
		TableProcessing.updateValues(table,chosenRow,update);
		System.out.println(" Your data has been succesfully updated");
	}

	//The delete menu
	public static void deleteMenu(CreateTable table) {
		int choice = 0;

		while( choice <= 0) {
			System.out.println("  --- DELETE MENU ---");
			System.out.println("  1.Delete Table");
			System.out.println("  2.Delete Rows");
			System.out.println("  3.Back to start");
			System.out.print("  Your choice: ");
			String userInput = input.nextLine();

			try {
		 		choice = Integer.parseInt(userInput);
			} catch (NumberFormatException e) {
				choice = -1;
			}
		}
		switch(choice) {
			case 1:
				TableProcessing.deleteTable(table);
				break;
			case 2:
				int int1,int2;
				String input1;
				String input2;

				System.out.println("  Please type two integers to define a range(e.g. 2 and 4). The rows of the table within the defined" +
					" range will be deleted.");

				input1 = input.nextLine();
				input2 = input.nextLine();

				try {
				 	int1 = Integer.parseInt(input1);
				 	int2 = Integer.parseInt(input2);

				} catch (NumberFormatException e) {
					int1 = -1;
					int2 = -1;
				}
				while ( (int1 == -1) || (int2 == -1) || (int1 > int2) ) {
					System.out.println("  Please type two integers to define a range(e.g. 2 and 4). The rows of the table within the defined" +
					 	" range will be deleted. \n ATTENTION!!! The first integer should be lesser or equal to the second.");
					input1 = input.nextLine();
					input2 = input.nextLine();

					try {
						int1 = Integer.parseInt(input1);
						int2 = Integer.parseInt(input2);
					} catch (NumberFormatException e) {
						int1 = -1;
						int2 = -1;
					}
				}
				TableProcessing.deleteRows(table,int1,int2);
				break;
			case 3:
				break;
		}
	}
}
