package omadiki_ergasia_java_2;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * The 'Menus' class provides all the necessary methods in order the user can interact
 * with the system/program.
 *
 * @author Palaimaxoi
 */
public class Menus {
	private static Scanner input = new Scanner(System.in);

	/**
	 * Displays the options available to the user of
	 * the program.
	 *
	 *
	 * @return The user's choice.
	 */
	public static int starterMenu() {
		String userInput;
		int menuInput = 0;

		System.out.println("\n--- MENU ---");
		System.out.println(" 1.Create a Table");
		System.out.println(" 2.Insert data");
		System.out.println(" 3.View data");
		System.out.println(" 4.Search for Data");
		System.out.println(" 5.Update Data");
		System.out.println(" 6.Alter Table");
		System.out.println(" 7.Delete Data");
		System.out.println(" 8.Exit");

		while ( (menuInput != 1 && menuInput != 2 && menuInput != 3 && menuInput != 4 && menuInput != 5
			&& menuInput != 6 && menuInput != 7 && menuInput != 8 )) {
			System.out.print("Please type one of the above numbers. Your choice: ");
			userInput = input.nextLine();
			try {
				menuInput = Integer.parseInt(userInput);
			} catch (NumberFormatException e) {
				menuInput = -1;
				System.out.print("Invalid input. Please try again.\n");
			}
		}
		return menuInput;
	}

	/**
	 * Prints the menu of the choice CreateTable of the starter menu and
	 * provides all the necessary functions to the user in order to create a
	 * CreateTable object.
	 *
	 * @return the CreateTeble object that the user has created.
     */
	public static CreateTable menuCreateTable() {
		String wordEnding;
		String userInput;
		String tableName = null;
		int numberOfColumns = 0;
		ArrayList<String> columns = new ArrayList<>();
		ArrayList<Integer> dataTypes = new ArrayList<>();

		while ( numberOfColumns <= 0 || (tableName == null || tableName.equals(""))  ) {
			System.out.println();
			System.out.println("Please type the name of the Table.");
			tableName = input.nextLine();
			System.out.println("Please type the number of columns the table should contain.");
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

			System.out.println("Please type the name of the " + i + wordEnding +
				" column: ");
			String nameOfColumns = input.nextLine();
			columns.add(nameOfColumns);
			System.out.println("\n---DATA DEFINITION MENU ---");
			System.out.println("1.Varchar (string/text)");
			System.out.println("2.Integer");
			System.out.println("3.Real (double)");
			System.out.println("4.Date (simple format: dd/MM/yyyy)");

			int dataChoice = InputChecks.checkDataDefinitonInput(nameOfColumns);
			dataTypes.add(dataChoice);
		}
		CreateTable table = new CreateTable(tableName, numberOfColumns, columns, dataTypes);
		System.out.println("Your table has been successfully created and is ready to accept data\n");
		return table;
	}

	/**
	 * Prints the menu of insert rows menu and asks the user the number of
	 * columns he/she wants to add. It also asks the user the name of the
	 * column's he/she wants to give, how many rows he/she wants to save and
	 * finally stores the data into the table(CreateTable object).
	 *
	 * @param table
	 * @return void
     */
	public static void insertRowsMenu(CreateTable table) {
		int numberOfRows = 0;
		String userInput = "";
		boolean  isValid;
		ArrayList<String> userAddedRow = new ArrayList<String>();

		while(numberOfRows <= 0) {
			System.out.println();
			System.out.println("Please type the number of rows you wish to add: ");
			userInput = input.nextLine();

			try {
				numberOfRows = Integer.parseInt(userInput);
			} catch (NumberFormatException e) {
				numberOfRows = -1;
			}
		}

		for (int i = 1; i <= numberOfRows; i++) {
			System.out.println("Please type values for the " + i + " row \n");
			for(int j = 0; j < table.getNumberOfColumns(); j++) {
				isValid = false;
				while (isValid == false ) {
					System.out.println("Type a value for the field " + "'" +
						table.getColumnNames().get(j) + "'" + ": ");

					userInput = input.nextLine();

					isValid = InputChecks.checkDataInput(table.getDataTypes().get(j),
						userInput);
				}
				userAddedRow.add(userInput);
			}
			table.addRow(userAddedRow);
			userAddedRow.clear();
		}

		System.out.println("Your data has been successfully inserted.");
	}

