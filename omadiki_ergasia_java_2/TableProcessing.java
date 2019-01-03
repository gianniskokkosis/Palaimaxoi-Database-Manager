package omadiki_ergasia_java_2;

import java.util.ArrayList;

public class TableProcessing {

	public static void updateValues(CreateTable table, int x, ArrayList<String> values ) {
    	table.getValues().remove(x);
     	table.getValues().add(x, values);
    }

    public static void deleteTable(CreateTable table) {
        table.setTableName("");
        table.getColumnNames().clear();
        table.setNumberOfColumns(0);
        table.getValues().clear();
   }

    public static void deleteRows(CreateTable table, int from, int to) {
        if( from == to) {
			table.getValues().remove(from);
		} else if ( from > to) {
			System.out.println("The first index must be either equal or lesser than the second\n");
		} else if ( to > table.getValues().size()) {
			System.out.println("The specified table does not contain so many rows \n");
    	} else {
			for(int i = from; i < to; i++) {
				table.getValues().remove(i);
			}
		}
    }

    public static boolean checkForEmptyRows(CreateTable table) {
		boolean emptyRows = false;
		for(int i = 1; i < table.getValues().size(); i++) {
			if (table.getValues().get(i).isEmpty() == true) {
				emptyRows = true;
			}
		}
		return emptyRows;
    }
	/*
	public static void synchronize(CreateTable table) {

		ArrayList<String> temp = new ArrayList<String>();

		for(int i = 0; i < table.getValues().size() - 1; i++) {
			if (table.getValues().get(i).isEmpty()) {
				for(int j=0; j < table.getValues().get(i+1).size(); j++) {
					temp.add(table.getValues().get(i+1).get(j));
				}

				table.getValues().set( i, temp  );
				table.getValues().get(i+1).clear();
			}
		}
	} */
}
