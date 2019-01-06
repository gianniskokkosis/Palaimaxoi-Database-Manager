package omadiki_ergasia_java_2;

import java.util.ArrayList;

public class SearchRetrieveData {

    /*a method that searches
    the table with a specific value
    that the user enters and returns
    an arraylist with the whole
    set of tuples containing that value */
    public static void searchData(CreateTable table, String value) {
		boolean find = false;

        System.out.println("\nTable: " + table.getName());
        System.out.println("Columns: " + table.getColumnNames());

        for (int i = 0; i < table.getValues().size(); i++) {
            for (int j = 0; j < table.getValues().get(i).size(); j++) {
                if (value.equals(table.getValues().get(i).get(j))) {
                    find = true;
                    System.out.println(" " + i + " " + table.getValues().get(i));
                }
            }
        }

        if (find == false) {
            System.out.println("No values matching your input were found!");
        }
    }

    /*method that prints
    specific rows of the
    table that the user wants*/
    public static void printRows(CreateTable table, int from, int to) {
        for (int i = from; i <= to; i++) {
            System.out.println(" " + i + " " + table.getValues().get(i));
        }
    }

    /*method that prints
    the content of the table
    including the names of its columns*/
    public static void printTable(CreateTable table) {
        System.out.println("Table: " + table.getName());
        System.out.println("Columns: " + table.getColumnNames());

        for (int i = 1; i < table.getValues().size(); i++) {
            System.out.println(" " + i + " " + table.getValues().get(i));
        }
        System.out.println();
    }

}
