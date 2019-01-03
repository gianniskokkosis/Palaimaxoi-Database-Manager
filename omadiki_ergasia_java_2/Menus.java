package omadiki_ergasia_java_2;

import java.util.Scanner;
import java.util.ArrayList;

public class Menus {

    private static Scanner input = new Scanner(System.in);

    public static int starterMenu() {

        // TODO Auto-generated method stub
        // Main menu of Database
        int a = 0;
        boolean Continue = true;
        while (Continue == true) {
            System.out.println("Welcome to Palaimaxoi Database ");
            System.out.println("--- MENU ---");
            System.out.println(" 1.Create new Table");
            System.out.println(" 2.Search/Retrive Data");
            System.out.println(" 3.Other Functions");
            System.out.println(" 4.Exit");
            System.out.print("Make a choise:");

            a = input.nextInt();
            while (a != 1 && a != 2 && a != 3 && a != 4) {
                System.out.println("Invalid choice.Please select a choice from 1 to 4 ");
                System.out.println(" --- MENU ---");
                System.out.println(" 1.Create new Table");
                System.out.println(" 2.Search/Retrive Data");
                System.out.println(" 3.Other Functions");
                System.out.println(" 4.Exit");
                System.out.println("Make a choise:");
                a = input.nextInt();
            }
            Continue = false;
        }
        return a;
    }

    public static CreateTable menuCreateTable() {

        System.out.println("Please give the name of the Table.");
        String name = input.next();

        System.out.println("Please give the numbers of columns.");
        int numberOfColumns = input.nextInt();

        ArrayList<String> columns = new ArrayList<String>();

        for (int i = 1; i <= numberOfColumns; i++) {

            System.out.println("Please give the name of the " + i + " column: \n");

            String nameOfColumns = input.next();

            columns.add(nameOfColumns);
        }
        System.out.println(columns);
        System.out.println();
        CreateTable table = new CreateTable(name, numberOfColumns, columns);

        return table;
    }

    public static void menu_Search_Retrive_Data() {

    }

    public static void menu_Table_Processing() {

    }

}
