package omadiki_ergasia_java_2;

import java.util.Scanner;
import java.util.ArrayList;

public class CreateTable {

    private String tableName;
    private int numberOfColumns;
    private ArrayList<String> columnNames;
    private ArrayList<ArrayList<String>> values;

    //Constructor
    public CreateTable(String tableName, int numberOfColumns, ArrayList<String> columnNames) {
        this.tableName = tableName;
        this.numberOfColumns = numberOfColumns;
        this.columnNames = columnNames;
        this.values = new ArrayList<ArrayList<String>>();
        this.values.add(columnNames);
    }

    //setters
    public void setTableName(String name) {
        this.tableName = name;
    }

    public void setNumberOfColumns(int number) {
        this.numberOfColumns = number;
    }

    public void setColumnNames(ArrayList<String> names) {
        this.columnNames = names;
    }

    //getters
    public String getName() {
        return ("  " + this.tableName + "\n");
    }

    public int getNumberOfColumns() {
        return (this.numberOfColumns);
    }

    public ArrayList<String> getColumnNames() {
        return (this.columnNames);
    }

    public ArrayList<ArrayList<String>> getValues() {
        return (this.values);
    }

    //Adds a row of values to the table
    public void addRow(ArrayList<String> row) {
        ArrayList<String> newRow = new ArrayList<String>();

        for (int i = 0; i < row.size(); i++) {
            newRow.add(row.get(i));
        }

        this.values.add(newRow);
    }

    public static void main(String args[]) {

        String name = "Agenda";
        int number = 5;
        ArrayList<String> columns = new ArrayList<String>();

        columns.add("SURNAME");
        columns.add("FIRSTNAME");
        columns.add("PHONE");
        columns.add("EMAIL");
        columns.add("ADDRESS");

        ArrayList<ArrayList<String>> values = new ArrayList<ArrayList<String>>();
        CreateTable table = new CreateTable(name, number, columns);
        Scanner input = new Scanner(System.in);
        ArrayList<String> pleiada = new ArrayList<String>();

        pleiada.add("Papak");
        pleiada.add("Philip");
        pleiada.add("6984104787");
        pleiada.add("philipapakonstantinou@gamil.com");
        pleiada.add("Somewhere");

        table.addRow(pleiada);

        pleiada.clear();

        System.out.println();

        pleiada.add("Xatz");
        pleiada.add("Vas");
        pleiada.add("6984104787");
        pleiada.add("xatz@gamil.com");
        pleiada.add("Somewhere else");
        table.addRow(pleiada);
        pleiada.clear();

    }// END OF MAIN
}
