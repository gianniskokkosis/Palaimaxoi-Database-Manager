package omadiki_ergasia_java_2;

import java.util.ArrayList;
public class Alternate {

    public void deleteTable(ArrayList<ArrayList<String>> arl) {
        arl.clear();
    }

    public static void deleteRows(ArrayList<ArrayList<String>> arl, int x) {
        arl.remove(x);
    }

    public static void updateValues(int x, ArrayList<ArrayList<String>> array, ArrayList<String> values ) {
       
        for(int i = 0; i < array.size(); i++){
            for (int j = 0; j < array.get(i).size(); j++) {
                if(i==x){
                    array.remove(x);
                    array.add(x, values);
                }
            }
        }
    }
    
    public static void antimetathesi(){
        
    }
}
