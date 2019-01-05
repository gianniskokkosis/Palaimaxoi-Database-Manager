package omadiki_ergasia_java_2;

import java.util.ArrayList;

public class CreateTable {
	private String tableName;
	private int numberOfColumns;
	private ArrayList<String> columnNames;
	private ArrayList<Integer> dataTypes;
    private ArrayList<ArrayList<String>> values;

  	//Constructor
	public CreateTable(String tableName, int numberOfColumns, ArrayList<String> columnNames,
    	ArrayList<Integer> dataTypes) {

    	this.tableName = tableName;
        this.numberOfColumns = numberOfColumns;
        this.columnNames = columnNames;
        this.dataTypes = dataTypes;
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

    public void setDataTypes(ArrayList<Integer> dataTypes) {
		this.dataTypes = dataTypes;
	}//end of setters

    //getters
    public String getName() {
        return ("  " + this.tableName + "");
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

    public ArrayList<Integer> getDataTypes() {
		return this.dataTypes;
	}//end of getters

    //Adds a row of values to the table
    public void addRow(ArrayList<String> row) {
    	ArrayList<String> newRow = new ArrayList<String>();

        for (int i = 0; i < row.size(); i++) {
            newRow.add(row.get(i));
        }
    	this.values.add(newRow);
    }
}
