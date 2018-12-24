package omadiki_ergasia_java_2;

import java.util.ArrayList;

public class SearchRetriveData {

    // klisi antikeimenou Create table
    public ArrayList<String> searchData(CreateTable table, String value) {//Vazw ton pinaka san orisma gia na kserei panta h methodos se poion pinaka na psaksei
        ArrayList<String> array = new ArrayList<>();
        for (int i = 0; i < table.getValues().size(); i++) {//prospelasi stis times tou pinaka
            for (int j = 0; j < table.getValues().size(); j++) {
                if (value.equals(table.getValues().get(i).get(j))) {//sinthiki pou an ali8euei epistrefei olokliri tin pleiada
                    array = table.getValues().get(i);//epistrefei olokliri tin pleiada 
                }else{
                    getMessage();
                }
            }
        }
        return null;
    }

    public static String getMessage() {
        return "No values found";
    }// methodos pou xrisimopoieitai gia na epistrefei to antisoixo minima ston xristi ean den vrei kamia antisoixisi ston pinaka. Pio polu ti vazw gia na min epistrefei sketo null
    
    public ArrayList<String> printSomeValues(int a, int b, CreateTable table){
        ArrayList<String> array = new ArrayList<>();
        for (int i = a; i <= b ; i++){
            array.addAll(table.getValues().get(i));
        }
        return array;
    }
}
