package omadiki_ergasia_java_2;

import java.util.ArrayList;

public class SearchRetriveData {

    public ArrayList<String> searchData(ArrayList<ArrayList<String>> values, String value) {//Vazw ton pinaka san orisma gia na kserei panta h methodos se poion pinaka na psaksei
        for (int i = 0; i < values.size(); i++) {//prospelasi stis times tou pinaka
            if (value.equals(values.get(i))) {//sinthiki pou an ali8euei epistrefei olokliri tin pleiada 
                return values.get(i);//epistrefei olokliri tin pleiada
            } else {
                getMessage();//minima oti den vrike antistoixisi ston pinaka me tin timi pou eidigage o xristis
                return null;
            }
        }
        return null;
    }

    public static String getMessage() {
        return "No values found";
    }// methodos pou xrisimopoieitai gia na epistrefei to antisoixo minima ston xristi ean den vrei kamia antisoixisi ston pinaka. Pio polu ti vazw gia na min epistrefei sketo null

}
