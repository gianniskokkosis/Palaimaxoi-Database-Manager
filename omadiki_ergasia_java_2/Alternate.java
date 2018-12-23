package omadiki_ergasia_java_2;

import java.util.ArrayList;
public class Alternate {

    public void deleteTable(ArrayList<ArrayList<String>> arl) {
        arl.clear();
    }

    public static void deleteRows(ArrayList<ArrayList<String>> arl, int x, String values) {
        arl.remove(x);
    }
    // klisi antikeimenou Create table
    public static void updateValues(int x,CreateTable table ) {
       
        for(int i = 0; i < table.getValues().size(); i++){
                if(i==x){
                    table.getValues().remove(x);
                    //table.getValues().add(x, values); edw vgazei error
                }
            
        }
    }
    
    public static void antimetathesi(){
        
    }
    
    public void a (CreateTable table){
        table.getValues().size();
    }
}
