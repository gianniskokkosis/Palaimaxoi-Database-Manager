package java2;

import java.util.ArrayList;

public class Alternate {

	public void deleteTable(ArrayList<ArrayList<String>>arl) {
		arl.clear();
	}
	public void deleteRows(ArrayList<ArrayList<String>>arl,int x) {
		arl.remove(x);
	}
	public static void updateValues(ArrayList<ArrayList<String>>arl,int x,ArrayList<String>) {
		for(int i=0; i=arl.lenght(); i++) {
			if (i==x) {
				arl.remove(x);
				set(x,ArrayList(String));
			}
		}
	}

}
