package omadiki_ergasia_java_2;

import java.util.ArrayList;
/**
 * TableProcessing class provides all the necessary methods in order the user
 * can process his/her personal data.
 *
 * @authors Palaimaxoi
 */
public class TableProcessing {
    /**
     * Update specific values of the table in specific positions
     * of the table.
     *
     * @param table
     * @param index
     * @param values
     */
    public static void updateValues(CreateTable table, int index, ArrayList<String> values) {
        ArrayList<String> update = new ArrayList<String>();

        for (int i = 0; i < values.size(); i++) {
            update.add(values.get(i));
        }
        table.getValues().remove(index);
        table.getValues().add(index, update);
    }

    /**
     * Deletes the entire (existing) table that the user wants.
     *
     * @param table
     */
    public static void deleteTable(CreateTable table) {
        table.setTableName("");
        table.getColumnNames().clear();
        table.setNumberOfColumns(0);
        table.getValues().clear();
        table = null;
    }
    /**
     * Deletes a specific range of the table
     * defined two inputed integers numbers
     * that the user wants.
     *
     * @param table
     * @param from
     * @param to
     */
    public static void deleteRows(CreateTable table, int from, int to) {
        if (from == to) {
            table.getValues().remove(from);
        } else if (from > to) {
            System.out.println("The first index must be either equal or lesser than the second\n");
        } else if (to >= table.getValues().size()) {
            System.out.println("The specified table contains only" + (table.getValues().size() - 1) + "rows \n");
        } else {
            for (int i = from; i < to; i++) {
                table.getValues().remove(i);
            }
        }
    }
}
