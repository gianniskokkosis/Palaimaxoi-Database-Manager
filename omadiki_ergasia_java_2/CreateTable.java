package omadiki_ergasia_java_2;
import java.util.*;

public class CreateTable {

	private String tableName;
	private ArrayList<String> columnNames;
	private ArrayList<ArrayList<String>> values;

	//Constructor
	public CreateTable(String tableName, ArrayList<String>  columnNames, ArrayList<ArrayList<String>> values) {
		this.tableName = tableName;
		this.columnNames = columnNames;
		this.values = values;
		this.values.add(columnNames);
	}

	//Adds a row of values to the table
	public void addRow(ArrayList<String> row) {
			this.values.add(row);
	}

	//returns the table's name
		public String getName() {
			return ("  " + this.tableName + "\n");
	}

	//Prints the contents of the table invluding the names of its columns
	public void printTable() {

		for(int i = 0; i < this.values.size(); i++) {
			System.out.print(" " + (i) + " ");
			System.out.println(this.values.get(i));
		}
		System.out.println();
	}



	public static void main(String args[]) {

		String name = "Agenda";
		ArrayList<String> columns = new ArrayList<String>();

		columns.add("SURNAME");
		columns.add("FIRSTNAME");
		columns.add("PHONE");
		columns.add("EMAIL");
		columns.add("ADDRESS");

		ArrayList<ArrayList<String>> values = new ArrayList<ArrayList<String>>();

		CreateTable table = new CreateTable(name,columns, values);

		ArrayList<String> pleiada = new ArrayList<String>();

		pleiada.add("Papak");
		pleiada.add("Philip");
		pleiada.add("6984104787");
		pleiada.add("philipapakonstantinou@gamil.com");
		pleiada.add("Somewhere");

		table.addRow(pleiada);

		//System.out.println(table.columnNames);

		System.out.println(table.getName());

		table.printTable();

	}// END OF MAIN
}
