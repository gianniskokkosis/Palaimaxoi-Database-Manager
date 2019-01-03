package omadiki_ergasia_java_2;

import java.util.Scanner;

public class Main{
    
    public static void main(String[]args){
        SearchRetriveData srd = new SearchRetriveData();
        TableProcessing tblp = new TableProcessing();
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        
        int a = Menus.starterMenu();

        if (a==1) {
           CreateTable table = Menus.menuCreateTable();
        }
        if (a==2){
            Menus.menu_Search_Retrive_Data();
        }
        if (a==3){
            Menus.menu_Table_Processing();
        }
        if(a==4){
            System.out.println("You have exist the palaimaxoi data base. We appreciate your preference!");
        }   
    }
}
