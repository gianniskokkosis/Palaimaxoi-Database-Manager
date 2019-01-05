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
        for (int i = 0; i < table.getValues().size(); i++) {
            for (int j = 0; j < table.getValues().size(); j++) {
                if (value.equals(table.getValues().get(i).get(j))) {
                    find = true;
                    System.out.println(table.getName());
                    System.out.println(table.getColumnNames());
                    System.out.println(table.getValues().get(i));
                }
            }
        }

        if (find == false) {
            System.out.println("No values found mathcing with your input!");
        }
    }

    /*method that prints
    specific rows of the
    table that the user wants*/
    public static void printRows(CreateTable table, int from, int to) {
        System.out.println(table.getName());
        System.out.println(table.getColumnNames());
        System.out.print(" " + 0 + " ");
        System.out.println(table.getValues().get(0));
        for (int i = from; i <= to; i++) {
            System.out.print(" " + (i) + " ");
            System.out.println(table.getValues().get(i));
        }
    }

    /*method that prints
    the content of the table
    including the names of its columns*/
    public static void printTable(CreateTable table) {
        System.out.println(table.getName());
        System.out.println(table.getColumnNames());
        for (int i = 0; i < table.getValues().size(); i++) {
            System.out.print(" " + (i) + " ");
            System.out.println(table.getValues().get(i));
        }
        System.out.println();
    }

}
