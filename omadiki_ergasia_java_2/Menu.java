
package omadiki_ergasia_java_2;
import java.util.Scanner;

public class Menu {

	public static void startermenu() {

		// TODO Auto-generated method stub
		// Main menu of Database
		int a;
		boolean Continue = true;
		while (Continue == true) {
			System.out.println("Welcome to Palaimaxoi Database ");
			System.out.println("--- MENU ---");
			System.out.println("1.Create new Table");
			System.out.println("2.Search/Retrive Data");
			System.out.println("3.Other Functions");
			System.out.println("4.Exit");
			System.out.print("Make a choise:");
			Scanner inp = new Scanner(System.in);
			a = inp.nextInt();
			while (a != 1 && a != 2 && a != 3 && a != 4) {
				System.out.println("Invalid choice.Please select a choice from 1 to 4 ");
				System.out.println("--- MENU ---");
				System.out.println("1.Create new Table");
				System.out.println("2.Search/Retrive Data");
				System.out.println("3.Other Functions");
				System.out.println("4.Exit");
				System.out.print("Make a choise:");
				a = inp.nextInt();
			}
		}
		switch (a) {

		case 1:
			 menu_createtable();
		case 2:
			 menu_Search_Retrive_Data();
		case 3:
			 menu_Other_Functions();
		case 4:
			Continue = false;
		}
	}

	public static void menu_createtable() {

	}

	public static void menu_Search_Retrive_Data() {

	}

	public static void menu_Other_Functions() {

	}

}
