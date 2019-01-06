package omadiki_ergasia_java_2;
/**
 * SearchRetrieveData provides all the  methods
 * necessary for the user and retrieve the data they have
 * inserted or to execute a (primitive) search.
 *
 * @authors: Palaimaxoi
 */

import java.util.ArrayList;

public class SearchRetrieveData {
	/**
     * Searches the entire table for a
     * specific value inputted by the user
     * and prints all the rows containing
     * the given value. If the given value is not
     * found the method prints an appropriate message.
     *
     * @param table
     * @param value
     */
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

     /**
     * Prints a specific range
     * of rows from the table
	 * defined by two inputted
	 * integer values.
	 *
	 * @param table
	 * @param from
	 * @param to
     */
    public static void printRows(CreateTable table, int from, int to) {
        for (int i = from; i <= to; i++) {
            System.out.println(" " + i + " " + table.getValues().get(i));
        }
    }

    /**
	* A method that prints the contents
	* of the whole table including its name and the names of
	* its columns.
	*
	* @param table
    */
    public static void printTable(CreateTable table) {
        System.out.println("Table: " + table.getName());
        System.out.println("Columns: " + table.getColumnNames());

        for (int i = 1; i < table.getValues().size(); i++) {
            System.out.println(" " + i + " " + table.getValues().get(i));
        }
        System.out.println();
    }

}
