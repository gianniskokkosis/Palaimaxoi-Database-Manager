package omadiki_ergasia_java_2;

import java.util.ArrayList;

public class SearchRetriveData {

    public static ArrayList<String> searchData(ArrayList<ArrayList<String>> values, String value) {//Vazw ton pinaka san orisma gia na kserei panta h methodos se poion pinaka na psaksei
        ArrayList<String> array = new ArrayList<String>();
        for (int i = 0; i < values.size(); i++) {//prospelasi stis times tou pinaka
            for (int j = 0; j < values.get(i).size(); j++) {
                if (value.equals(values.get(i).get(j))) {//sinthiki pou an ali8euei epistrefei olokliri tin pleiada
                    array = values.get(i);
                    //epistrefei olokliri tin pleiada
                }
            }
        }
        return array;
    }

    public static String getMessage() {
        return "No values found";
    }// methodos pou xrisimopoieitai gia na epistrefei to antisoixo minima ston xristi ean den vrei kamia antisoixisi ston pinaka. Pio polu ti vazw gia na min epistrefei sketo null

}