	/**
	 * Prints the basic data types that the table can save and carries out
	 * validations of the data entered by the user.
	 *
	 * @param table
     */
	public static void viewMenu(CreateTable table) {
		int choice = 0;
		String input1;
		String input2;
		int int1 = -1;
		int int2 = -1;

		while(choice <= 0 || choice > 3) {
			System.out.println();
			System.out.println("\n--- VIEW DATA MENU ---");
			System.out.println("1.Print the entire table");
			System.out.println("2.Print specific rows ");
			System.out.println("3.Back to start");
			System.out.print("Please type one of the above numbers. Your choice: ");

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
				while ( (int1 < 0) || (int2 < 0) || (int1 > int2)) {

					System.out.println("Please type two integers to define a range(e.g. 2 and 4). The rows of the table within the defined" +
					 	" range will be printed on the screen.\nATTENTION!!! The first integer should be lesser or equal to the second.\n");
					input1 = input.nextLine();
					input2 = input.nextLine();

					try {
						int1 = Integer.parseInt(input1);
						int2 = Integer.parseInt(input2);

					} catch (NumberFormatException e) {
						int1 = -1;
						int2 = -1;
					}
					if( (int1 >= table.getValues().size()) || (int2 >= table.getValues().size()) ) {
						System.out.println("The table does not contain so many rows. It only contains: " + (table.getValues().size()-1));
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

	/**
	 * Requests from the user to type a value
     * he/she wishes to search for.
     *
	 * @return the value entered by the user.
     */
	public static String searchMenu() {
		System.out.println("Please type the value you wish to search for.");
		String value = input.nextLine();
		return value;
	}

	/**
	 * Prints the menu of update menu and allow the user to update the values of
	 * the table(CreateTable object).
	 *
	 * @param table
     */
	public static void updateMenu(CreateTable table) {
		int chosenRow = 0;
		String userInput;
		boolean isValid;
		ArrayList<String> update = new ArrayList<String>();

		System.out.println("Choose a row to update: " );
		userInput = input.nextLine();


		chosenRow = InputChecks.checkTableSize(table.getValues().size(), userInput);


		for(int i = 0; i< table.getColumnNames().size(); i++) {
			isValid = false;
			while (isValid == false ) {
				System.out.println("Type a value for the field " + "'" +
					table.getColumnNames().get(i) + "'" + " : ");
				userInput = input.nextLine();

				isValid = InputChecks.checkDataInput(table.getDataTypes().get(i), userInput);
			}
			update.add(userInput);
		}
		TableProcessing.updateValues(table,chosenRow,update);
		update.clear();
		System.out.println("Your data has been succesfully updated");
	}

	/**
	 *Prints the options available for altering the table
	 *and depending on the user's choice perform the neccessary
	 *changes using the proper methods
	 *
	 * @param CreateTable object
	 * @return CreateTable object
	 */
	public static CreateTable alterMenu(CreateTable table) {
		int choice = -1;
		String userInput;

		while( choice <= 0 || choice > 5) {
			System.out.println("\n--- ALTER MENU ---");
			System.out.println("1.Add Column");
			System.out.println("2.Remove Column");
			System.out.println("3.Rename table");
			System.out.println("4.Rename Column");
			System.out.println("5.Back to start");
			System.out.print("Your choice: ");

			userInput = input.nextLine();

			try {
				choice = Integer.parseInt(userInput);
			} catch(NumberFormatException e) {
				choice = -1;
				System.out.println("\nWrong input, please try again\n");
			}
		}

		switch(choice) {

			case 1:
				System.out.println("Insert a name for the new column");
				String newColumnName = input.nextLine();

				System.out.println("\n---DATA DEFINITION MENU ---");
				System.out.println("1.Varchar (string/text)");
				System.out.println("2.Integer");
				System.out.println("3.Real (double)");
				System.out.println("4.Date (simple format: dd/MM/yyyy)");

				int dataChoice = InputChecks.checkDataDefinitonInput(newColumnName);

				table.getDataTypes().add(dataChoice);
				table.getColumnNames().add(newColumnName);
				table.setNumberOfColumns(table.getNumberOfColumns() + 1);

				if (table.getValues().size() > 1) {
					for(int i = 1; i < table.getValues().size(); i++) {
						table.getValues().get(i).add("");
					}
				}

				break;
			case 2:
				System.out.println("These are the names of the existing columns");
				for(int i = 0; i < table.getColumnNames().size(); i++) {
					System.out.println( i + " " + table.getColumnNames().get(i));
				}
				System.out.println("Your choice: ");

				userInput = input.nextLine();

				try {
					choice = Integer.parseInt(userInput);
				} catch(NumberFormatException e) {
					choice = -1;
				}

				while ( choice < 0 || choice > table.getNumberOfColumns()) {
					System.out.println("\nWrong input, please try again\n");
					userInput = input.nextLine();

					try {
						choice = Integer.parseInt(userInput);
					} catch(NumberFormatException e) {
						choice = -1;
					}
				}

				table.getColumnNames().remove(choice);
				table.getDataTypes().remove(choice);
				table.setNumberOfColumns(table.getNumberOfColumns() - 1);

				if (table.getValues().size() > 1) {
					for(int i = 1; i < table.getValues().size(); i++) {
						table.getValues().get(i).remove(choice);
					}
				}

				break;
			case 3:
				System.out.println("Current table name: " + table.getName());
				System.out.println("Please type a new name for this table: ");
				userInput = input.nextLine();
				table.setTableName(userInput);
				System.out.println("\nThe table's name has been updated! \n");
				break;
			case 4:
				System.out.println("These are the names of the existing columns");
				for(int i = 0; i < table.getColumnNames().size(); i++) {
					System.out.println( i + " " + table.getColumnNames().get(i));
				}
				System.out.println("Pleaset type the number corresponding to the column" +
					" whose name you wish to change. Your choice: ");

				userInput = input.nextLine();

				try {
					choice = Integer.parseInt(userInput);
				} catch(NumberFormatException e) {
				choice = -1;
				}
				while ( choice < 0 || choice > table.getNumberOfColumns()) {
					System.out.println("\nWrong input, please try again\n");
					userInput = input.nextLine();

					try {
						choice = Integer.parseInt(userInput);
					} catch(NumberFormatException e) {
						choice = -1;
					}
				}
				System.out.println("Please type a new name for that column: ");
				userInput = input.nextLine();
				table.getColumnNames().remove(choice);
				table.getColumnNames().add(choice,userInput);
				System.out.println("\nThe column's name has been updated: \n");
				break;
			case 5:
				break;

		}
		return table;
	}


	/**
	 * Prints the options of delete menu. The user can delete the whole table or
	 * delete specific rows of the table or go back to the starter menu
	 * and returns a boolean value. True if the table is to be dropped,
	 * false otherwise
	 *
	 * @param CreateTable object
	 * @return boolean
     */
	public static boolean deleteMenu(CreateTable table) {
		int choice = 0;
		boolean deletion = false;

		while( choice <= 0 || choice > 3) {
			System.out.println("\n--- DELETE MENU ---");
			System.out.println("1.Delete Table");
			System.out.println("2.Delete Rows");
			System.out.println("3.Back to start");
			System.out.print("Your choice: ");
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
				deletion = true;
				System.out.println("\nThe table has been dropped!\n");
				break;
			case 2:
				int int1,int2;
				String input1;
				String input2;

				System.out.println("Please type two integers to define a range(e.g. 2 and 4). The rows of the table within the defined" +
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
					System.out.println("Please type two integers to define a range(e.g. 2 and 4). The rows of the table within the defined" +
					 	" range will be deleted.\nATTENTION!!! The first integer should be lesser or equal to the second.");
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
		return deletion;
	}
}
