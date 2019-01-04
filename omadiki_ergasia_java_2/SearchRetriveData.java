package omadiki_ergasia_java_2;

import java.util.ArrayList;

public class SearchRetriveData {

    /*a method that searches
    the table with a specific value
    that the user enters and returns
    an arraylist with the whole
    set of tuples containing that value */
    public ArrayList<String> searchData(CreateTable table, String value) {
        ArrayList<String> array = new ArrayList<>();
        boolean find = false;
        for (int i = 0; i < table.getValues().size(); i++) {
            for (int j = 0; j < table.getValues().size(); j++) {
                if (value.equals(table.getValues().get(i).get(j))) {
                    array = table.getValues().get(i);
                    find = true;
                    break;
                } else {
                    continue;
                }
            }
        }
        
        if (find == true){
            return array;
        }else{
            getMessage();
            return null;
        }
    }

    /*method that returns a message
      if there is no such values 
      in the table (look searchData method)*/
    public static String getMessage() {
        return "No values found";
    }

    /*method that prints
    specific rows of the
    table that the user wants*/
    public static ArrayList<String> printSomeValues(int a, int b, CreateTable table) {
        ArrayList<String> array = new ArrayList<>();
        for (int i = a; i <= b; i++) {
            array.addAll(table.getValues().get(i));
        }
        return array;
    }

    /*method that prints
    the content of the table
    including the names of its columns*/
    public static void printTable(CreateTable table) {

        for (int i = 0; i < table.getValues().size(); i++) {
            System.out.print(" " + (i) + " ");
            System.out.println(table.getValues().get(i));
        }
        System.out.println();
    }

}
