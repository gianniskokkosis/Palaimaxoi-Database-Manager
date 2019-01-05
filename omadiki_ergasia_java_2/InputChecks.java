package omadiki_ergasia_java_2;import java.util.Scanner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InputChecks {
	private static Scanner input = new Scanner(System.in);

	//Checks if and ensures that the value typed is acceptable for the current menu
	public static void checkMenuInput(String userInput, int menuLimit) {

	}

	//Checks if the user types an acceptable value for the data type menu
	public static int checkDataDefinitonInput(String nameOfColumns) {
		int dataChoice = 0;
		String userInput;
		while( dataChoice <= 0 || dataChoice >= 5 ) {
			System.out.println("Please type the number corresponding to your desired data type for the '" +
			nameOfColumns + "'field. \n");
			userInput = input.nextLine();
			try {
				dataChoice = Integer.parseInt(userInput);
			} catch (NumberFormatException e) {
				dataChoice = -1;
				System.out.println( "\n  Wrong input. Please try again \n");
				userInput = input.nextLine();
			}
		}
		return dataChoice;
	}

	//Checks if the user types the correct data type for the current field
	//when inserting or updating
	public static boolean checkDataInput(int index, String userInput) {
		boolean isValid = true;
		int inputedInt;
		double inputedDouble;

		switch (index) {
			case 1:
				break;
			case 2:
				try {
					inputedInt = Integer.parseInt(userInput);
				} catch(NumberFormatException e) {
					inputedInt = 0;
					isValid = false;
					System.out.println("Wrong input. This field requires an" +
	       		" integer value (e.g. 87). Please try again ");
				}
				break;
			case 3:
				try {
					inputedDouble = Double.parseDouble(userInput);
				} catch(NumberFormatException e) {
					inputedDouble = 0;
					isValid = false;
					System.out.println("Wrong input. This field requires a" +
	       		" double value (e.g. 0.23). Please try again ");
				}
				break;
			case 4:
				isValid = isValidDate(userInput);
				break;
		}
		return isValid;
	}

	//Checks if the user input is a date in the correct format
	public static boolean isValidDate(String inDate) {
		boolean valid = true;
		DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
	    sourceFormat.setLenient(false);
	    try {
	    	sourceFormat.parse(inDate.trim());
	    } catch (ParseException pe) {
	        System.out.println("Wrong input. This field requires a" +
	       		" simple date format value (e.g. 01/01/2019). Please try again ");
	        valid = false;
	    }
		return valid;
    }

    public static int checkTableSize(int tableSize, String userInput ) {
		int choice = -1;
		while (choice <= 0 || choice >= tableSize) {
			try {
				choice = Integer.parseInt(userInput);
				if (choice >= tableSize) {
					System.out.println("Wrong input. The table contains only " +
						(tableSize - 1) + " rows. Please try again.");
					choice = -1;
					userInput = input.nextLine();
				}
			} catch(NumberFormatException e) {
				choice = -1;
				System.out.println("Wrong input. Please try again.");
				userInput = input.nextLine();
			}
		}
		return choice;
	}
}
